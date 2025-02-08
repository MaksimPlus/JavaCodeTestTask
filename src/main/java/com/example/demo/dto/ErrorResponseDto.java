package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    @JsonProperty("error_message")
    private String errorMessage;
    @JsonProperty("stack_trace")
    private List<String> stackTrace;
}
