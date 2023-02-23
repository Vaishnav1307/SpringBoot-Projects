package com.ElectricBillingSystem.controller;

import com.ElectricBillingSystem.model.Customer;
import com.ElectricBillingSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/signUp")
    public Customer signUp(@RequestBody Customer customer ){
        return customerService.signUp(customer);
    }

    @GetMapping("/login/{username}/{password}")
    public Boolean login(@PathVariable("username") String username, @PathVariable("password") String password){
        return customerService.login(username,password);
    }
}
