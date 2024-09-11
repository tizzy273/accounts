package com.assignment.accounts.service;

import com.assignment.accounts.dto.Account;
import com.assignment.accounts.entity.AccountEntity;
import com.assignment.accounts.entity.CustomerEntity;
import com.assignment.accounts.exception.BadRequestException;
import com.assignment.accounts.exception.ResourceNotFoundException;
import com.assignment.accounts.mapper.AccountMapper;
import com.assignment.accounts.repository.AccountRepository;
import com.assignment.accounts.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {


    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper accountMapper;

    @Mock
    private CustomerRepository customerRepository;


    @Test
    public void createAccountTestOk(){

        Integer customerId = 1;

        Account inputAccount = new Account(customerId);



        CustomerEntity customerEntity = new CustomerEntity(1, "John", "Doe", new ArrayList<>()); // Customer with no accounts

        Account expectedAccount = new Account(1, customerId);

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customerEntity));
        when(accountMapper.toDto(any())).thenReturn(expectedAccount);

        assertEquals(expectedAccount, accountService.createAccount(inputAccount));

    }


        @Test
        public void createAccountTestKoMissingId(){
        assertThrows(ResourceNotFoundException.class, () -> {
                Account account = new Account(1);
                accountService.createAccount(account);

        });


    }

    @Test
    public void createAccountTestKoMissingCustomerId() {
        assertThrows(BadRequestException.class, () -> {
            Account account = new Account();
            accountService.createAccount(account);

        });
    }


    @Test
    public void getAccountById(){

        Account account = new Account(1,1);

        AccountEntity accountEntity = new AccountEntity();


        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(accountEntity));

        when(accountMapper.toDto(accountEntity)).thenReturn(account);

        assertEquals(account, accountService.getAccountById(account.getId()));
    }

    @Test
    public void getAccountByKoWrongId(){
            assertThrows(ResourceNotFoundException.class, () -> {

            when(accountRepository.findById(-1)).thenReturn(Optional.empty());

            accountService.getAccountById(-1);

        });
    }

}
