package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WalletRequestDto {
    @JsonProperty("operation_type")
    private String operationType;

    @JsonProperty("amount")
    private float amount;
}
