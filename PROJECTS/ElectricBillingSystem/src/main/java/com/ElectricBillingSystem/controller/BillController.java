package com.ElectricBillingSystem.controller;

import com.ElectricBillingSystem.model.Bill;
import com.ElectricBillingSystem.service.BillService;
import com.ElectricBillingSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/generateBill")
    public Object generateBill(@RequestBody Bill bill) {
        return billService.generateBill(bill);
    }

    @GetMapping("/getBill/{meterNo}")
    public Bill getBill(@PathVariable("meterNo") int meterNo) {
        return billService.getBill(meterNo);
    }

    @GetMapping("/payBill/{meterNo}/{amount}")
    public String payBill(@PathVariable("meterNo") Integer meterNo,
                          @PathVariable("amount") Integer amount) {
        return billService.payBill(meterNo, amount);
    }

}
