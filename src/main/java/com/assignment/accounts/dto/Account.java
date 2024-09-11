package com.assignment.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;

    private Integer customerId;

    public Account(Integer customerId){
        this.customerId = customerId;
    }
}
