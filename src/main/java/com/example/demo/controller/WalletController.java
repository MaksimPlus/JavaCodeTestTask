package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.WalletServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import com.example.demo.dto.WalletRequestDto;
import com.example.demo.dto.WalletResponseDto;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/wallets")
@AllArgsConstructor
public class WalletController {
    private final WalletServiceImpl walletServiceImpl;

    @PostMapping("/{id}")
    public ResponseEntity<WalletResponseDto> processTransaction(
            @PathVariable(name = "id") UUID walletId,
            @RequestBody WalletRequestDto request) {
        return ResponseEntity.ok(walletServiceImpl.processTransaction(walletId, request));
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<WalletResponseDto> getBalance(
            @PathVariable(name = "id") UUID walletId
    ) {
        return ResponseEntity.ok(walletServiceImpl.getBalance(walletId));
    }
}
