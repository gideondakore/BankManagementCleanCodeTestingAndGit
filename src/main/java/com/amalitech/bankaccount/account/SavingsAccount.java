package com.amalitech.bankaccount.account;

import com.amalitech.bankaccount.customer.Customer;
import com.amalitech.bankaccount.enums.CustomerType;

public class SavingsAccount extends Account{
    static final String CUSTOMER_TYPE = CustomerType.SAVINGS.getDescription();
    private double interestRate;
    private double minimumBalance;


    public SavingsAccount(Customer customer){
        super(customer);
        this.interestRate = 0.035;
        this.minimumBalance = 500;

    }

    public double calculateInterest(){
        return this.getAccountBalance() * interestRate;
    }

    @Override
    public double withdrawal(double amount) throws IllegalArgumentException{
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }


        if((this.getAccountBalance() - amount) < 0 || (this.getAccountBalance() - amount) < minimumBalance){
            throw new IllegalArgumentException("You have insufficient amount.");
        }

        super.withdrawal(amount);

        return this.getAccountBalance();
    }

    @Override
    public void displayCustomerDetails() {
        String customerDetails = "Account Number: " + this.getAccountNumber() + "\n" + "Customer: " + this.getAccountCustomer().getName();
        IO.println(customerDetails);
    }


    @Override
    public String getCustomerType(String customerId) {
        return CUSTOMER_TYPE;
    }


}
