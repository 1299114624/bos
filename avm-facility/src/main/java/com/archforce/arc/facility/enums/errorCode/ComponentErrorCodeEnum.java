package com.archforce.arc.facility.enums.errorCode;

public enum ComponentErrorCodeEnum {
    COMPONENT_NAME_EXIT("50001", "组件名称已存在！"),

    COMPONENT_TYPE_ERROR("50002", "组件类型必须是通用组件或客制组件！"),

    DATA_DB_ERROR("50003", "组件信息录入失败！");

    private String errorCode;

    private String desc;

    ComponentErrorCodeEnum(String errorCode, String desc) {
        this.errorCode = errorCode;
        this.desc = desc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ComponentErrorCodeEnum getValue(String errorCode) {
        for (ComponentErrorCodeEnum e : ComponentErrorCodeEnum.values()) {
            if (e.getErrorCode().equals(errorCode)) {
                return e;
            }
        }
        return null;
    }
}
