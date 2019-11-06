package com.itsz.small.spring.exception;

public class BeanDefinitionStoreException extends Exception {
    public BeanDefinitionStoreException() {
        super();
    }

    public BeanDefinitionStoreException(String message) {
        super(message);
    }

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanDefinitionStoreException(Throwable cause) {
        super(cause);
    }

    protected BeanDefinitionStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
