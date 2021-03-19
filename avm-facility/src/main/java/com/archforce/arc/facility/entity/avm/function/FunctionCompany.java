package com.archforce.arc.facility.entity.avm.function;

/**
 * t_function_company
 */
public class FunctionCompany {
    /**
     * id
     */
    private Integer id;

    /**
     * functionId
     */
    private Integer functionId;

    /**
     * companyId
     */
    private Integer companyId;

    private String companyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}