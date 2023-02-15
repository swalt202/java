package com.emailer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scan();
    }
    public static void Scan(){
        System.out.println("Welcome to the Email CLI. What Action Would you Like to Perform?");
        System.out.println("A: Send New Email");
        System.out.println("B: View Sent Emails");
        System.out.println("C: Quit Program");
        selection();
    }
    public static void selection(){
        Scanner sc = new Scanner(System.in);
        SendGid sd = new SendGid();
        String option = sc.nextLine();
            switch(option.toUpperCase()) {
                case "A": //Send New Email
                    sd.scannerInputs();
                    break;
                case "B": //View Sent Emails {Query DB}
                    System.out.println("You Chose B");
                    sc.close();
                    break;
                case "C":
                    break;
                default: //User Input Unknown
                    System.out.println("Unknown Action");
                    Scan();
                    break;
            }

    }
}