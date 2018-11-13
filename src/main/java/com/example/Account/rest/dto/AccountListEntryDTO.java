package com.example.Account.rest.dto;

import lombok.Getter;

@Getter
public class AccountListEntryDTO {

    private Long accountId;
    private String accountName;
    private Long customerId;

    public AccountListEntryDTO(Long accountId, String accountName, Long customerId) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.customerId = customerId;
    }
}
