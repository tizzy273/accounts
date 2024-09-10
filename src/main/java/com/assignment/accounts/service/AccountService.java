package com.assignment.accounts.service;

import com.assignment.accounts.dto.Account;
import com.assignment.accounts.entity.AccountEntity;
import com.assignment.accounts.entity.CustomerEntity;
import com.assignment.accounts.exception.BadRequestException;
import com.assignment.accounts.exception.ResourceNotFoundException;
import com.assignment.accounts.mapper.AccountMapper;
import com.assignment.accounts.repository.AccountRepository;
import com.assignment.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if(account.getCustomerId() == null){
            throw new BadRequestException("You have to define a Customer ID for this account");
        }

        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(account.getCustomerId());

        CustomerEntity customerEntity = null;

        if(customerEntityOptional.isPresent()){
             customerEntity = customerEntityOptional.get();
       }
        else {
            throw new ResourceNotFoundException("There is no Customer with ID = " + account.getCustomerId());
        }

         AccountEntity accountEntity = new AccountEntity(customerEntity);
         return accountMapper.toDto(accountRepository.save(accountEntity)) ;

 }


    public Account getAccountById(Integer id) {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findById(id);

        if(accountEntityOptional.isEmpty()){
            throw new ResourceNotFoundException("There is no account with id = " + id);
        }
        else {
            return accountMapper.toDto(accountEntityOptional.get());
        }
    }
}
