package com.archforce.bos.identity.common;

/**
 * 用户类型枚举
 */
public enum RoleTypeEnum {
    Admin("超级管理员", -1),
    BusinessAdmin("业务管理员", -2),
    AppointAccount("指定账户", -3),
    Maintenance("运维", -4);
    private final String name;
    private final Integer value;

    RoleTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public static RoleTypeEnum fromValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (RoleTypeEnum e : RoleTypeEnum.values()) {
            if (value.equals(e.value)) {
                return e;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RoleTypeEnum{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
