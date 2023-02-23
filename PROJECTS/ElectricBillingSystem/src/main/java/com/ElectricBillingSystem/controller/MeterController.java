package com.ElectricBillingSystem.controller;

import com.ElectricBillingSystem.model.Meter;
import com.ElectricBillingSystem.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeterController {

    @Autowired
    private MeterService meterService;

    @PostMapping("/createMeter")
    public Meter createMeter(@RequestBody Meter meter){
        return meterService.createMeter(meter);
    }
}
