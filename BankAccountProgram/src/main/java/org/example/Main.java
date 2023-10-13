package org.example;

import java.util.Scanner;

public class Main {
    static BankSystem bankSystem = new BankSystem();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentAccount = 0;
        System.out.println("Create an account: ");
        bankSystem.createAccount();
        System.out.println("Account number: " + bankSystem.accounts.get(currentAccount).getAccountNumber());

        while (true) {
            System.out.println();
            System.out.println("""
                    Select an action. Press 1-5
                    1. Create a new account
                    2. Add money
                    3. Withdraw money
                    4. Transfer money
                    5. View balance
                    6. Information about account
                    7. Quit
                    Enter your choice:\s""");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    currentAccount++;
                    bankSystem.createAccount();
                    System.out.println("Account number: " + bankSystem.accounts.get(currentAccount).getAccountNumber());
                }
                case 2 -> {
                    bankSystem.whatAccount();
                    System.out.println("Enter amount of money: ");
                    bankSystem.accounts.get(bankSystem.getSelectedAccount()).addingMoney(scanner.nextInt());
                }
                case 3 -> {
                    bankSystem.whatAccount();
                    System.out.println("Enter amount of money: ");
                    bankSystem.accounts.get(bankSystem.getSelectedAccount()).withdrawal(scanner.nextInt());
                }
                case 4 -> bankSystem.transfer();
                case 5 -> {
                    bankSystem.whatAccount();
                    System.out.println("Current balance: " + bankSystem.accounts.get(bankSystem.getSelectedAccount()).getBalance());
                }
                case 6 -> {
                    bankSystem.whatAccount();
                    bankSystem.accounts.get(bankSystem.getSelectedAccount()).infoAboutAccount();
                }
                case 7 -> System.exit(0);
            }
        }
    }
}