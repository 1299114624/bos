package com.archforce.arc.facility.entity.avm.company;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * t_company
 */
public class Company {
    /**
     * id
     */
    private Integer id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司英文名称
     */
    private String englishCompanyName;

    /**
     * 公司简称
     */
    private String simpleCompanyName;

    /**
     * 描述
     */
    private String description;

    /**
     * 删除状态
     */
    private Integer delStatus;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**
     * 添加人
     */
    private String addUser;

    /**
     * 添加时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEnglishCompanyName() {
        return englishCompanyName;
    }

    public void setEnglishCompanyName(String englishCompanyName) {
        this.englishCompanyName = englishCompanyName;
    }

    public String getSimpleCompanyName() {
        return simpleCompanyName;
    }

    public void setSimpleCompanyName(String simpleCompanyName) {
        this.simpleCompanyName = simpleCompanyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}