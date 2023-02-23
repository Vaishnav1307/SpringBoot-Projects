package com.busReservationSystem.controller;

import com.busReservationSystem.model.Passenger;
import com.busReservationSystem.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PassengerController {
    private Boolean login;
    @Autowired
    private PassengerService passengerService;


    @PostMapping("/signup")
    public String signUp(@RequestBody Passenger passenger) {
        passengerService.signUp(passenger);
        return "Account is created ! Welcome to Bus Reservation System, Please login with your credentials to avail our services";
    }

    @GetMapping("/login/{username}/{password}")
    public Boolean logIn(@PathVariable("username") String username, @PathVariable("password") String password){
        login = passengerService.logIn(username, password);
        return login;
    }

}
