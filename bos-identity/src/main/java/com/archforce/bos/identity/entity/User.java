package com.archforce.bos.identity.entity;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * t_user
 */
public class User implements Serializable {
    private static final long serialVersionUID = 7445079243713772691L;
    /**
     * id
     */
    private Long id;

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

    /**
     * 用户的角色id列表
     */
    private List<Long> roleIds = new ArrayList<>();

    /**
     * 注销用户
     */
    private boolean isClose;

    /**
     * 是否仅有指定账户角色
     */
    private boolean onlyAccountRole;

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    private boolean isSuperAdmin = false;

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }

    public boolean isOnlyAccountRole() {
        return onlyAccountRole;
    }

    public void setOnlyAccountRole(boolean onlyAccountRole) {
        this.onlyAccountRole = onlyAccountRole;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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