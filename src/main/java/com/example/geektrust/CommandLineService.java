package com.example.geektrust;

public class CommandLineService {
    private final BookMetroService metroService;
    public CommandLineService(){
        metroService = new BookMetroService();
    }
    public void executeLines(String[] arr) {
       switch (arr[0]){
           case "BALANCE" :
               metroService.addMetroCard(arr);
               break;

           case "CHECK_IN":
               metroService.addPassengerDetails(arr);
               break;
           default:
               metroService.printSummary();
       }
    }
}
