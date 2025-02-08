package com.example.demo.exception;

public class NotFoundException extends ServiceException {
    public NotFoundException(EError error) {
        super(error, error.getErrorMessage());
    }
}
