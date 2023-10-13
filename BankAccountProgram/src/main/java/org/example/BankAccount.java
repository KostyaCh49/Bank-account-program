package org.example;

public class BankAccount {
    private final String ownerName;
    private final int accountNumber;
    private double balance;

    public BankAccount(String ownerName, int accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void addingMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully. Balance: " + balance);
        } else {
            System.out.println("You need to add more money than zero.");
        }
    }

    public void withdrawal(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Successfully. Balance: " + balance);
        } else if (balance < amount) {
            System.out.println("Not enough money. Balance: " + balance);
        } else {
            System.out.println("You need to withdrawal more than zero.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void infoAboutAccount() {
        System.out.println("Owner's name: " + ownerName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Current balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
