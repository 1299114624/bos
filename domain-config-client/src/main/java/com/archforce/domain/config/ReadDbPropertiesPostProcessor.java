package com.archforce.domain.config;

import com.archforce.domain.utils.Constant;
import com.archforce.domain.utils.DomainConfigUtil;
import com.archforce.domain.utils.EncryptUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.StringUtils;

import java.util.*;

public class ReadDbPropertiesPostProcessor implements EnvironmentPostProcessor, Ordered {
    public static final String PROPERTY_SOURCE_NAME = "application.properties";
    public static final String APP_MODULE_BROKER = "APP";
    public static final String ARCHFORCE_DOMAIN_URL = "ARCHFORCE_DOMAIN_URL";
    public static final String ARCHFORCE_DOMAIN_ENCRYPT = "ARCHFORCE_DOMAIN_ENC";
    public static final String APP_NAME = "APP_NAME";
    public static final String INSTANCE_NAME = "INSTANCE_NAME";
    public static final String LOG_CONFIG = "log.config";
    PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}",":",true);
    public static final Map<String, String> CONNECT_PARAMS = new HashMap<>();

    public ReadDbPropertiesPostProcessor() {
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            MutablePropertySources propertySources = environment.getPropertySources();
            Map<String, String> envMap = System.getenv();
            String instanceName = (String)envMap.get("INSTANCE_NAME");
            String app = (String)envMap.get("APP_NAME");
            String encryption = (String)envMap.get("ARCHFORCE_DOMAIN_ENC");
            String config = (String)envMap.get("ARCHFORCE_DOMAIN_URL");
            Integer startType = Constant.START_TYPE_DB;
            if (StringUtils.isEmpty(config) || StringUtils.isEmpty(app) || StringUtils.isEmpty(instanceName)) {
                instanceName = System.getProperty("INSTANCE_NAME");
                app = System.getProperty("APP_NAME");
                encryption = System.getProperty("ARCHFORCE_DOMAIN_ENC");
                config = System.getProperty("ARCHFORCE_DOMAIN_URL");
            }
            if (StringUtils.isEmpty(app)) {
                throw new RuntimeException("You need to set APP_NAME in your Environment Property");
            } else if (StringUtils.isEmpty(instanceName)) {
                throw new RuntimeException("You must to set moudule instance name when you startup this application! Because we need to get properties from domainconfigdb database!Parameter type:APP=app/instance_name/startType");
            } else {
                String argParams = "";
                String argType = "";
                Iterator var12 = propertySources.iterator();
                while (true) {
                    while (true) {
                        PropertySource item;
                        String moduleCode;
                        do {
                            if (!var12.hasNext()) {
                                String[] split;
                                if (!StringUtils.isEmpty(argParams)) {
                                }
                                if (StringUtils.isEmpty(encryption)) {
                                }
                                if (StringUtils.isEmpty(config)) {
                                }

                                Boolean isEncryption = Boolean.valueOf(encryption);
                                if (isEncryption) {
                                    config = EncryptUtil.decode(config);
                                }
                                split = config.split("\\|");
                                if (split != null && split.length == 3) {
                                    System.out.println("访问的环境变量地址为：" + split[0]);
                                    Map<String, String> connectParams = new HashMap<>();
                                    connectParams.put("type", String.valueOf(startType));
                                    connectParams.put("url",split[0]);
                                    connectParams.put("username",split[1]);
                                    connectParams.put("password",EncryptUtil.decodePwd(split[2]));
                                    DomainConfigUtil dataUtil = new DomainConfigUtil();
                                    Integer appId = dataUtil.getAppId(app, connectParams);
                                    List<Map<String, Object>> envParasList = dataUtil.getEnvProperties(connectParams);
                                    Properties envProperties = new Properties();
                                    envProperties.putAll(envMap);

                                    Map item2 = null;
                                    for (Iterator var36=envParasList.iterator(); var36.hasNext(); this.setEnv(envProperties, item2)) {
                                        item2 = (Map)var36.next();
                                        String paraName = item2.get("para_name").toString().trim();
                                        String paraValue = (String)envMap.get("ENV_" + paraName.replace(".", "_"));
                                        if (!StringUtils.isEmpty(paraValue)) {
                                            item2.put("para_value", paraValue);
                                        }
                                    }
                                    CONNECT_PARAMS.putAll(connectParams);
                                    moduleCode = instanceName.split("_")[0];
                                    List<Map<String, Object>> moduleParamList = dataUtil.getModuleParams(connectParams, appId, moduleCode);
                                    if (CollectionUtils.isEmpty(moduleParamList)) {
                                        throw new RuntimeException("There is no params, module_code is " + moduleCode);
                                    }
                                    List<Map<String, Object>> moduleParamList2 = dataUtil.getBrokerParams(connectParams, appId, moduleCode, instanceName);
                                    moduleParamList.addAll(moduleParamList2);
                                    Properties newProperties = new Properties();
                                    newProperties.putAll(envProperties);

                                    Map item3 = null;
                                    for (Iterator var23 = moduleParamList.iterator(); var23.hasNext(); this.setParams(newProperties, envProperties, item3)) {
                                        item3 = (Map)var23.next();
                                        String paraName = item3.get("para_name").toString().trim();
                                        String paraValue = (String)envMap.get(app + "_" + moduleCode + "_" +
                                                "" + paraName.replace(".", "_"));
                                        if (!StringUtils.isEmpty(paraValue)) {
                                            item3.put("para_value", paraValue);
                                        }
                                    }

                                    propertySources.addFirst(new PropertiesPropertySource("application.properties", newProperties));
                                    return;
                                }
                                throw new RuntimeException("Error domain config database connection string");
                            }
                            item = (PropertySource)var12.next();
                        } while (!(item instanceof SimpleCommandLinePropertySource));

                        String property = ((SimpleCommandLinePropertySource) item).getProperty("nonOptionArgs");
                        String[] nonOptionArgs = StringUtils.commaDelimitedListToStringArray(property);
                        String[] var16 = nonOptionArgs;
                        int var17 = nonOptionArgs.length;

                        for (int var18 = 0; var18 < var17; ++var18) {
                            moduleCode = var16[var18];
                            if (moduleCode.toUpperCase().startsWith("APP=")) {
                                argParams = moduleCode;
                                System.out.println("You argParams is:" + moduleCode);
                                break;
                            }
                        }
                    }
                }
            }

        } catch (Exception var27) {
            System.out.println("Set property parameter error:" + var27.getMessage());
            var27.printStackTrace();
            System.exit(-1);
        }
    }

    private void setEnv(Properties envProperties, Map<String, Object> item) {
        String paraName = item.get("para_name").toString().trim();
        String paraValue = item.get("para_value").toString();
        if (!StringUtils.isEmpty(item.get("is_encrypt")) && Boolean.valueOf(item.get("is_encrypt").toString())) {
            try {
                paraValue = EncryptUtil.decode(paraValue);
            } catch (Exception var6) {
                throw new RuntimeException("Environment parameter encrypt decode fail, parameter name:" + paraName +", parameter value:" + paraValue);
            }
        }
        envProperties.put(paraName, paraValue);
    }

    private void setParams(Properties newProperties, Properties envProperties, Map<String, Object> item) {
        String paraValue = "";
        if (!StringUtils.isEmpty(item.get("para_value"))) {
            paraValue = item.get("para_value").toString().trim();
        }
        String paraName = item.get("para_name").toString().trim();
        if (!StringUtils.isEmpty(paraValue) && !StringUtils.isEmpty(item.get("is_encrypt")) && Boolean.valueOf(item.get("is_encrypt").toString())) {
            try {
                paraValue = EncryptUtil.decode(paraValue);
            } catch (Exception var7) {
                throw new RuntimeException("Sys parameter Encrypt decode fail,module name:" + item.get("module_code") + ", parameter name:" + paraName + ", parameter value:" + paraValue);
            }
        }

        paraValue = this.helper.replacePlaceholders(paraValue, envProperties);
        newProperties.put(paraName, paraValue);
        if (paraName.startsWith("log.config")) {
            System.setProperty(paraName, paraValue);
        }
    }

    @Override
    public int getOrder() {
        return -1147483649;
    }
}
