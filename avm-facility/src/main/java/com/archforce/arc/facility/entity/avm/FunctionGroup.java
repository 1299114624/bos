package com.archforce.arc.facility.entity.avm;

/**
 * t_function_group
 */
public class FunctionGroup {
    /**
     * id
     */
    private Integer id;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 分组编号
     */
    private String groupCode;

    /**
     * parentCode
     */
    private String parentCode;

    /**
     * groupDesc
     */
    private String groupDesc;

    /**
     * groupType
     */
    private Integer groupType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }
}