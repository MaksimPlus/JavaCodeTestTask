package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class WalletResponseDto {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("balance")
    private double balance;
}
