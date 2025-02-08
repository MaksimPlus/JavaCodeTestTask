package com.example.demo.service;

import com.example.demo.dto.WalletRequestDto;
import com.example.demo.dto.WalletResponseDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.EError;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.WalletMapper;
import com.example.demo.model.EOperationType;
import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @Override
    @Transactional
    public WalletResponseDto processTransaction(UUID walletId, WalletRequestDto walletRequestDto) {
        Wallet wallet = getWalletById(walletId);

        String operationType = walletRequestDto.getOperationType();
        switch (EOperationType.getOperationTypeByTitle(operationType)) {
            case DEPOSIT -> {
                return deposit(wallet, walletRequestDto.getAmount());
            }
            case WITHDRAW -> {
                return withdraw(wallet, walletRequestDto.getAmount());
            }
        }

        throw new BadRequestException(EError.BAD_REQUEST);
    }

    @Transactional
    public WalletResponseDto getBalance(UUID walletId) {
        Wallet wallet = getWalletById(walletId);
        return walletMapper.toResponseDto(wallet);
    }

    private WalletResponseDto deposit(Wallet wallet, float amount) {
        wallet.setBalance(wallet.getBalance() + amount);
        Wallet saved = walletRepository.save(wallet);
        return walletMapper.toResponseDto(saved);
    }

    private WalletResponseDto withdraw(Wallet wallet, float amount) {
        if (wallet.getBalance() < amount)
            throw new BadRequestException(EError.INSUFFICIENT_FUNDS);
        wallet.setBalance(wallet.getBalance() - amount);
        Wallet saved = walletRepository.save(wallet);
        return walletMapper.toResponseDto(saved);
    }

    private Wallet getWalletById(UUID walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new NotFoundException(EError.WALLET_NOT_FOUND));
    }
}
