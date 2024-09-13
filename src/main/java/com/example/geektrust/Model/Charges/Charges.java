package com.example.geektrust.Model.Charges;

import com.example.geektrust.Model.PassengerType;

public abstract class Charges {
    private PassengerType passengerType;

    public Charges(PassengerType passengerType) {
        this.passengerType = passengerType;
    }
    public abstract int minimumCharge();
}
