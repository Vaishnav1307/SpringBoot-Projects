package com.batch.SpringBatchArraylist.batch;

import com.batch.SpringBatchArraylist.entity.Customer;
import com.batch.SpringBatchArraylist.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<Customer> {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    KafkaTemplate<String, List> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

    @Override
    public void write(List<? extends Customer> list) throws Exception {

        objectMapper.writeValueAsString(list);
        kafkaTemplate.send(TOPIC,list);

    }


}
