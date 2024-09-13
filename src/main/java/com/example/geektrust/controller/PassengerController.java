package com.example.geektrust.controller;

import com.example.geektrust.Model.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassengerController {
     private final List<Passenger> passengerList = new ArrayList<>();
    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }
    public void removePassenger(Passenger passenger){
        passengerList.remove(passenger);
    }
    public void updatePassenger(Passenger passenger){
        Passenger existingPassenger = getPersonAlreadyAvailable(passenger.getMetroCardNo().getCardNo()).get();
        removePassenger(existingPassenger);
        addPassenger(passenger);
    }
    public Optional<Passenger> getPersonAlreadyAvailable(String cardNo){
       return passengerList.stream().filter(p -> p.getMetroCardNo().getCardNo().equals(cardNo)).findAny();
    }
    public List<Passenger> getPassengerList(){
        return passengerList;
    }
}
