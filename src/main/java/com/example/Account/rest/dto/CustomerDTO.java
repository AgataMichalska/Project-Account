package com.example.Account.rest.dto;

import com.example.Account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private BigDecimal salary;
    private LocalDateTime registrationDateTime;
    private List<AccountDTO> accounts;

    public CustomerDTO(Long id, String name, String surname, BigDecimal salary, LocalDateTime registrationDateTime, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.registrationDateTime = registrationDateTime;
        this.accounts = accounts.stream()
                .map(account -> new CustomerDTO.AccountDTO(account.getId(), account.getBalance(), account.getAccountName()))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    private class AccountDTO {
        private Long id;
        private BigDecimal balance;
        private String accountName;

        public AccountDTO(Long id, BigDecimal balance, String accountName) {
            this.id = id;
            this.balance = balance;
            this.accountName = accountName;
        }

        public Long getId() {
            return id;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public String getAccountName() {
            return accountName;
        }
    }
}
