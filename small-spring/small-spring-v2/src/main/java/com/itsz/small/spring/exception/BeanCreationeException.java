package com.itsz.small.spring.exception;

public class BeanCreationeException extends Exception {

    public BeanCreationeException() {
        super();
    }

    public BeanCreationeException(String message) {
        super(message);
    }

    public BeanCreationeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreationeException(Throwable cause) {
        super(cause);
    }

    protected BeanCreationeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
