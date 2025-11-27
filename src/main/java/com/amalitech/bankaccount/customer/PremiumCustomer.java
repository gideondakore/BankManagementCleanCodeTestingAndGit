package com.amalitech.bankaccount.customer;

public class PremiumCustomer extends Customer{
    private double minimumBalance = 10000;
    static final String CUSTOMER_TYPE = "Premium";

    public PremiumCustomer(String name, int age, String contact, String address){
        super(name, age, contact, address);
        ++customerCounter;
        this.setCustomerId(customerCounter);
    }



    //Getters
    public double getMinimumBalance(){
        return minimumBalance;
    }
    //Setters
    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    private void setCustomerId(int id){
        String customerId = "ACC00" + id;
        this.setCustomerId(customerId);
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

    @Override
    public String getCustomerType(String customerId) {
        return CUSTOMER_TYPE;
    }

//    public abstract String getCustomerType(String customerId);
}
