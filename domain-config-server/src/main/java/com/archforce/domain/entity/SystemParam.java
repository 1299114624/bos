package com.archforce.domain.entity;

/**
    * t_sys_parameter
    */
public class SystemParam {
    /**
    * id
    */
    private Integer id;

    /**
    * 应用
    */
    private Integer appId;

    /**
    * 组件编码
    */
    private String moduleCode;

    /**
    * 组件实例名
    */
    private String brokerCode;

    /**
    * 参数名
    */
    private String paraName;

    /**
    * 参数值
    */
    private String paraValue;

    /**
    * 类别：1产品参数、2客制化参数，默认是2
    */
    private Boolean paraType;

    /**
    * 状态（0启用 1禁用）
    */
    private Boolean status;

    /**
    * 参数描述
    */
    private String paraDesc;

    /**
    * 0-不加密 1-加密
    */
    private Boolean isEncrypt;

    /**
    * 排序字段
    */
    private String sortField;

    /**
    * 排序顺序
    */
    private Integer sortNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    public Boolean getParaType() {
        return paraType;
    }

    public void setParaType(Boolean paraType) {
        this.paraType = paraType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getParaDesc() {
        return paraDesc;
    }

    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc;
    }

    public Boolean getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}