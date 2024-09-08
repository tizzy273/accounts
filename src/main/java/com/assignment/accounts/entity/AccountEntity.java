package com.assignment.accounts.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ACCOUNT", schema = "ACCOUNTS")
@Data
@NoArgsConstructor
public class AccountEntity {


    public AccountEntity(CustomerEntity customerEntity) {
        this.customer = customerEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID", nullable=false)
    private CustomerEntity customer;



}
