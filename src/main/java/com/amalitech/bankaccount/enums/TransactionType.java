package com.amalitech.bankaccount.enums;

public enum TransactionType {
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal");

    private final String description;

    private TransactionType(String description) {this.description = description;}

    public String getDescription(){
        return this.description;
    }

}
