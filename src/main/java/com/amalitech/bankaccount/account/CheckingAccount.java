package com.amalitech.bankaccount.account;

import com.amalitech.bankaccount.customer.Customer;
import com.amalitech.bankaccount.enums.AccountType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CheckingAccount extends Account{
    private double overdraftLimit;
    private double monthlyFee;
    private static final String CUSTOMER_TYPE = AccountType.CHECKING.getDescription();
    private LocalDate createdAt = LocalDate.now();


    public  CheckingAccount(Customer customer){
        super(customer);
        overdraftLimit = 1000;
        monthlyFee = 10;
        this.setType(AccountType.CHECKING);
    }


    @Override
    public double withdrawal(double amount) throws IllegalArgumentException{
        if(amount < 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        // apply monthly fess before withdrawal
        this.applyMonthlyFee();

        if((this.getAccountBalance() - amount) < -overdraftLimit){
            throw new IllegalArgumentException("You have reach your overdraft limit.");
        }

        if((this.getAccountBalance() - amount) < 0){
            throw new IllegalArgumentException("You have insufficient amount.");
        }

        super.withdrawal(amount);

        return this.getAccountBalance();
    }

    private void applyMonthlyFee(){
        LocalDate currentDate = LocalDate.now();
        long days = ChronoUnit.DAYS.between(createdAt, currentDate);

        if(days >= 30){
            this.setAccountBalance(this.getAccountBalance() - monthlyFee);
        }
    }



    @Override
    public void displayCustomerDetails() {
        this.applyMonthlyFee();
        String customerDetails = "Account Number: " + this.getAccountNumber() + "\n" + "Customer: " + this.getAccountCustomer().getName();
        IO.println(customerDetails);
    }


    @Override
    public String getCustomerType() {
        return CUSTOMER_TYPE;
    }
}
