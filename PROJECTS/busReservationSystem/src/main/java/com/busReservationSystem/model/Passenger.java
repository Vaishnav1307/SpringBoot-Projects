package com.busReservationSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "username_unique",
                columnNames = "username"
        )
)
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_sequence",
            sequenceName = "passenger_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "passenger_sequence")
    private Integer passengerId;

    private String name;
    @Column(
            name = "username",
            nullable = false
    )
    private String userName;
    @Column(
            nullable = false
    )
    private String password;

}
