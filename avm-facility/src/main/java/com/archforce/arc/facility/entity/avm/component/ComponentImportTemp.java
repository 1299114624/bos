package com.archforce.arc.facility.entity.avm.component;

public class ComponentImportTemp {
    private Long id;

    /**
    * 组件名称
    */
    private String componentName;

    /**
    * 文件id
    */
    private String fileId;

    /**
    * 行号
    */
    private String lineNumber;

    /**
    * 是否导入成功（Y：成功，N：失败）
    */
    private String isSuccess;

    /**
    * 导入的组件信息
    */
    private String componentInfo;

    /**
    * 错误信息
    */
    private String errorInfo;

    /**
    * 备注
    */
    private String mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getComponentInfo() {
        return componentInfo;
    }

    public void setComponentInfo(String componentInfo) {
        this.componentInfo = componentInfo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}