package com.amalitech.bankaccount.enums;

public enum CustomerType {
    REGULAR("Regular"),
    PREMIUM("Premium");


    private final String description;

    CustomerType(String description){
        this.description = description;
    }

    /**
     *
     * @return Customer type enum string literal
     */
    public String getDescription(){
        return this.description;
    }

}
