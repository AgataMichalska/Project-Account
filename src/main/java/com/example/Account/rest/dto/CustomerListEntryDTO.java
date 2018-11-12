package com.example.Account.rest.dto;

import java.util.List;

public class CustomerListEntryDTO {
    private Long id;
    private String name;
    private List<Long> accountIds;

    public CustomerListEntryDTO(Long id, String name, List<Long> accountIds) {
        this.id = id;
        this.name = name;
        this.accountIds = accountIds;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Long> getAccountIds() {
        return accountIds;
    }
}
