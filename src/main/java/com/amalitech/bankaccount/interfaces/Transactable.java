package com.amalitech.bankaccount.interfaces;

public interface Transactable {

    /**
     * For checking whether transaction was successfully or not
     * @param amount
     * @param type
     * @return Boolean true indicating success or false for transaction failure
     */
    boolean processTransaction(double amount, String type);
}
