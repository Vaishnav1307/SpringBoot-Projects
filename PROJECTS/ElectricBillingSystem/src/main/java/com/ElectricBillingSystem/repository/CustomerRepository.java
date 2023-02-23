package com.ElectricBillingSystem.repository;

import com.ElectricBillingSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(
            value = "select * from customer where username = ?",
            nativeQuery = true
    )
    public Customer login(String username);
}
