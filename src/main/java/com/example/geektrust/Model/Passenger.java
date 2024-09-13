package com.example.geektrust.Model;

import com.example.geektrust.Model.Charges.Charges;
import com.example.geektrust.Model.Travel.Travel;
import com.example.geektrust.Model.Travel.TravelHistory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Passenger {
    private PassengerType type;
    private MetroCard metroCardNo;
    private Charges charges;
    private List<Travel> travelHistory;

    public Passenger(PassengerType type, MetroCard metroCardNo, Charges charges) {
        this.type = type;
        this.metroCardNo = metroCardNo;
        this.charges = charges;
        travelHistory = new ArrayList<>();
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public MetroCard getMetroCardNo() {
        return metroCardNo;
    }

    public void setMetroCardNo(MetroCard metroCardNo) {
        this.metroCardNo = metroCardNo;
    }

    public Charges getCharges() {
        return charges;
    }

    public void setCharges(Charges charges) {
        this.charges = charges;
    }

    public List<Travel> getTravelHistory() {
        return Collections.unmodifiableList(travelHistory); // Prevent external modification
    }

    public void addTravel(Travel travel) {
        this.travelHistory.add(travel);
    }

    public void removeTravel(Travel travel) {
        this.travelHistory.remove(travel);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "type=" + type +
                ", metroCardNo=" + metroCardNo +
                ", charges=" + charges +
                ", travelHistory=" + travelHistory +
                '}';
    }
}
