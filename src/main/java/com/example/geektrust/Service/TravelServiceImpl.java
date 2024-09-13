package com.example.geektrust.Service;

import com.example.geektrust.Model.Travel.Station;
import com.example.geektrust.Model.Travel.Travel;
import com.example.geektrust.Service.Interface.TravelService;

public class TravelServiceImpl implements TravelService {
    public Travel setTravel(Station station, Travel travel){
        if (station.equals(Station.AIRPORT)){
            travel.setSourceStation(Station.AIRPORT);
            travel.setDestStation(Station.CENTRAL);
        }
        else if (station.equals(Station.CENTRAL)){
            travel.setSourceStation(Station.CENTRAL);
            travel.setDestStation(Station.AIRPORT);
        }
        return travel;
    }
}
