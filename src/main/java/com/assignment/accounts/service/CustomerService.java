package com.assignment.accounts.service;

import com.assignment.accounts.dto.Customer;
import com.assignment.accounts.entity.CustomerEntity;
import com.assignment.accounts.exception.BadRequestException;
import com.assignment.accounts.mapper.CustomerMapper;
import com.assignment.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;


    public Customer getCustomerById(Integer customerId) {

        Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(customerId);

        if(customerEntityOptional.isPresent()) {
            return customerMapper.toDto(customerEntityOptional.get());
        }
        else{
            throw new BadRequestException("There is no Customer with ID = " + customerId);
        }
    }



}
