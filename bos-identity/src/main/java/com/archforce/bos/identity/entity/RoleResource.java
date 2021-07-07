package com.archforce.bos.identity.entity;

public class RoleResource {
    /**
    * 角色ID
    */
    private Long roleId;

    /**
    * 目录ID
    */
    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}