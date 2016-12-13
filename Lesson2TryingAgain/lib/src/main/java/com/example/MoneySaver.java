package com.example;

/**
 * Created by lnielsen on 9/8/16.
 */
public class MoneySaver {

    private long myMoney;
    private Account myAccount;
    private String name;


    public MoneySaver(String name, long money) {
        this.name = name;
        myMoney = money;
    }

    public String getName() {
        return name;
    }

    public Account getMyAccount() {
        return myAccount;
    }

    public String toString() {
        return name + ", " + "My balance is: "+ myMoney;
    }

    public void deposit(int amount) {
        ((CheckingAccount) myAccount).deposit(amount);
        myMoney -= amount;
    }

    public void withdraw(int amount) {
        ((CheckingAccount) myAccount).withdraw(amount);
        myMoney += amount;
    }

    public void signUpForChecking(int amount) {
        myAccount = new CheckingAccount(amount);
        myMoney -= amount;
    }

}

