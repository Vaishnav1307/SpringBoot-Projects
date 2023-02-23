package com.busReservationSystem.controller;

import com.busReservationSystem.model.Destination;
import com.busReservationSystem.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping("/createDestination/master_user/master_password")
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationService.createDestination(destination);
    }

    @GetMapping("/view_destinations")
    public List<Destination> displayDestinations() {
        return destinationService.displayDestinations();
    }
}
