package com.assignment.accounts.repository;

import com.assignment.accounts.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on AccountEntity.
 * Provides methods to interact with the database for account entities.
 */
@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
}
