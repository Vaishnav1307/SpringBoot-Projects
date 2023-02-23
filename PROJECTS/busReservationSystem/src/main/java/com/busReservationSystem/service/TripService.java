package com.busReservationSystem.service;

import com.busReservationSystem.controller.PassengerController;
import com.busReservationSystem.model.Destination;
import com.busReservationSystem.model.Trip;
import com.busReservationSystem.repository.DestinationRepository;
import com.busReservationSystem.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private PassengerController passengerController;

    public Trip bookTrip(String userName, String password, Trip trip) {
        if (passengerController.logIn(userName, password)) {
            Destination destination = destinationRepository.getPrice(trip.getPlace());
            trip.setAmountToPaid(trip.getNoOfPassenger() * destination.getPrice());
            trip.setUserName(userName);
            destination.setAvailableSeats(destination.getAvailableSeats()-trip.getNoOfPassenger());
            destinationRepository.save(destination);
            return tripRepository.save(trip);
        }
        return null;
    }

    public List<String> pay(String username) {
        return Collections.singletonList("Your Bill amount and status is " + tripRepository.showAmount(username).toString());
    }

    public String getTotalBill(String userName) {
        return "Your Total amount of bill is " + tripRepository.getTotalBill(userName);
    }

    public String payBill(String userName, String amount) {
        if (amount.equals(tripRepository.getTotalBill(userName))) {
            tripRepository.updateStatus(userName);
            return "Thank you for payment";
        }
        return "Please enter valid amount";
    }


    public List<Trip> view(String username) {
        return tripRepository.view(username);
    }
}
