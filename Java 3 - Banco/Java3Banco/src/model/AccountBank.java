package model;

import helper.Utils;
import jdk.jshell.execution.Util;

public class AccountBank {
    private static int code = 1001;

    private int number;
    private Client client;
    private Double balance = 0.0;
    private Double limit = 0.0;
    private Double totalBalance;

    public AccountBank(Client client) {
        this.number = client.getCode();
        this.client = client;

        AccountBank.code++;
        this.updateTotalBalance();
    }


    public int getNumber() {
        return number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    @Override
    public String toString() {
       return "Account Number: " + this.getNumber() + "\n" +
               "Name: " + this.getClient().getName() + "\n" +
               "Total balance: " + Utils.doubleToString(this.getTotalBalance());
    }
    private void updateTotalBalance() {
        this.totalBalance = this.getBalance() + this.limit;
    }
    public void deposit(Double amount){
        if (amount <= 0) {
            System.out.println("Error when trying to deposit amount. Try again");
            return;
        }
        this.balance = this.getBalance() + amount;
        this.updateTotalBalance();
        System.out.println("Deposit completed successfully");
    }
    public void withdraw(Double amount){
        if (amount <= 0) {
            System.out.println("Error when trying to withdraw amount. Try again");
            return;
        } else if (amount > this.getTotalBalance()) {
            System.out.println("Error when trying to withdraw amount. Amount is bigger than limit");
            return;
        }

        if(amount <= this.getBalance()){
            this.balance -= amount;
        } else {
            this.limit -= amount - this.getBalance();
            this.balance = 0.0;
        }
        this.updateTotalBalance();
        System.out.println("Withdraw completed successfully");
    }

    public void transfer(AccountBank destinationAcc, Double amount){
        if (amount <= 0) {
            System.out.println("Error when trying to withdraw amount. Try again");
            return;
        } else if (amount > this.getTotalBalance()) {
            System.out.println("Error when trying to withdraw amount. Amount is bigger than limit");
            return;
        }

        if(amount <= this.getBalance()){
            this.balance -= amount;
        } else {
            this.limit -= amount - this.getBalance();
            this.balance = 0.0;
        }
        destinationAcc.balance += amount;
        destinationAcc.updateTotalBalance();
        this.updateTotalBalance();
        System.out.println("Deposit completed successfully");
    }
}
