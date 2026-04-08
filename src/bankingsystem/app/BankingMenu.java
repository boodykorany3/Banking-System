package bankingsystem.app;

import bankingsystem.model.BankAccount;

import java.util.Scanner;

public class BankingMenu {
    private final Scanner scanner;
    private final BankAccount bankAccount;

    public BankingMenu(Scanner scanner, BankAccount bankAccount) {
        this.scanner = scanner;
        this.bankAccount = bankAccount;
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1 -> handleDeposit();
                case 2 -> handleWithdraw();
                case 3 -> displayBalance();
                case 4 -> {
                    System.out.println("Exiting system. Goodbye.");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Check Balance");
        System.out.println("4) Exit");
    }

    // Read menu input and validate that it is between 1 and 4.
    private int readMenuChoice() {
        while (true) {
            System.out.print("Choose an option (1-4): ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Invalid option. Enter a number from 1 to 4.");
        }
    }

    private void handleDeposit() {
        double amount = readAmount("deposit");
        boolean success = bankAccount.deposit(amount);

        if (success) {
            System.out.printf("Deposit successful. New balance: %.2f%n", bankAccount.checkBalance());
        } else {
            System.out.println("Deposit failed. Amount must be a positive number.");
        }
    }

    private void handleWithdraw() {
        double amount = readAmount("withdraw");

        if (amount > bankAccount.checkBalance()) {
            System.out.printf("Withdrawal failed. Amount exceeds balance (%.2f).%n", bankAccount.checkBalance());
            return;
        }

        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.printf("Withdrawal successful. New balance: %.2f%n", bankAccount.checkBalance());
        } else {
            System.out.println("Withdrawal failed. Amount must be a positive number.");
        }
    }

    private void displayBalance() {
        System.out.printf("Current balance: %.2f%n", bankAccount.checkBalance());
    }

    // Read amount and validate that it is a positive number.
    private double readAmount(String operationName) {
        while (true) {
            System.out.print("Enter amount to " + operationName + ": ");
            String input = scanner.nextLine().trim().replace(',', '.');

            try {
                double amount = Double.parseDouble(input);
                if (amount > 0.0 && Double.isFinite(amount)) {
                    return amount;
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Invalid amount. Enter a positive number.");
        }
    }
}
