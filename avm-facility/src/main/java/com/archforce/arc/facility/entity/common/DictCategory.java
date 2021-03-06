package com.archforce.arc.facility.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;

    /**
     * 编码
     */
    private String categoryCode;

    /**
     * 名称
     */
    private String categoryName;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 状态 0停用   1启用
     */
    private Integer status;

    /**
     * 字典描述
     */
    private String remark;

    /**
     * 字典维护方式：0 不在界面维护  1 在界面维护
     */
    private Integer maintainType;


}
