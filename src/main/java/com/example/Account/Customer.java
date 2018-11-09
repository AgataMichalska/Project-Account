package com.example.Account;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private LocalDateTime registrationDateTime;

    public Customer() {
    }

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.salary = BigDecimal.ZERO;
        this.registrationDateTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }
}
