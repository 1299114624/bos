package com.archforce.bos.identity.entity;

import com.archforce.arc.facility.entity.BaseEntity;

public class Role extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 业务类型
     */
    private Integer businessType;
    /**
     * 账户范围
     */
    private Integer accountRange;
    /**
     * 组织类型
     */
    private Integer orgType;
    /**
     * 描述
     */
    private String description;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Integer getAccountRange() {
        return accountRange;
    }

    public void setAccountRange(Integer accountRange) {
        this.accountRange = accountRange;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
