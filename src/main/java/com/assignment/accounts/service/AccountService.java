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

import java.util.Optional;

/**
 * Service class for managing accounts.
 * Provides methods to create and retrieve account information.
 */
@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    /**
     * Creates a new account.
     *
     * @param account the account details to create
     * @return the created account
     * @throws BadRequestException if the customer ID is not provided
     * @throws ResourceNotFoundException if the customer with the provided ID is not found
     */
    public Account createAccount(Account account) {
        if (account.getCustomerId() == null) {
            throw new BadRequestException("You have to define a Customer ID for this account");
        }

        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(account.getCustomerId());

        CustomerEntity customerEntity = customerEntityOptional.orElseThrow(() ->
                new ResourceNotFoundException("There is no Customer with ID = " + account.getCustomerId())
        );

        AccountEntity accountEntity = new AccountEntity(customerEntity);
        return accountMapper.toDto(accountRepository.save(accountEntity));
    }

    /**
     * Retrieves an account by its ID.
     *
     * @param id the ID of the account to retrieve
     * @return the account with the specified ID
     * @throws ResourceNotFoundException if the account with the specified ID is not found
     */
    public Account getAccountById(Integer id) {
        AccountEntity accountEntity = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no account with id = " + id));

        return accountMapper.toDto(accountEntity);
    }
}
