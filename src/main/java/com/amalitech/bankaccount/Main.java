package com.amalitech.bankaccount;

import com.amalitech.bankaccount.account.Account;
import com.amalitech.bankaccount.account.CheckingAccount;
import com.amalitech.bankaccount.account.SavingsAccount;
import com.amalitech.bankaccount.customer.Customer;
import com.amalitech.bankaccount.customer.PremiumCustomer;
import com.amalitech.bankaccount.customer.RegularCustomer;
import com.amalitech.bankaccount.enums.AccountType;
import com.amalitech.bankaccount.enums.CustomerType;
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
                    CustomerType customerType;
                    AccountType accountType;
                    double initialDeposit;
                    Account account;
                    Customer customer;
                    final double MINIMUM_BALANCE = 500;


                    CustomerRecords customerRecords = menu.createAccount();
                    name = customerRecords.name();
                    age = customerRecords.age();
                    contact = customerRecords.contact();
                    address = customerRecords.address();

                    customerType = menu.customerType();
                    accountType = menu.accountType();


                    if(customerType == CustomerType.REGULAR){
                        //Customer(String name, int age, String contact, String address)
                        customer = new RegularCustomer(name, age, contact, address);
                    }else{
                        customer = new PremiumCustomer(name, age, contact, address);
                    }

                    if(accountType == AccountType.SAVINGS){
                        while (true){
                            initialDeposit = menu.acceptDoubleInputValue("Enter initial deposit amount: $", "Please provide a valid amount!");
                            if(initialDeposit >= MINIMUM_BALANCE){
                                break;
                            }else{
                                IO.println("With Savings account you must have at least $" + MINIMUM_BALANCE);
                            }
                        }

                        account = new SavingsAccount(customer);
                        account.deposit(initialDeposit);
                    }else{

                        account = new CheckingAccount(customer);
                    }



                    IO.println("\nName: " + name + "\nAge: " + age + "\nContact: "+contact + "\nAddess: "+ address + "\nCustomer Type: "+ customerType + "\nAccount Type: " + accountType + "\nInitial Deposit: "+ intialDeposit);

                }
            }

            break;
        }


    }
}
