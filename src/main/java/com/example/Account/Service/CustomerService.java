package com.example.Account.Service;


import com.example.Account.Customer;
import com.example.Account.Repository.CustomerRepository;
import com.example.Account.rest.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName(), customerDTO.getSurname());
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getById(long customerId) {
        return customerRepository.findById(customerId).orElseGet(null);
    }
}