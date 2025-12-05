package com.amalitech.bankaccount.transaction;

import com.amalitech.bankaccount.enums.TransferToOrFromType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction{
    private int transactionCounter;
    private String transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private double balanceAfter;
    private String timestamp;
    private TransferToOrFromType transferToOrFrom;

    /**
     * No-arg constructor of Transaction class
     */
    public Transaction(){
        super();
    }

    /**
     * Transaction constructor for initializing instance variables
     * @param accNumber
     * @param amt
     * @param balAfter
     */
    public Transaction(String accNumber, double amt, double balAfter){
        this.accountNumber = accNumber;
        this.amount = amt;
        this.balanceAfter = balAfter;
        ++transactionCounter;
        generateTransactionId(transactionCounter);
        generateTimeStamp();
    }

    /**
     * For generating and assigning transaction id
     * @param counter
     */
    public void generateTransactionId(int counter){
        this.transactionId = "TXN00" + counter;
    }

    /**
     * For generating timestamp
     */
    private void generateTimeStamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        timestamp = now.format(formatter);
    }

    /**
     * For parsing string timestamp to LocalDateTime. This make it easy for comparator and comparable
     * @return LocalDateTime
     */
    public LocalDateTime parseTimeStamp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        return LocalDateTime.parse(timestamp, formatter);
    }


    /**
     *
     * @return Transaction ID
     */
    public String getTransactionId(){
        return transactionId;
    }

    /**
     *
     * @return Account Number
     */
    public String getAccountNumber(){
        return accountNumber;
    }

    /**
     *
     * @return Get the type of transaction (i.e Deposit or Withdrawal).
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return Return amount involve in a transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     *
     * @return Exact current balance of after the transaction
     */
    public double getBalanceAfter() {
        return balanceAfter;
    }

    /**
     *
     * @return Timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Flag for indicating whether a transfer was made to or from an account
     * @return <b><u>TransferToOrFromType</u></b> enum
     */
    public TransferToOrFromType getTransferToOrFrom(){
        return transferToOrFrom;
    }

    /**
     * For knowing the number of transaction made from a particular account
     * @return integer
     */
    public int getTransactionCounter(){
        return transactionCounter;
    }


    /**
     * For setting transaction type (i.e Deposit or Withdrawal)
     * @param type
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     * For setting transfer direction flag (i.e whether transfer was made from or to an account)
     * @param transferToOrFrom
     */
    public void setTransferToOrFrom(TransferToOrFromType transferToOrFrom){
        this.transferToOrFrom = transferToOrFrom;
    }

    /**
     * For updating the transaction counter for a particular account
     */
    public void increaseTransactionCounter(){
        this.transactionCounter++;
    }

    @Override
    public String toString(){
        return transactionId;
    }

}
