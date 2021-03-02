package com.archforce.arc.facility.entity.avm;

import com.archforce.arc.facility.common.AvmTree;
import com.archforce.arc.facility.common.AvmTreeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
    * t_function
    */
public class Function implements AvmTreeConverter {
    /**
    * id
    */
    private Integer id;

    /**
    * 功能名称
    */
    private String functionName;

    /**
    * 功能编号
    */
    private String functionCode;

    /**
    * functionType
    */
    private Integer functionType;

    /**
    * chargeman
    */
    private String chargeman;

    /**
    * descirption
    */
    private String descirption;

    /**
    * addUser
    */
    private String addUser;

    /**
    * addTime
    */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date addTime;

    /**
    * updateUser
    */
    private String updateUser;

    /**
    * updateTime
    */
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public Integer getFunctionType() {
        return functionType;
    }

    public void setFunctionType(Integer functionType) {
        this.functionType = functionType;
    }

    public String getChargeman() {
        return chargeman;
    }

    public void setChargeman(String chargeman) {
        this.chargeman = chargeman;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public AvmTree toAvmTree() {
        return null;
    }
}