package com.archforce.arc.common.exception;

public class FileHandlerException extends RuntimeException {
    public FileHandlerException() {
    }

    public FileHandlerException(String message) {
        super(message);
    }
    public FileHandlerException(String message, Throwable cause) {
        super(message, cause);
    }
}
