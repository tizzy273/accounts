package com.assignment.accounts.service;


import com.assignment.accounts.dto.Customer;
import com.assignment.accounts.entity.CustomerEntity;
import com.assignment.accounts.exception.ResourceNotFoundException;
import com.assignment.accounts.mapper.CustomerMapper;
import com.assignment.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;


    @Test
    public void getCustomerByIdOk(){

        CustomerEntity customerEntity = new CustomerEntity(1, "John", "Doe",null);
        Customer customer = new Customer(1, "John", "Doe",null);



        when(customerRepository.findById(customerEntity.getId())).thenReturn(Optional.of(customerEntity));

        when(customerMapper.toDto(any())).thenReturn(customer);


        assertEquals(customer, customerService.getCustomerById(customer.getId()));


    }

    @Test
    public void getCustomerByKoWrongId(){


        assertThrows(ResourceNotFoundException.class, () -> {

            when(customerRepository.findById(-1)).thenReturn(Optional.empty());

            customerService.getCustomerById(-1);

        });
    }
}
