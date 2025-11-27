package com.amalitech.bankaccount.customer;


public class RegularCustomer extends Customer{
    static final String CUSTOMER_TYPE;

    static {
        CUSTOMER_TYPE = "Regular";
    }

    public RegularCustomer(String name, int age, String contact, String address){
        super(name, age, contact, address);
        ++customerCounter;
        this.setCustomerId(customerCounter);
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
        String customerDetails = "Account Number: " + this.getCustomerId() + "\n" + "Customer: " + this.getName()  + " (" + CUSTOMER_TYPE + ")";
        IO.println(customerDetails);
    }

    @Override
    public String getCustomerType(String customerId) {
        return CUSTOMER_TYPE;
    }

}