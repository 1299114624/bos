package com.archforce.arc.facility.entity.avm.component;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * t_component
 */
public class Component {
    /**
     * id
     */
    private Integer id;

    /**
     * componentEnglishName
     */
    private String componentEnglishName;

    /**
     * componentName
     */
    private String componentName;

    /**
     * componentCode
     */
    private String componentCode;

    /**
     * componentType
     */
    private Integer componentType;

    /**
     * description
     */
    private String description;

    /**
     * languageType
     */
    private String languageType;

    /**
     * chargeman
     */
    private String chargeman;

    /**
     * delStatus
     */
    private Integer delStatus;

    /**
     * updateUser
     */
    private String updateUser;

    /**
     * updateTime
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * addUser
     */
    private String addUser;

    /**
     * addTime
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date addTime;

    /**
     * designSvnAddress
     */
    private String designSvnAddress;

    /**
     * requireSvnAddress
     */
    private String requireSvnAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentEnglishName() {
        return componentEnglishName;
    }

    public void setComponentEnglishName(String componentEnglishName) {
        this.componentEnglishName = componentEnglishName;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public Integer getComponentType() {
        return componentType;
    }

    public void setComponentType(Integer componentType) {
        this.componentType = componentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    public String getChargeman() {
        return chargeman;
    }

    public void setChargeman(String chargeman) {
        this.chargeman = chargeman;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getDesignSvnAddress() {
        return designSvnAddress;
    }

    public void setDesignSvnAddress(String designSvnAddress) {
        this.designSvnAddress = designSvnAddress;
    }

    public String getRequireSvnAddress() {
        return requireSvnAddress;
    }

    public void setRequireSvnAddress(String requireSvnAddress) {
        this.requireSvnAddress = requireSvnAddress;
    }
}