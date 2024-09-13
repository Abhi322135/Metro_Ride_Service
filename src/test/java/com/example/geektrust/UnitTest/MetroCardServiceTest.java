package com.example.geektrust.UnitTest;

import com.example.geektrust.Model.MetroCard;
import com.example.geektrust.Service.ChargesServiceImpl;
import com.example.geektrust.Service.MetroCardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertEquals;

public class MetroCardServiceTest {
    @InjectMocks
    private MetroCardServiceImpl metroCardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addMetroCard(){
        String[] arr = {"","MC1","600"};
        assertEquals(600, metroCardService.addMetroCard(arr).getBalance());
        assertEquals("MC1", metroCardService.addMetroCard(arr).getCardNo());
    }

    @Test
    public void refillMetroCard(){
        MetroCard metroCard =new MetroCard();
        metroCard.setCardNo("MC1");
        metroCard.setBalance(100);
        metroCardService.refillCardMetroCard(metroCard,200);
        assertEquals(300, metroCard.getBalance());
    }
}
