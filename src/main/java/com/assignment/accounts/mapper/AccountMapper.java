package com.assignment.accounts.mapper;

import com.assignment.accounts.dto.Account;
import com.assignment.accounts.entity.AccountEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for converting between AccountEntity and Account DTO.
 */
@Component
public class AccountMapper {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Converts an AccountEntity to an Account DTO.
     *
     * @param accountEntity the entity to convert
     * @return the corresponding Account DTO
     */
    public Account toDto(AccountEntity accountEntity) {
        return modelMapper.map(accountEntity, Account.class);
    }

    /**
     * Converts a list of AccountEntity to a list of Account DTOs.
     *
     * @param accounts the list of entities to convert
     * @return the list of corresponding Account DTOs
     */
    public List<Account> mapEntityListToDtoList(List<AccountEntity> accounts) {
        return accounts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
