package com.archforce.domain.entity;

public class EnvironmentParameter {
    /**
    * ID
    */
    private Integer id;

    /**
    * 参数名
    */
    private String paraName;

    /**
    * 参数值
    */
    private String paraValue;

    /**
    * 参数描述
    */
    private String paraDesc;

    /**
    * 是否启用
    */
    private Boolean status;

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

    public String getParaDesc() {
        return paraDesc;
    }

    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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