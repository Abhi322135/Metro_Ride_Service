package com.example.geektrust.Service.Interface;

import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.Travel.Station;

import java.util.HashMap;

public interface BillService {
    void calculateBillAtStation(MetroCard metroCard, Station station, int minimumCharge,HashMap<Station,Double> stationCharges);
}
