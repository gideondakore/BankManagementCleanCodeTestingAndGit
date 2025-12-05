package com.amalitech.bankaccount.enums;

public enum TransactionType {
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal"),
    TRANSFER ("Transfer");

    private final String description;

    TransactionType(String description) {this.description = description;}

    /**
     *
     * @return Transaction type enum string literal
     */
    public String getDescription(){
        return this.description;
    }

}
