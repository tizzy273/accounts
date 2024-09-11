package com.assignment.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer id;

    private String name;

    private String surname;

    List<Account> accounts;

}
