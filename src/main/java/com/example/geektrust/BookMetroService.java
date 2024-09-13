package com.example.geektrust;

import com.example.geektrust.Model.Charges.Charges;
import com.example.geektrust.Model.Constant.ServiceCharge;
import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.Passenger;
import com.example.geektrust.Model.PassengerType;
import com.example.geektrust.Model.Travel.Station;
import com.example.geektrust.Model.Travel.Travel;
import com.example.geektrust.Service.*;
import com.example.geektrust.Service.Interface.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class BookMetroService {
    private final HashMap<String,MetroCard> metroCardHashMap= new HashMap<>();
    private final HashMap<Station,List<PassengerType>> stationPassengerTypeHashMap = new HashMap<>();
    private final HashMap<Station,Double> stationCharges = new HashMap<>();
    private final HashMap<Station,Integer> discountMap = new HashMap<>();
    private final MetroCardService metroCardService = new MetroCardServiceImpl();
    private final TravelService travelService = new TravelServiceImpl();
    private final BillService billService = new BillServiceImpl();
    private final PassengerService passengerService = new PassengerServiceImpl();
    private final ChargeService chargesService = new ChargesServiceImpl();
    public BookMetroService(){
        stationCharges.put(Station.CENTRAL,ServiceCharge.DUMMY_ZERO_DOUBLE);
        stationCharges.put(Station.AIRPORT,ServiceCharge.DUMMY_ZERO_DOUBLE);
        discountMap.put(Station.CENTRAL,ServiceCharge.DUMMY_ZERO_INT);
        discountMap.put(Station.AIRPORT,ServiceCharge.DUMMY_ZERO_INT);
        stationPassengerTypeHashMap.put(Station.CENTRAL,new ArrayList<>());
        stationPassengerTypeHashMap.put(Station.AIRPORT,new ArrayList<>());
    }

    public void addMetroCard(String[] arr) {
        MetroCard card = metroCardService.addMetroCard(arr);
        metroCardHashMap.put(arr[1],card);
    }

    public void addPassengerDetails(String[] arr) {
        String passengerId = arr[1];
        PassengerType type = PassengerType.valueOf(arr[2]);
        Station station = Station.valueOf(arr[3]);

        Optional<Passenger> passengerOpt = passengerService.getPersonAlreadyAvailable(passengerId);
        MetroCard metroCard = metroCardHashMap.get(passengerId);
        Charges charges = chargesService.getCharges(type);
        Travel travel = travelService.setTravel(station, new Travel());

        if (passengerOpt.isPresent()) {
            updateExistingPassenger(passengerOpt.get(), travel, station, metroCard, charges);
        } else {
            createNewPassenger(type, metroCard, charges, travel, station);
        }
    }
    private void updateExistingPassenger(Passenger passenger, Travel travel, Station station, MetroCard metroCard, Charges charges) {
        passengerService.calculatePassengerAtEachStation(station, passenger, stationPassengerTypeHashMap);
        passenger.addTravel(travel);
        passengerService.updatePassenger(passenger);
        processBillForExistingPassenger(metroCard, station, charges, passenger.getTravelHistory());
    }

    private void processBillForExistingPassenger(MetroCard metroCard, Station station, Charges charges, List<Travel> travelList) {
        if (travelList.size() % 2 == 0) {
            billService.calculateBillAtStation(metroCard, station, charges.minimumCharge() / 2, stationCharges);
            discountMap.put(station, discountMap.get(station) + charges.minimumCharge() / 2);
        } else {
            billService.calculateBillAtStation(metroCard, station, charges.minimumCharge(), stationCharges);
        }
    }

    private void createNewPassenger(PassengerType type, MetroCard metroCard, Charges charges, Travel travel, Station station) {
        Passenger newPassenger = new Passenger(type, metroCard, charges);
        newPassenger.addTravel(travel);
        passengerService.addPassenger(newPassenger);
        billService.calculateBillAtStation(metroCard, station, charges.minimumCharge(), stationCharges);
        passengerService.calculatePassengerAtEachStation(station, newPassenger, stationPassengerTypeHashMap);
    }

    public void printSummary() {
        printSummary_(Station.CENTRAL);
        printSummary_(Station.AIRPORT);
    }

    private void printSummary_(Station station) {
        double value = stationCharges.get(station);
        System.out.println("TOTAL_COLLECTION "+station+" "+(int)value+" "+discountMap.get(station));
        System.out.println("PASSENGER_TYPE_SUMMARY");
        int adultCount = 0;
        int kidCount = 0;
        int seniorCitizenCount = 0;
        List<PassengerType> typeList = stationPassengerTypeHashMap.get(station);
        for (PassengerType type : typeList){
            if (type.equals(PassengerType.ADULT)) adultCount++;
            else if (type.equals(PassengerType.KID)) kidCount++;
            else seniorCitizenCount++;
        }

        if (adultCount > 0) System.out.println("ADULT "+adultCount);
        if (kidCount > 0) System.out.println("KID "+kidCount);
        if (seniorCitizenCount > 0) System.out.println("SENIOR_CITIZEN " +seniorCitizenCount);
    }

}
