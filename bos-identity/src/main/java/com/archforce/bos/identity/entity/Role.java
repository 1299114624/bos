package com.archforce.bos.identity.entity;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;

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

    /**
     * 角色对应的资源
     */
    private List<Resource> resources = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}