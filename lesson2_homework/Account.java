package com.example;

/**
 * Created by lnielsen on 9/8/16.
 */
public class Account {

    // Right way to name setters and getters!
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    private long amount;

    public Account(long amount){
        this.amount = amount;
    }

    public String toString() {
        return "Account Balance: $" + amount;
    }

    public static Account largerAccount(Account acc1, Account acc2) {
        if (acc1.amount > acc2.amount)
            return acc1;
        else
            return acc2;
    }

}
