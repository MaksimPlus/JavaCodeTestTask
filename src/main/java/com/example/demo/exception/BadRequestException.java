package com.example.demo.exception;

public class BadRequestException extends ServiceException {

    public BadRequestException(EError error) {
        super(error, error.getErrorMessage());
    }
}
