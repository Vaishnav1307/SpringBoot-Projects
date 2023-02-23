package com.batch.SpringBatchArraylist.repository;

import com.batch.SpringBatchArraylist.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
