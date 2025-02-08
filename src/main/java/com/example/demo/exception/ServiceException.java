package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ServiceException extends RuntimeException {
    private EError error;

    protected ServiceException(EError error, String message) {
        super(message);
        this.error = error;
    }
}
