package com.archforce.domain.utils;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class DomainConfigUtil {
    public DomainConfigUtil() {
    }
    public Integer getAppId(String app, Map<String, String> connectParams) {
        Integer appId = 0;

        try {
            if (((String)connectParams.get("type")).equals(Constant.START_TYPE_DB.toString())) {
                if (isInteger(app)) {
                    appId = Integer.parseInt(app);
                } else {
                    List<Map<String, Object>> list = this.query(connectParams, "SELECT app_id FROM t_app WHERE app_name='%s'", app);
                    if (CollectionUtils.isEmpty(list)) {
                        throw new RuntimeException("There is no app named '" + app + "'in table t_app");
                    }
                    appId = Integer.parseInt(((Map)list.get(0)).get("app_id").toString());
                }
            } else {
                this.getRestParams(connectParams, "");
                appId = 0;
            }
            return appId;
        } catch (Exception var5) {
            throw new RuntimeException("Query app(" + app + ") parameter fail, message:" + var5.getMessage());
        }
    }

    public List<Map<String, Object>> getModuleParams(Map<String, String> connectParams, Integer appId, String moduleCode) {
        return this.query(connectParams, "SELECT module_code,para_name,para_value,is_encrypt FROM t_sys_parameter WHERE app_id=%s AND module_code='%s' AND status = 1 AND (broker_code is null OR broker_code = '')", appId, moduleCode);
    }

    public List<Map<String, Object>> getBrokerParams(Map<String, String> connectParams, Integer appId, String moduleCode, String brokerCode) {
        return this.query(connectParams, "SELECT module_code,para_name,para_value,is_encrypt as count FROM t_sys_parameter WHERE app_id=%s AND module_code='%s' AND broker_code='%s' AND status = 1", appId, moduleCode, brokerCode);
    }

    public List<Map<String, Object>> getEnvProperties(Map<String, String> connectParams) {
        List envParasList;
        if (((String)connectParams.get("type")).equals(Constant.START_TYPE_DB.toString())) {
            envParasList = this.query(connectParams, "SELECT para_name,para_value,is_encrypt FROM t_environment_parameter WHERE status = 1");
        } else {
            envParasList = this.getRestParams(connectParams, "");
        }
        System.out.println(envParasList);
        return envParasList;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public Connection getConnection(Map<String, String> connectParams) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = (String)connectParams.get("url");
        String username = (String)connectParams.get("username");
        String password = (String)connectParams.get("password");
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public List<Map<String, Object>> getRestParams(Map<String, String> connectParams, String restUrl, Object... params) {
        RestTemplateBuilder builder = new RestTemplateBuilder(new RestTemplateCustomizer[0]);
        RestTemplate restTemplate = builder.build();
        return null;
    }

    public static List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        if (rs == null) {
            return Collections.EMPTY_LIST;
        } else {
            ResultSetMetaData columns = rs.getMetaData();
            int columnCount = columns.getColumnCount();
            List list = new ArrayList();
            new HashMap();

            while (rs.next()) {
                Map<String, Object> rowData = new HashMap(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(columns.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }

            return list;
        }
    }

    public List<Map<String, Object>> query(Map<String, String> connectParams, String sql, Object... params) {
        List<Map<String, Object>> resultList = null;
        Connection conn = null;

        try {
            conn = this.getConnection(connectParams);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(String.format(sql, params));
            resultList = resultSetToList(result);
        }catch (Exception var16) {
            var16.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception var15) {
                    System.out.println("Ignore close errors");
                }
            }
        }
        return resultList;
    }
}
