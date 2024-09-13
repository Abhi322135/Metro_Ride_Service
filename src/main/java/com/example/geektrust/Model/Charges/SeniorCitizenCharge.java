package com.example.geektrust.Model.Charges;

import com.example.geektrust.Model.Constant.ServiceCharge;
import com.example.geektrust.Model.PassengerType;

public class SeniorCitizenCharge extends Charges{
    public SeniorCitizenCharge(PassengerType passengerType) {
        super(passengerType);
    }

    @Override
    public int minimumCharge() {
        return ServiceCharge.SENIOR_CITIZEN_CHARGE;
    }
}
