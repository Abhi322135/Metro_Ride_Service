package com.example.geektrust.Service;

import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Service.Interface.MetroCardService;

public class MetroCardServiceImpl implements MetroCardService {
    public MetroCard addMetroCard(String[] arr){
       MetroCard card = new MetroCard();
        card.setCardNo(arr[1]);
        card.setBalance(Integer.parseInt(arr[2]));
        return card;
    }
    public void refillCardMetroCard(MetroCard metroCard,int minimumCharge) {
        metroCard.setBalance(metroCard.getBalance() + minimumCharge);
    }
}
