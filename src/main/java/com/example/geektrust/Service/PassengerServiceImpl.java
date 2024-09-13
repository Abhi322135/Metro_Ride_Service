package com.example.geektrust.Service;

import com.example.geektrust.Model.Passenger;
import com.example.geektrust.Model.PassengerType;
import com.example.geektrust.Model.Travel.Station;
import com.example.geektrust.Service.Interface.PassengerService;
import com.example.geektrust.controller.PassengerController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class PassengerServiceImpl implements PassengerService {
    private final PassengerController passengerController;

    public PassengerServiceImpl(){
        passengerController = new PassengerController();
    }
    public void calculatePassengerAtEachStation(Station station, Passenger passenger1,
                                                HashMap<Station,List<PassengerType>> stationPassengerTypeHashMap) {
        List<PassengerType> list = stationPassengerTypeHashMap.get(station);
        list.add(passenger1.getType());
        stationPassengerTypeHashMap.put(station,list);
    }
    public void addPassenger(Passenger passenger){
        passengerController.addPassenger(passenger);
    }
    public void updatePassenger(Passenger passenger){
        passengerController.updatePassenger(passenger);
    }
    public Optional<Passenger> getPersonAlreadyAvailable(String metroCardNo){
        return passengerController.getPersonAlreadyAvailable(metroCardNo);
    }
}
