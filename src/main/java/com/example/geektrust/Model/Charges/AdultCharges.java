package com.example.geektrust.Model.Charges;

import com.example.geektrust.Model.Constant.ServiceCharge;
import com.example.geektrust.Model.PassengerType;

public class AdultCharges extends Charges{

    public AdultCharges(PassengerType passengerType) {
        super(passengerType);
    }

    @Override
    public int minimumCharge() {
        return ServiceCharge.ADULT_CHARGE;
    }
}
