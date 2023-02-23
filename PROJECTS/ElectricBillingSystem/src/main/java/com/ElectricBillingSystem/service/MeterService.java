package com.ElectricBillingSystem.service;

import com.ElectricBillingSystem.model.Meter;
import com.ElectricBillingSystem.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeterService {

    @Autowired
    private MeterRepository meterRepository;
    public Meter createMeter(Meter meter) {
        return meterRepository.save(meter);
    }
}
