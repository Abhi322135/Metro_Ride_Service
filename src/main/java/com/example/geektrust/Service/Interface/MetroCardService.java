package com.example.geektrust.Service.Interface;

import com.example.geektrust.Model.MetroCard;

public interface MetroCardService {
    MetroCard addMetroCard(String[] arr);
    void refillCardMetroCard(MetroCard metroCard,int minimumCharge);
}
