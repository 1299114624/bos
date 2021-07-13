package com.archforce.common.utils;


import com.archforce.common.exception.ApplicationException;

import java.io.Serializable;
import java.util.HashMap;

public class ResBody implements Serializable {

    public final static String OK_CODE = "0";
    public final static String ERROR_CODE = "500";

    private String code;

    private String msg;

    private Object body;

    public ResBody(Object body, String code, String msg) {
        this.body = body;
        this.code = code;
        this.msg = msg;
    }

    public static ResBody ok() {
        return new ResBody(new HashMap(), OK_CODE, "");
    }

    public static ResBody ok(Object body) {
        return new ResBody(body, OK_CODE, "");
    }

    public static ResBody error(ApplicationException e) {
        return new ResBody(null, e.getErrorCode(), e.getMessage());
    }

    public static ResBody error(String errorCode, String message) {
        return new ResBody(null, errorCode, message);
    }

    public static ResBody error(String message) {
        return new ResBody(null, ERROR_CODE, message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
