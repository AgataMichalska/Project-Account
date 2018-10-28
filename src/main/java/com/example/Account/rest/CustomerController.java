package com.example.Account.rest;


import com.example.Account.Customer;
import com.example.Account.Service.CustomerService;
import com.example.Account.rest.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    private Customer getId(@PathVariable("id") long customerId) {
        return customerService.getById(customerId);
    }

    @PostMapping("/customer")
    public void postCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
    }


}
