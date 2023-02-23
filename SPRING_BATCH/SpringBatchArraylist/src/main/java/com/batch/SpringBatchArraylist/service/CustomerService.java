package com.batch.SpringBatchArraylist.service;

import com.batch.SpringBatchArraylist.dto.CustomerDto;
import com.batch.SpringBatchArraylist.entity.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private ModelMapper modelMapper;

    private CustomerDto convertEntityToDto(Customer customer) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CustomerDto customerDto = new CustomerDto();
        customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }
}
