package com.assignment.accounts.controller;

import com.assignment.accounts.dto.Customer;
import com.assignment.accounts.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing customer information.
 */
@RestController
@RequestMapping("${application.basepath}/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Retrieves customer information by ID.
     *
     * @param customerId the ID of the customer to retrieve
     * @return the customer with the specified ID
     */
    @GetMapping("/customer-info")
    public ResponseEntity<Customer> getCustomer(@RequestParam(name = "customer-id") Integer customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
}
