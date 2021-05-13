package com.archforce.arc.facility.entity.vo;

import com.archforce.arc.facility.entity.avm.component.Component;

public class ComponentVo extends Component {
    private String functionNames;
    private String companyIds;
    private String companyNames;

    public String getComponentTypeCn() {
        return componentType == 0 ? "通用组件" : "客制组件";
    }

    public String getFunctionNames() {
        return functionNames;
    }

    public void setFunctionNames(String functionNames) {
        this.functionNames = functionNames;
    }

    public String getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(String companyIds) {
        this.companyIds = companyIds;
    }

    public String getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(String companyNames) {
        this.companyNames = companyNames;
    }
}
