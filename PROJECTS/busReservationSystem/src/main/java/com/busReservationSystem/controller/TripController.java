package com.busReservationSystem.controller;

import com.busReservationSystem.model.Trip;
import com.busReservationSystem.repository.DestinationRepository;
import com.busReservationSystem.service.PassengerService;
import com.busReservationSystem.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/bookTrip/{username}/{password}")
    public Trip bookTrip(@PathVariable("username") String username,
                         @PathVariable("password") String password,
                         @RequestBody Trip trip) {
        return tripService.bookTrip(username, password, trip);
    }


    @GetMapping("/ShowOrderHistory/{username}")
    public List<String> ShowOrderHistory(@PathVariable("username") String username) {
        return tripService.pay(username);
    }

    @GetMapping("/bill/{username}")
    public String getTotalBill(@PathVariable("username") String username) {
        return tripService.getTotalBill(username);
    }

    @GetMapping("/payBill/{username}/{amount}")
    public String payBill(@PathVariable("username") String username,
                          @PathVariable("amount") String amount) {
        return tripService.payBill(username, amount);
    }

    @GetMapping("/view/{username}")
    public List<Trip> view(@PathVariable("username") String username) {
        return tripService.view(username);
    }


}
