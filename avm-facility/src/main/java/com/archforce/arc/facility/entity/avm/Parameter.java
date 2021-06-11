package com.archforce.arc.facility.entity.avm;

/**
 * t_sys_parameter
 */
public class Parameter {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;

    /**
     * 类别
     */
    private String paraType;

    /**
     * 名称
     */
    private String paraName;

    /**
     * 值
     */
    private String paraValue;

    /**
     * 状态（1启用 2禁用）
     */
    private Integer status;

    /**
     * 描述
     */
    private String paraDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParaType() {
        return paraType;
    }

    public void setParaType(String paraType) {
        this.paraType = paraType;
    }

    public String getParaName() {
        return paraName;
    }

    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getParaDesc() {
        return paraDesc;
    }

    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", paraType='" + paraType + '\'' +
                ", paraName='" + paraName + '\'' +
                ", paraValue='" + paraValue + '\'' +
                ", status=" + status +
                ", paraDesc='" + paraDesc + '\'' +
                '}';
    }
}