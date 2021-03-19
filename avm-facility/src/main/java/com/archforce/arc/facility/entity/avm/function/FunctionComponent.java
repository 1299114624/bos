package com.archforce.arc.facility.entity.avm.function;

/**
 * t_function_component
 */
public class FunctionComponent {
    /**
     * id
     */
    private Integer id;

    /**
     * componentEnglishName
     */
    private Integer functionId;

    /**
     * componentName
     */
    private Integer componentId;

    private String componentName;

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

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
}