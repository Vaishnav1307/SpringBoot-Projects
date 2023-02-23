package com.ElectricBillingSystem.repository;

import com.ElectricBillingSystem.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query(
            value = "select * from bill where meter_no = ?",
            nativeQuery = true
    )
    public Bill getBillByMeterNo(int meterNo);


}
