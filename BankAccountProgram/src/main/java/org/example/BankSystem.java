package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankSystem {
    ArrayList<BankAccount> accounts = new ArrayList<>();
    private int selectedAccount = 0;

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter name: ");
        String name = scanner.next();

        System.out.println("Enter starting balance: ");
        double startingBalance = scanner.nextInt();

        BankAccount newBankAccount = new BankAccount(name, random.nextInt(100000000, 999999999), startingBalance);
        accounts.add(newBankAccount);
        System.out.println("Successfully.\n");
    }

    public void whatAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number: ");
        while (true) {
            int number = scanner.nextInt();

            boolean examination = false;
            for (int i = 0; i < accounts.size(); i++) {
                if (number == accounts.get(i).getAccountNumber()) {
                    selectedAccount = i;
                    examination = true;
                    break;
                }
            }
            if (!examination) {
                System.out.println("Enter existing number");
            } else {
                break;
            }
        }
    }

    public void transfer() {
        if (accounts.size() >= 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the account from which you want to transfer money");
            whatAccount();
            int fromWhich = selectedAccount;

            System.out.println("\nOn which account do you want to transfer money");
            whatAccount();
            int inWhich = selectedAccount;

            System.out.println("Enter amount of money: ");
            int amountOfMoney = scanner.nextInt();
            if (amountOfMoney <= 0) {
                System.out.println("You need to enter more money than zero.");
            } else {
                System.out.println("Successfully.");
                accounts.get(fromWhich).setBalance(accounts.get(fromWhich).getBalance() - amountOfMoney);
                accounts.get(inWhich).setBalance(accounts.get(inWhich).getBalance() + amountOfMoney);
            }
        } else {
            System.out.println("Can't transfer money. Create more accounts.");
        }
    }

    public int getSelectedAccount() {
        return selectedAccount;
    }
}
