package com.example.geektrust.Service;

import com.example.geektrust.Model.Charges.AdultCharges;
import com.example.geektrust.Model.Charges.Charges;
import com.example.geektrust.Model.Charges.KidsCharges;
import com.example.geektrust.Model.Charges.SeniorCitizenCharge;
import com.example.geektrust.Model.PassengerType;
import com.example.geektrust.Service.Interface.ChargeService;

public class ChargesServiceImpl implements ChargeService {
    public Charges getCharges(PassengerType type) {
        switch (type){
            case ADULT:
                return new AdultCharges(PassengerType.ADULT);

            case KID:
                return new KidsCharges(PassengerType.KID);

            default:
                return new SeniorCitizenCharge(PassengerType.SENIOR_CITIZEN);
        }
    }
}
