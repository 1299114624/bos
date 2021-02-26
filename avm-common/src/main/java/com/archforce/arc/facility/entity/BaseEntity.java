package com.archforce.arc.facility.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"dataPermission"})
public class BaseEntity implements Serializable {
    private Date addTime;
    private String addUser;
    private Date updateTime;
    private String updateUser;
    private Integer dataStatus;
    private String dataPermission;

    public BaseEntity() {
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getDataPermission() {
        return dataPermission;
    }

    public void setDataPermission(String dataPermission) {
        this.dataPermission = dataPermission;
    }
}
