package com.busReservationSystem.repository;

import com.busReservationSystem.model.Destination;
import com.busReservationSystem.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Integer> {

    @Query(
            value = "select * from destination where place_name = ?",
            nativeQuery = true
    )
    public Destination getPrice(String location);


}
