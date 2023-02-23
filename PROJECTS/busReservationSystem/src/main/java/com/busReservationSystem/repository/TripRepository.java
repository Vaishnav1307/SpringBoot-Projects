package com.busReservationSystem.repository;

import com.busReservationSystem.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    @Query(
            value = "select * from trip where user_name = ?",
            nativeQuery = true
    )
    public List<Trip> getTripWithUsername(String username);

    @Query(
            value = "select amount_to_paid, status from trip where user_name = ?",
            nativeQuery = true
    )
    public List<String> showAmount(String username);


    @Query(
            value = "select SUM(amount_to_paid) from trip where user_name = ?",
            nativeQuery = true
    )
    public String getTotalBill(String username);

    @Modifying
    @Transactional
    @Query(
            value = "update trip set amount_to_paid = 0, status = true where user_name = ? ",
            nativeQuery = true
    )
    public void updateStatus(String userName);

    @Query(
            value = "select * from trip where user_name = ?",
            nativeQuery = true
    )
    List<Trip> view(String username);
}
