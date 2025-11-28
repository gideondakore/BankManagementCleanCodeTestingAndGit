package com.amalitech.bankaccount;

import com.amalitech.bankaccount.menu.Menu;
import com.amalitech.bankaccount.records.CustomerRecords;


public class Main {
    public static void main(String[] args){
        Menu menu  = new Menu();


        while(true){
            menu.intro();
            int input = menu.getChoice();
            IO.println("Enter choice: " + menu.getChoice());

            switch (input){
                case 1: {
                    String name;
                    int age;
                    String contact;
                    String address;

                    CustomerRecords customerRecords = menu.receiveCreateAccount();
                    name = customerRecords.name();
                    age = customerRecords.age();
                    contact = customerRecords.contact();
                    address = customerRecords.address();

                    IO.println("Name:");

                }
            }
        }


    }
}
