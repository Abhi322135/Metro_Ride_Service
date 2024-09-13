package com.example.geektrust.Service;

import com.example.geektrust.Model.Constant.ServiceCharge;
import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.Travel.Station;
import com.example.geektrust.Service.Interface.BillService;

import java.util.HashMap;

public class BillServiceImpl implements BillService {
    private final MetroCardServiceImpl metroCardService = new MetroCardServiceImpl();
    public void calculateBillAtStation(MetroCard metroCard, Station station, int minimumCharge,
                                        HashMap<Station,Double> stationCharges) {
        double tax = 0;
        if (metroCard.getBalance() < minimumCharge){
            tax = (minimumCharge - metroCard.getBalance()) * ServiceCharge.RATE_CHARGE_REFILL;
            metroCardService.refillCardMetroCard(metroCard,minimumCharge - metroCard.getBalance());
        }
        metroCard.setBalance(metroCard.getBalance() - minimumCharge);
        stationCharges.put(station, stationCharges.get(station) + tax + minimumCharge);
    }
}
