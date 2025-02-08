package com.example.demo.service;

import com.example.demo.dto.WalletRequestDto;
import com.example.demo.dto.WalletResponseDto;

import java.util.UUID;

public interface WalletService {

    WalletResponseDto processTransaction(UUID id, WalletRequestDto walletRequestDto);

    WalletResponseDto getBalance(UUID id);
}
