package com.assignment.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for account information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;
    private Integer customerId;

    /**
     * Constructs an Account with the specified customer ID.
     *
     * @param customerId the ID of the customer associated with the account
     */
    public Account(Integer customerId){
        this.customerId = customerId;
    }
}
