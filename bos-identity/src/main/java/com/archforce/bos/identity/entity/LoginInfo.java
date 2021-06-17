package com.archforce.bos.identity.entity;

public class LoginInfo {
    /**
     * 登录名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    private String code;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
