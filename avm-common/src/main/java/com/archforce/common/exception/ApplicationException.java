package com.archforce.common.exception;

import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.regex.Pattern;

public class ApplicationException extends RuntimeException {

    private final String INNER_ERR = "999999";

    private String errorCode;

    private String errorMsg;

    private Object[] arguments = new Object[0];

    public ApplicationException(String errorCode) {
        if (!StringUtils.isEmpty(errorCode) && !isInteger(errorCode)) {
            this.errorMsg = errorCode;
            errorCode = INNER_ERR;
        }
        setErrorCode(errorCode);
    }

    public ApplicationException(String errorCode, Object... arguments) {
        if (!StringUtils.isEmpty(errorCode) && !isInteger(errorCode)) {
            this.errorMsg = errorCode;
            errorCode = INNER_ERR;
        }
        setErrorCode(errorCode);
        setArguments(arguments);
    }

    public ApplicationException(String errorCode, Throwable cause) {
        super(cause);
        if (!StringUtils.isEmpty(errorCode) && !isInteger(errorCode)) {
            this.errorMsg = errorCode;
            errorCode = INNER_ERR;
        }
        setErrorCode(errorCode);
    }

    public ApplicationException(String errorCode, Throwable cause, Object... arguments) {
        super(cause);
        if (!StringUtils.isEmpty(errorCode) && !isInteger(errorCode)) {
            this.errorMsg = errorCode;
            errorCode = INNER_ERR;
        }
        setErrorCode(errorCode);
        setArguments(arguments);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
        setErrorCode(INNER_ERR);
    }

    @Override
    public String getMessage() {
        String errorDesc = "";
        if (!StringUtils.isEmpty(this.errorMsg)) {
            errorDesc = this.errorMsg;
        } else {
            errorDesc = ErrorCodeParser.single().getErrorDesc(this.errorCode);
        }

        if (errorDesc != null) {
            try {
                errorDesc = MessageFormat.format(errorDesc, arguments);
            } catch (Exception ex) {
                //do nothing
            }
        } else {
            errorDesc = "";
        }

        return errorDesc;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 判断是否为整数
     * @param str 传入的字符串
     * @return  是整数返回true，否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
