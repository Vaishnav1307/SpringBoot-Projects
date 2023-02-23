package com.busReservationSystem.repository;

import com.busReservationSystem.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

    @Query(
            value = "select * from passenger where username = ?",
            nativeQuery = true
    )
    public Passenger login(String username);


}
