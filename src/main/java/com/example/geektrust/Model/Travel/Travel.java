package com.example.geektrust.Model.Travel;

public class Travel {
    private Station sourceStation;
    private Station destStation;

    public Station getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(Station sourceStation) {
        this.sourceStation = sourceStation;
    }

    public Station getDestStation() {
        return destStation;
    }

    public void setDestStation(Station destStation) {
        this.destStation = destStation;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "sourceStation=" + sourceStation +
                ", destStation=" + destStation +
                '}';
    }
}
