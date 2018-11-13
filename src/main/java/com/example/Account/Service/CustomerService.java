package com.example.Account.Service;


import com.example.Account.Customer;
import com.example.Account.Repository.CustomerRepository;
import com.example.Account.rest.dto.CustomerDTO;
import com.example.Account.rest.dto.CustomerListEntryDTO;
import com.example.Account.rest.dto.SaveCustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(SaveCustomerDTO saveCustomerDTO) {
        Customer customer = new Customer(saveCustomerDTO.getName(), saveCustomerDTO.getSurname());
        customerRepository.save(customer);
    }

    public List<CustomerListEntryDTO> getAllCustomers() {

//        List<CustomerListEntryDTO> customerListEntryDTOS = new ArrayList<>();
//        List<Customer> customers = customerRepository.findAll();
//        for (Customer c : customers) {
//            customerListEntryDTOS.add(new CustomerListEntryDTO(c.getId(),c.getName(),null));
//        }
//        return customerListEntryDTOS;

        return customerRepository.findAll()
                .stream()
                .map(customer -> new CustomerListEntryDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getAccounts()
                                .stream()
                                .map(account -> account.getId()).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public CustomerDTO getById(long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return new CustomerDTO(customer.getId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getSalary(),
                    customer.getRegistrationDateTime(),
                    customer.getAccounts());

        }
        return null;
    }
}