package com.archforce.arc.facility.entity.avm.function;

/**
 * t_function_function_group
 */
public class FunctionFunctionGroup {
    /**
     * id
     */
    private Integer id;

    /**
     * 功能ID
     */
    private Integer functionId;

    /**
     * 分组ID
     */
    private Integer functionGroupId;

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

    public Integer getFunctionGroupId() {
        return functionGroupId;
    }

    public void setFunctionGroupId(Integer functionGroupId) {
        this.functionGroupId = functionGroupId;
    }
}