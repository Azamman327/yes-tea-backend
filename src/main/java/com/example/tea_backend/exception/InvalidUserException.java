package com.example.tea_backend.exception;

import lombok.Getter;

@Getter
public class InvalidUserException extends RuntimeException{
    private ErrorCode errorCode;

    public InvalidUserException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
