package com.archforce.arc.facility.entity.vo;

import com.archforce.arc.facility.common.AvmTree;
import com.archforce.arc.facility.common.AvmTreeConverter;
import com.archforce.arc.facility.entity.avm.function.Function;

public class FunctionVo extends Function implements AvmTreeConverter {
    private Integer parentId;
    private String parentCode;
    private String companyIds;
    private String componentIds;
    private String companyNames;
    private String componentNames;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(String companyIds) {
        this.companyIds = companyIds;
    }

    public String getComponentIds() {
        return componentIds;
    }

    public void setComponentIds(String componentIds) {
        this.componentIds = componentIds;
    }

    public String getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(String companyNames) {
        this.companyNames = companyNames;
    }

    public String getComponentNames() {
        return componentNames;
    }

    public void setComponentNames(String componentNames) {
        this.componentNames = componentNames;
    }

    @Override
    public AvmTree toAvmTree() {
        AvmTree<FunctionVo> avmTree = new AvmTree<>();
        avmTree.setId(getId());
        avmTree.setCode(getFunctionCode());
        avmTree.setParentCode(getParentCode());
        avmTree.setName(getFunctionName());
        avmTree.setType(getFunctionType());
        avmTree.setNode(this);
        return avmTree;
    }
}
