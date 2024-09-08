package com.assignment.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;

    private Integer customerId;

    private List<Transaction> transactions;
}
