package com.archforce.domain.entity;

public class App {
    /**
    * 应用编号
    */
    private Integer appId;

    /**
    * 应用名称
    */
    private String appName;

    /**
    * 描述
    */
    private String appDesc;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }
}