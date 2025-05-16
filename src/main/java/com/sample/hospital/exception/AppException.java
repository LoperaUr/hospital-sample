package com.sample.hospital.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
    protected final HttpStatus httpStatus;

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
