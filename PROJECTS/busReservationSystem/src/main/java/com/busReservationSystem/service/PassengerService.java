package com.busReservationSystem.service;

import com.busReservationSystem.model.Passenger;
import com.busReservationSystem.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public void signUp(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public Boolean logIn(String username, String password) {
        Passenger passenger = passengerRepository.login(username);
        if (Objects.nonNull(passenger)) {
            if (passenger.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


}
