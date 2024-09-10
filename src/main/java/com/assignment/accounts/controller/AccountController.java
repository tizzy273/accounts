package com.assignment.accounts.controller;

import com.assignment.accounts.dto.Account;
import com.assignment.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${application.basepath}/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create-account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.OK);
    }

    @GetMapping("/customer-accounts")
    public ResponseEntity<List<Account>> getAccountsByCustomerId(@RequestParam(name = "customer-id")Integer customerId){
        return new ResponseEntity<>(accountService.getAccountsByCustomerId(customerId), HttpStatus.OK);
    }
}
