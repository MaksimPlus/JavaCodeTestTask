package com.example.demo.exception;

import com.example.demo.util.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum EError {
    BAD_REQUEST(Constants.BAD_REQUEST_MESSAGE, HttpStatus.BAD_REQUEST),
    WALLET_NOT_FOUND(Constants.WALLET_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND),
    INSUFFICIENT_FUNDS(Constants.INSUFFICIENT_FUNDS_MESSAGE, HttpStatus.BAD_REQUEST),
    INCORRECT_OPERATION(Constants.INCORRECT_OPERATION_MESSAGE, HttpStatus.BAD_REQUEST);

    private final String errorMessage;
    private final HttpStatus errorStatus;
}
