package com.example.geektrust.Service.Interface;

import com.example.geektrust.Model.Passenger;
import com.example.geektrust.Model.PassengerType;
import com.example.geektrust.Model.Travel.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface PassengerService {
    void addPassenger(Passenger passenger);
    void updatePassenger(Passenger passenger);
    Optional<Passenger> getPersonAlreadyAvailable(String metroCardNo);
    void calculatePassengerAtEachStation(Station station, Passenger passenger1, HashMap<Station, List<PassengerType>> stationPassengerTypeHashMap);
}
