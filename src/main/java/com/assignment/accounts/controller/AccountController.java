package com.assignment.accounts.controller;

import com.assignment.accounts.dto.Account;
import com.assignment.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing accounts.
 */
@RestController
@RequestMapping("${application.basepath}/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Creates a new account.
     *
     * @param account the account to create
     * @return the created account
     */
    @PostMapping("/create-account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    /**
     * Retrieves an account by its ID.
     *
     * @param id the ID of the account to retrieve
     * @return the account with the specified ID
     */
    @GetMapping
    public ResponseEntity<Account> getAccountById(@RequestParam Integer id){
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }
}
