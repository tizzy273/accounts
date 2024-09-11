package com.assignment.accounts.service;

import com.assignment.accounts.dto.Customer;
import com.assignment.accounts.entity.CustomerEntity;
import com.assignment.accounts.exception.ResourceNotFoundException;
import com.assignment.accounts.mapper.CustomerMapper;
import com.assignment.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing customers.
 * Provides a method to retrieve customer information by ID.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * Retrieves a customer by its ID.
     *
     * @param customerId the ID of the customer to retrieve
     * @return the customer with the specified ID
     * @throws ResourceNotFoundException if the customer with the specified ID is not found
     */
    public Customer getCustomerById(Integer customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no Customer with ID = " + customerId));

        return customerMapper.toDto(customerEntity);
    }
}
