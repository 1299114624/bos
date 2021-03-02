package com.archforce.arc.facility.entity.common;

import com.archforce.arc.facility.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * t_dict
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dict extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;

    /**
     * 编码
     */
    private String dictCode;

    /**
     * 值
     */
    private String dictValue;

    /**
     * 名称
     */
    private String dictName;

    /**
     * 类型编码
     */
    private String categoryCode;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 字典描述
     */
    private String remark;

    /**
     * addTime
     */
    private Date addTime;

    /**
     * addUser
     */
    private String addUser;

    /**
     * updateTime
     */
    private Date updateTime;

    /**
     * updateUser
     */
    private String updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}