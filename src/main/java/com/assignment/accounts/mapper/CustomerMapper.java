package com.assignment.accounts.mapper;

import com.assignment.accounts.dto.Customer;
import com.assignment.accounts.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between CustomerEntity and Customer DTO.
 */
@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountMapper accountMapper;

    /**
     * Converts a CustomerEntity to a Customer DTO.
     *
     * @param customerEntity the entity to convert
     * @return the corresponding Customer DTO
     */
    public Customer toDto(CustomerEntity customerEntity) {
        Customer customer = modelMapper.map(customerEntity, Customer.class);

        customer.setAccounts(accountMapper.mapEntityListToDtoList(customerEntity.getAccountEntities()));

        return customer;
    }
}
