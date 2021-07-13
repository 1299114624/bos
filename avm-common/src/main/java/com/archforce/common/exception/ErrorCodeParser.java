package com.archforce.common.exception;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ErrorCodeParser {

    private final static String ERR_CONFIG = "error.properties";

    private Map<String, String> map = new HashMap();

    private static volatile ErrorCodeParser single = null;

    private ErrorCodeParser() {
        try {
            this.loadResource();
        } catch (Exception e) {
            throw new RuntimeException("加载 " + ERR_CONFIG + " 出错");
        }
    }

    private void loadResource() throws Exception {
        final ClassPathResource classPathResource = new ClassPathResource(ERR_CONFIG);
        if (!classPathResource.exists()) {
            return;
        }
        InputStream in = classPathResource.getInputStream();
        Properties props = new Properties();
        props.load(new BufferedReader(new InputStreamReader(in, "utf-8")));
        props.load(in);
        Enumeration e = props.propertyNames();
        while (e.hasMoreElements()) {
            String errorCode = (String) e.nextElement();
            map.put(errorCode,(String) props.get(errorCode));
        }
    }

    public static ErrorCodeParser single() {
        if (single == null) {
            synchronized (ErrorCodeParser.class) {
                if (single == null) {
                    single = new ErrorCodeParser();
                    return single;
                }
            }
        }
        return single;
    }

    public String getErrorDesc(Object errorCode) {
        return map.get(errorCode);
    }
}
