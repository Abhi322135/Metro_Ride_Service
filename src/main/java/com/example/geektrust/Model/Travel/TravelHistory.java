package com.example.geektrust.Model.Travel;

import com.example.geektrust.Model.Travel.Travel;

import java.util.ArrayList;
import java.util.List;

public class TravelHistory {
    private List<Travel> travel;
    public TravelHistory(){
        travel = new ArrayList<>();
    }

    public List<Travel> getTravel() {
        return travel;
    }

    public void setTravel(List<Travel> travel) {
        this.travel = travel;
    }

    @Override
    public String toString() {
        return "TravelHistory{" +
                "travel=" + travel +
                '}';
    }
}
