package com.example.geektrust.Model.Charges;

import com.example.geektrust.Model.Constant.ServiceCharge;
import com.example.geektrust.Model.PassengerType;

public class KidsCharges extends Charges{

    public KidsCharges(PassengerType passengerType) {
        super(passengerType);
    }

    @Override
    public int minimumCharge() {
        return ServiceCharge.KIDS_CHARGE;
    }
}
