package com.assignment.accounts.service;

import com.assignment.accounts.dto.Account;
import com.assignment.accounts.entity.AccountEntity;
import com.assignment.accounts.entity.CustomerEntity;
import com.assignment.accounts.exception.BadRequestException;
import com.assignment.accounts.mapper.AccountMapper;
import com.assignment.accounts.repository.AccountRepository;
import com.assignment.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;


    public Account createAccount(Account account) {

        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(account.getCustomerId());

        CustomerEntity customerEntity = null;

        if(customerEntityOptional.isPresent()){
             customerEntity = customerEntityOptional.get();
       }
        else {
            throw new BadRequestException("There is no Customer with ID = " + account.getCustomerId());
        }

         AccountEntity accountEntity = new AccountEntity(customerEntity);
         return accountMapper.toDto(accountRepository.save(accountEntity)) ;

 }



}
