package com.assignment.accounts.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Customer {

    private Integer id;

    private String name;

    private String surname;

    List<Account> accounts;

}
