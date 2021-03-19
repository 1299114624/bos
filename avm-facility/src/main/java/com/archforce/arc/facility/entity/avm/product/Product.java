package com.archforce.arc.facility.entity.avm.product;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Product {
    private Integer id;

    private String simpleEnglishName;

    private String fullEnglishName;

    private String fullChineseName;

    private String groupMemberNames;

    private String productDesc;

    private String addUser;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date addTime;

    private String updateUser;

    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private String delStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSimpleEnglishName() {
        return simpleEnglishName;
    }

    public void setSimpleEnglishName(String simpleEnglishName) {
        this.simpleEnglishName = simpleEnglishName == null ? null : simpleEnglishName.trim();
    }

    public String getFullEnglishName() {
        return fullEnglishName;
    }

    public void setFullEnglishName(String fullEnglishName) {
        this.fullEnglishName = fullEnglishName == null ? null : fullEnglishName.trim();
    }

    public String getFullChineseName() {
        return fullChineseName;
    }

    public void setFullChineseName(String fullChineseName) {
        this.fullChineseName = fullChineseName == null ? null : fullChineseName.trim();
    }

    public String getGroupMemberNames() {
        return groupMemberNames;
    }

    public void setGroupMemberNames(String groupMemberNames) {
        this.groupMemberNames = groupMemberNames;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }
}