package com.example.Account.Service;


import com.example.Account.Repository.CustomerRepository;
import com.example.Account.Account;
import com.example.Account.Repository.AccountRepository;
import com.example.Account.rest.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    public void saveAccount(AccountDTO accountDTO) {
//
//        Optional<Customer> customerOptional = customerRepository.findById(accountDTO.getCustomerId());
//        if (customerOptional.isPresent()) {
//            Account account = new Account(accountDTO.getAccountName(), customerOptional.get());
//            accountRepository.save(account);
//        }

        customerRepository.findById(accountDTO.getCustomerId()).ifPresent(customer -> {
            Account account = new Account(accountDTO.getAccountName(), customer);
            accountRepository.save(account);
        });
    }
}
