package com.example.Account.Service;


import com.example.Account.Repository.CustomerRepository;
import com.example.Account.Account;
import com.example.Account.Repository.AccountRepository;
import com.example.Account.rest.dto.AccountDTO;
import com.example.Account.rest.dto.AccountListEntryDTO;
import com.example.Account.rest.dto.SaveAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<AccountListEntryDTO> getAllAccounts() {

        return accountRepository.findAll()
                .stream()
                .map(account -> new AccountListEntryDTO(
                        account.getId(),
                        account.getAccountName(),
                        account.getCustomer().getId()))
                .collect(Collectors.toList());
    }


    public void saveAccount(SaveAccountDTO saveAccountDTO) {
//
//        Optional<Customer> customerOptional = customerRepository.findById(saveAccountDTO.getCustomerId());
//        if (customerOptional.isPresent()) {
//            Account account = new Account(saveAccountDTO.getAccountName(), customerOptional.get());
//            accountRepository.save(account);
//        }

        customerRepository.findById(saveAccountDTO.getCustomerId()).ifPresent(customer -> {
            Account account = new Account(saveAccountDTO.getAccountName(), customer);
            accountRepository.save(account);
        });
    }

    public AccountDTO getById(long accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            return new AccountDTO(account.getId(),
                    account.getBalance(),
                    account.getAccountName(),
                    account.getCustomer());
        }
        return null;
    }
}
