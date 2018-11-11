package com.example.Account.rest.dto;

import com.example.Account.Customer;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountDTO {

    private Long id;
    private BigDecimal balance;
    private String accountName;
    private CustomerDTO customer;

    public AccountDTO(Long id, BigDecimal balance, String accountName, Customer customer) {
        this.id = id;
        this.balance = balance;
        this.accountName = accountName;
        this.customer = new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getSalary());
    }

    @Getter
    private class CustomerDTO {
        private Long id;
        private String name;
        private String surname;
        private BigDecimal salary;

        CustomerDTO(Long id, String name, String surname, BigDecimal salary) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.salary = salary;
        }
    }
}
