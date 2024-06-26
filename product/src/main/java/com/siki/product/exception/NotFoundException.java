package com.siki.product.exception;


import com.siki.product.utils.MessageUtils;

public class NotFoundException extends RuntimeException{
    private String message;

    public NotFoundException(String errorCode, Object ...var2) {
        this.message = MessageUtils.getMessage(errorCode, var2);
    }

    public NotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
