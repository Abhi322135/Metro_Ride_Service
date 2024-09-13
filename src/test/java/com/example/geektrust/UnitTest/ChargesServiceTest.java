package com.example.geektrust.UnitTest;

import com.example.geektrust.Model.Passenger;
import com.example.geektrust.Model.PassengerType;
import com.example.geektrust.Service.BillServiceImpl;
import com.example.geektrust.Service.ChargesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;

public class ChargesServiceTest {
    @InjectMocks
    private ChargesServiceImpl chargesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addPassenger(){
        PassengerType adult = PassengerType.ADULT;
        PassengerType kid = PassengerType.KID;
        PassengerType seniorCitizen = PassengerType.SENIOR_CITIZEN;
        assertEquals(200, chargesService.getCharges(adult).minimumCharge());
        assertEquals(100, chargesService.getCharges(seniorCitizen).minimumCharge());
        assertEquals(50, chargesService.getCharges(kid).minimumCharge());
    }
}
