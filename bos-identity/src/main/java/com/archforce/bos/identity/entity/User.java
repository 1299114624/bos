package com.archforce.bos.identity.entity;

import java.util.Date;
import java.util.List;

/**
 * t_user
 */
public class User {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * addTime
     */
    private Date addTime;

    /**
     * addUser
     */
    private String addUser;

    /**
     * updateTime
     */
    private Date updateTime;

    /**
     * updateUser
     */
    private String updateUser;

    /**
     * dataStatus
     */
    private Integer dataStatus;

    /**
     * 是否支持查询首页
     */
    private boolean isQueryHomeData = false;

    /**
     * 是否受限用户
     */
    private boolean isLimit;

    /**
     * 用户的角色列表
     */
    private List<Role> roles;

    /**
     * 权限编码数组
     */
    private List<String> permission;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * 注销用户
     */
    private boolean isClose;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getIsLimit() {
        return isLimit;
    }

    public void setIsLimit(Boolean isLimit) {
        this.isLimit = isLimit;
    }

    public Boolean getIsClose() {
        return isClose;
    }

    public void setIsClose(Boolean isClose) {
        this.isClose = isClose;
    }

    public boolean getIsQueryHomeData() {
        return isQueryHomeData;
    }

    public void setIsQueryHomeData(boolean isQueryHomeData) {
        this.isQueryHomeData = isQueryHomeData;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }
}