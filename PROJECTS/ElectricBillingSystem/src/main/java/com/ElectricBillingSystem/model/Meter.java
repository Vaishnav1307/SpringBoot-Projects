package com.ElectricBillingSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "meter_unique",
                columnNames = "meter_no"
        )
)
public class Meter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer meterId;
    @Column(
            name = "meter_no",
            nullable = false
    )
    private Long meterNo;
    private String name;
    private String address;

}
