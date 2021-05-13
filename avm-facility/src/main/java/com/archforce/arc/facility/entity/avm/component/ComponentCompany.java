package com.archforce.arc.facility.entity.avm.component;

/**
 * t_component_company
 */
public class ComponentCompany {
    /**
     * id
     */
    private Integer id;

    /**
     * componentId
     */
    private Integer componentId;

    /**
     * companyId
     */
    private Integer companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}