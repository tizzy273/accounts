package com.assignment.accounts.repository;

import com.assignment.accounts.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer > {
}
