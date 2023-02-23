package com.busReservationSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip {

    @Id
    @SequenceGenerator(name = "trip_sequence",
            sequenceName = "trip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "trip_sequence")
    private Integer tripId;
    private String place;
    private Integer noOfPassenger;
    private Boolean status = false;
    private Integer amountToPaid;
    private String userName;

}
