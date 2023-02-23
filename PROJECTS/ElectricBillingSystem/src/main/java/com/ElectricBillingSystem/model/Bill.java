package com.ElectricBillingSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billId;
    private Integer meterNo;
    private String month;
    private String username;
    private Integer unitConsumed;
    private Integer payableAmount;
    private String status = "unpaid";

}
