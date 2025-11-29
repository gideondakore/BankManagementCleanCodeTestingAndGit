package com.amalitech.bankaccount.enums;

public enum AccountType {

    SAVINGS("Savings"),
    CHECKING("Checking");

    private final String description;

    AccountType(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
