package com.amalitech.bankaccount.account;

import com.amalitech.bankaccount.customer.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class AccountManager {
    private ArrayList<Account> account = new ArrayList<>(50);
    private int accountCount;

    public AccountManager(){
        this.accountCount = 0;
    }

    public AccountManager(Account account){
        this.account.add(account);
        this.accountCount = this.account.size();
    }

    public AccountManager(Account[] accArr){
        Collections.addAll(account, accArr);
        this.accountCount = this.account.size();
    }

    public void addAccount(Account acc){
        this.account.add(acc);
        this.accountCount++;
    }

    public Account findAccount(String accNumber){
        for(Account acc: this.account){
            if(acc.getAccountNumber().equals(accNumber)) return acc;
        }

        return null;
    }

    public void viewAllAccounts(){
        if(this.account.isEmpty()){
            IO.println("""
                    -------------------------------------------
                    No account account created yet.
                    -------------------------------------------
                    """);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        String heading = """
                %s            |
                %s            |
                %s            |
                %s            |
                %s            |
                """.formatted("ACC N0", "CUSTOMER NAME", "TYPE", "BALANCE", "STATUS");

        stringBuilder.append(heading);

        for(Account acc: this.account){
            Customer customer = acc.getAccountCustomer();
            String str = """
                    %s            |
                    %s            |
                    %s            |
                    %s            |
                    %s
                    """.formatted(acc.getAccountNumber(), customer.getName(), customer.getCustomerType(), acc.getAccountBalance(), acc.getAccountStatus());

            stringBuilder.append(str).append("\n");
        }

        IO.println(stringBuilder.toString());
    }

    public double getTotalBalance(){
        double tempTotal = 0.0;

        for(Account acc: account){
            tempTotal += acc.getAccountBalance();
        }

        return tempTotal;

    }

    public int getAccountCount() {
        return accountCount;
    }
}
