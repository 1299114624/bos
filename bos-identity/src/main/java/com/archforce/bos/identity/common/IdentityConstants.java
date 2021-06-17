package com.archforce.bos.identity.common;

/**
 * 权限实体
 */
public class IdentityConstants {
    public static String SESSION_USER = "sessionUser";
    /**
     * BOS的登录方式 0 BOS 1 标准 SSO 2 客户用户名密码模式 3 客户用户名密码+token验证模式
     */
    public static String PARAMETER_BOS_CONFIG_LOGIN_TYPE = "bos.config.loginType";

    /**
     * 全局的登录方式 0 BOS 1 标准 SSO 2 客户用户名密码模式 3 客户用户名密码+token验证模式
     */
    public static String GLOBAL_LOGIN_TYPE = "0";

    /**
     * 登录验证方式 0 BOS 1 标准 SSO 2 客户用户名密码模式 3 客户用户名密码+token验证模式
     */
    public static final String SSO_LOGIN_TYPE_BOS = "0";
    public static final String SSO_LOGIN_TYPE_SSO = "1";
    public static final String SSO_LOGIN_TYPE_CUSTOM_PASSWORD = "2";
    public static final String SSO_LOGIN_TYPE_CUSTOM_TOKEN = "3";

    /**
     * 特殊用户列表
     */
    public static String PARAMETER_SSO_CONFIG_SPECIALUSERLIST = "sso_config_specialUserList";
}
