package com.archforce.bos.common;

public class Environment {
    public final static String ARCHFORCE_DOMAIN_URL = "jdbc:mysql://localhost:3306/domainConfigdb?useSSL=false|root|root";
    public final static String ARCHFORCE_DOMAIN_ENC = "false";
    public final static String APP_NAME = "TSM";
    public final static String INSTANCE_NAME = "BOS_1_1_11";
    public final static String BASE_LOG_PATH = "D/test/log/";

    public static void setEnv() {
        System.setProperty("ARCHFORCE_DOMAIN_URL", ARCHFORCE_DOMAIN_URL);
        System.setProperty("APP_NAME", APP_NAME);
        System.setProperty("INSTANCE_NAME", INSTANCE_NAME);
        System.setProperty("ARCHFORCE_DOMAIN_ENC", ARCHFORCE_DOMAIN_ENC);
        System.setProperty("ENV_base_log_path", BASE_LOG_PATH);
    }

}
