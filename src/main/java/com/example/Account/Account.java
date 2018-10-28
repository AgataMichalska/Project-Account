package com.example.Account;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;
    private String accountName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(String accountName, Customer customer) {
        this.balance = BigDecimal.ZERO;
        this.accountName = accountName;
        this.customer = customer;
    }

}