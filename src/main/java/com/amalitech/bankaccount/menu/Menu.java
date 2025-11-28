package com.amalitech.bankaccount.menu;


import com.amalitech.bankaccount.records.CustomerRecords;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    int choice;
    public void intro() {

        String introFormattedStr = """
                --------------------------------------------
                --------------------------------------------
                |                                          |
                
                |     BANK ACCOUNT MANAGEMENT - MAIN MENU  |                                 |
                --------------------------------------------
                --------------------------------------------
                
                1. Create Account
                2. View Account
                3. Process Transaction
                4. View Transaction History
                5. Exit
                """;

        IO.println(introFormattedStr);

        while (true){

            try{
               int input =  this.receiveChoice();
               this.choice = input;
                break;
            }catch (InputMismatchException _){
                IO.println("Please provide a valid input. Input must be only numbers from 1-5");
            }

        }
    }


    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getChoice(){
        return choice;
    }

    private int receiveChoice() throws InputMismatchException {
        int input;
        Scanner scanner = new Scanner(System.in);
        IO.print("Enter choice: ");
        input = scanner.nextInt();

        if(input > 5 || input < 1) {
            throw new InputMismatchException();
        }

        return input;


    }

    public CustomerRecords receiveCreateAccount() {
        String name;
        int age;
        String contact;
        String address;


        Scanner scanner = new Scanner(System.in);

            IO.print("Enter customer name: ");
            name = scanner.next();

            IO.print("Enter customer age: ");
            age = scanner.nextInt();

            Pattern contactPattern = Pattern.compile("\\+\\d{1,3}-\\d{3}-\\d{4}");
            while (true){
                IO.print("Enter customer contact (+1-555-7890): ");
                if(scanner.hasNext(contactPattern)){
                    contact = scanner.next();
                    break;
                }else{
                    scanner.next();
                }
            }

            IO.print("Enter customer address: ");
            address = scanner.next();

            return new CustomerRecords(name, age, contact, address);


    }


}
