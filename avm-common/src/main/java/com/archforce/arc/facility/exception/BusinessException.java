package com.archforce.arc.facility.exception;

import java.text.MessageFormat;

public class BusinessException extends RuntimeException {
    private String errorCode;

    private String errorMessage;

    private Object[] messageArgs;

    public BusinessException(String errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = ErrorCodeParser.single().getErrorDesc(this.errorCode);
    }
    public BusinessException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public BusinessException(String errorCode, String errorMessage, Object... messageArgs) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.messageArgs = messageArgs;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        if (messageArgs != null && messageArgs.length > 0) {
            return MessageFormat.format(errorMessage, messageArgs);
        } else {
            return errorMessage;
        }
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object[] getMessageArgs() {
        return messageArgs;
    }

    public void setMessageArgs(Object[] messageArgs) {
        this.messageArgs = messageArgs;
    }
}
