package com.example.geektrust.UnitTest;

import com.example.geektrust.Model.Travel.Station;
import com.example.geektrust.Model.Travel.Travel;
import com.example.geektrust.Service.BillServiceImpl;
import com.example.geektrust.Service.TravelServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;

public class TravelServiceTest {
    @InjectMocks
    private TravelServiceImpl travelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setSourceTravelCentral(){
        Travel travel = new Travel();
        travelService.setTravel(Station.CENTRAL,travel);
        assertEquals(Station.AIRPORT, travel.getDestStation());
        assertEquals(Station.CENTRAL, travel.getSourceStation());
    }

    @Test
    public void setSourceTravelAirport(){
        Travel travel = new Travel();
        travelService.setTravel(Station.AIRPORT,travel);
        assertEquals(Station.CENTRAL, travel.getDestStation());
        assertEquals(Station.AIRPORT, travel.getSourceStation());
    }
}
