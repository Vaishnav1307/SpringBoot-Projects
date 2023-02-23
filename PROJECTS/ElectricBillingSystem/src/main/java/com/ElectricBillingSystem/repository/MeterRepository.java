package com.ElectricBillingSystem.repository;

import com.ElectricBillingSystem.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeterRepository extends JpaRepository<Meter,Integer> {
}
