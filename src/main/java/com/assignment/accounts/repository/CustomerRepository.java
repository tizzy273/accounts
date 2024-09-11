package com.assignment.accounts.repository;

import com.assignment.accounts.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for performing CRUD operations on CustomerEntity.
 * Provides methods to interact with the database for customer entities.
 */
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
}
