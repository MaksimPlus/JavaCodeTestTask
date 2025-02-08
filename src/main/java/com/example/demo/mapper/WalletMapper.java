package com.example.demo.mapper;

import com.example.demo.dto.WalletResponseDto;
import com.example.demo.model.Wallet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletResponseDto toResponseDto(Wallet wallet);

}
