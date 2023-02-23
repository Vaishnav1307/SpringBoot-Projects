package com.batch.SpringBatchArraylist.batch;

import com.batch.SpringBatchArraylist.entity.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Customer, Customer> {


    @Override
    public Customer process(Customer customer) throws Exception {

        return customer;
    }

}
