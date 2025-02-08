package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.EError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EOperationType {
    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW");

    private final String title;

    public static EOperationType getOperationTypeByTitle(String title) {
        for (EOperationType operationType : EOperationType.values()) {
            if (operationType.getTitle().equals(title)) {
                return operationType;
            }
        }

        throw new BadRequestException(EError.INCORRECT_OPERATION);
    }
}
