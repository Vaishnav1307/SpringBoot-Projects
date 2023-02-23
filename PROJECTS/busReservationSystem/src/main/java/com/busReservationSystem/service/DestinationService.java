package com.busReservationSystem.service;

import com.busReservationSystem.model.Destination;
import com.busReservationSystem.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    DestinationRepository destinationRepository;

    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public List<Destination> displayDestinations() {
        return destinationRepository.findAll();
    }



}
