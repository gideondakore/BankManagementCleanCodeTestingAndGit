package com.amalitech.bankaccount.customer;

import com.amalitech.bankaccount.enums.CustomerType;

public class PremiumCustomer extends Customer{
    private double minimumBalance = 10000;
    static final String CUSTOMER_TYPE = CustomerType.PREMIUM.getDescription();

    public PremiumCustomer(String name, int age, String contact, String address){
        super(name, age, contact, address);
        this.setType(CustomerType.PREMIUM);
    }

    //Getters
    public double getMinimumBalance(){
        return minimumBalance;
    }
    //Setters
    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    //Other Methods
    public boolean hasWaivedFees(){
        return true;
    }

    @Override
    public void displayCustomerDetails() {
        String customerDetails = "Account Number: " + this.getCustomerId() + "\n" + "Customer: " + this.getName() + " (" + CUSTOMER_TYPE + ")";
        IO.println(customerDetails);
    }

}
