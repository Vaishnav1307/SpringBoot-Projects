package com.ElectricBillingSystem.service;

import com.ElectricBillingSystem.model.Customer;
import com.ElectricBillingSystem.repository.CustomerRepository;
import com.ElectricBillingSystem.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MeterRepository meterRepository;

    public Customer signUp(Customer customer) {
        return customerRepository.save(customer);
    }

    public Boolean login(String username, String password) {
        Customer customer = customerRepository.login(username);
        if (Objects.nonNull(customer)) {
            if (customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
