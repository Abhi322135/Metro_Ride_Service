package com.example.geektrust.UnitTest;

import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Model.Travel.Station;
import com.example.geektrust.Service.BillServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;

public class BillServiceTest {
    @InjectMocks
    private BillServiceImpl billService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCalculateBillAtStation() {
        // Arrange
        MetroCard metroCard = new MetroCard();
        metroCard.setCardNo("MC1");
        metroCard.setBalance(100);
        Station station = Station.CENTRAL;
        int minimumCharge = 50;
        HashMap<Station, Double> stationCharges = new HashMap<>();
        stationCharges.put(station, 0.0);

        //doNothing().when(metroCardService).refillCardMetroCard(metroCard, 5.0);

        // Act
        billService.calculateBillAtStation(metroCard, station, minimumCharge, stationCharges);

        // Assert
        assertEquals(50, metroCard.getBalance());
        assertEquals(50.0, stationCharges.get(station));
    }
    @Test
    void testCalculateBillAtStation2() {
        // Arrange
        MetroCard metroCard = new MetroCard();
        metroCard.setCardNo("MC1");
        metroCard.setBalance(100);
        Station station = Station.CENTRAL;
        int minimumCharge = 200;
        HashMap<Station, Double> stationCharges = new HashMap<>();
        stationCharges.put(station, 0.0);

        //doNothing().when(metroCardService).refillCardMetroCard(metroCard, 5.0);

        // Act
        billService.calculateBillAtStation(metroCard, station, minimumCharge, stationCharges);

        // Assert
        assertEquals(0, metroCard.getBalance());
        assertEquals(202.0, stationCharges.get(station));
    }
}
