package com.example.geektrust.Service.Interface;

import com.example.geektrust.Model.Charges.Charges;
import com.example.geektrust.Model.PassengerType;

public interface ChargeService {
    Charges getCharges(PassengerType type);
}
