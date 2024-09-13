package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            //FileInputStream fis = new FileInputStream("sample_input/input1.txt");
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                CommandLineService  service = new CommandLineService();
                while (sc.hasNextLine()) {
                    String s = sc.nextLine();
                    String[] arr = s.split(" ");
                    service.executeLines(arr);
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
