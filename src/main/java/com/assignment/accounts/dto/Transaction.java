package com.assignment.accounts.dto;

import com.assignment.accounts.enums.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaction {

    private Integer id;

    private TransactionType type;

    private Integer accountId;



    private Float amount;

}
