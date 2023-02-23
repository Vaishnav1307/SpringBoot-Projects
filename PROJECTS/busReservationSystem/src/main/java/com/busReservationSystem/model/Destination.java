package com.busReservationSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        uniqueConstraints =@UniqueConstraint(
                name = "place_unique",
                columnNames = "place_name"
        )
)
public class Destination {
    @Id
    @SequenceGenerator(name = "destination_sequence",
            sequenceName = "destination_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "destination_sequence")
    private Integer destinationId;

    @Column(
            name = "place_name",
            nullable = false
    )
    private String placeName;
    private Integer price;
    private Integer availableSeats = 50;

}
