package com.archforce.arc.facility.exception;

/**
 * 错误编码规范
 * 1. 6位错误码
 * 2. 第一位系统，本系统定8
 * 3. 第2,3位为模块
 * 4. 最后3位异常序列号
 */
public class ErrorCodeConstant {
    /**
     * 用户未登录的错误码
     */
    public static final String UNAUTHORIZED_CODE = "10004";
    //功能管理 01
    public static final String FUNCTION_CODE_EXIT = "801001";
    public static final String FUNCTION_NAME_EXIT = "801002";
    //组件管理 02
    //产品管理 03
    public static final String PRODUCT_ENGSIMP_NAME_EXISTED = "803001";
    //客户管理 04
    //功能版本维护 05
    //组件版本维护 06
    //标准产品版本管理 07
}
