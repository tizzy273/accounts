package com.assignment.accounts.mapper;

import com.assignment.accounts.dto.Account;
import com.assignment.accounts.entity.AccountEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    @Autowired
    private ModelMapper modelMapper;



    public Account toDto(AccountEntity accountEntity){
        Account account =  modelMapper.map(accountEntity, Account.class);

        return account;
    }

    public List<Account> mapEntityListToDtoList(List<AccountEntity> accounts){

        return accounts.stream().map(this::toDto).collect(Collectors.toList());

    }

}
