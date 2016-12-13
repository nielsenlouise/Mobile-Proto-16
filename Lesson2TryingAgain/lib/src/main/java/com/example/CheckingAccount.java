package com.example;

/**
 * Created by lnielsen on 9/9/16.
 */
public class CheckingAccount extends Account {

    public CheckingAccount(long amount){
        super(amount);
    }

    // overriding toString() method from Account class
    public String toString() {
        return "Checking Account Balance: $" + getAmount();
    }

    public void withdraw(int number) {
        setAmount(getAmount() - number);
    }

    public void deposit(int number) {
        setAmount(getAmount() + number);
    }
}
