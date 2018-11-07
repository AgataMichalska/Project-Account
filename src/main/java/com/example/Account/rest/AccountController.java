package com.example.Account.rest;


import com.example.Account.Account;
import com.example.Account.Service.AccountService;
import com.example.Account.rest.dto.AccountDTO;
import com.example.Account.rest.dto.AccountListEntryDTO;
import com.example.Account.rest.dto.CustomerDTO;
import com.example.Account.rest.dto.SaveAccountDTO;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping
    public List<AccountListEntryDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public AccountDTO getById(@PathVariable ("id") long accountId){
        return accountService.getById(accountId);
    }

    @PostMapping
    public void saveAccount(@RequestBody SaveAccountDTO saveAccountDTO) {
        accountService.saveAccount(saveAccountDTO);
    }

}
