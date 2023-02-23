package com.ElectricBillingSystem.service;

import com.ElectricBillingSystem.model.Bill;
import com.ElectricBillingSystem.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Object generateBill(Bill bill) {
        bill.setPayableAmount(bill.getUnitConsumed() * 10);
        return billRepository.save(bill);
    }

    public String payBill(Integer meterNo, Integer amount) {
        Bill bill = billRepository.getBillByMeterNo(meterNo);
        if (bill.getStatus().equalsIgnoreCase("unpaid")) {
            if (bill.getPayableAmount().equals(amount)) {
                bill.setStatus("Paid");
                billRepository.save(bill);
                return "Thank you for payment";
            }
            return "Please enter the valid amount";
        }
        return "You have already done the payment";

    }

    public Bill getBill(int meterNo) {
        return billRepository.getBillByMeterNo(meterNo);
    }
}
