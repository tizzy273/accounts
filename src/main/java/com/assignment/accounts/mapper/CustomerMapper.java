package com.assignment.accounts.mapper;

import com.assignment.accounts.dto.Customer;
import com.assignment.accounts.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountMapper accountMapper;

    public Customer toDto(CustomerEntity customerEntity){
        Customer customer =  modelMapper.map(customerEntity, Customer.class);

         customer.setAccounts(accountMapper.mapEntityListToDtoList(customerEntity.getAccountEntities()));

        return customer;
    }


}
