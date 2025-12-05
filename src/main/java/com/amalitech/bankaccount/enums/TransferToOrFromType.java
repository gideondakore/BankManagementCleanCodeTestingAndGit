package com.amalitech.bankaccount.enums;

public enum TransferToOrFromType {
    TO("To"),
    FROM("From");

    private final String description;

    TransferToOrFromType(String description) {this.description = description;}

    /**
     *
     * @return Transaction type flags for recording transaction from or to account enum string literal
     */
    public String getDescription(){
        return this.description;
    }
}
