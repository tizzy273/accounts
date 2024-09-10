package com.assignment.accounts.repository;

import com.assignment.accounts.entity.AccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    @Query
    public List<AccountEntity> getAccountByCustomerId(Integer accountId);
}
