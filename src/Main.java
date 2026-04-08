import bankingsystem.app.BankingMenu;
import bankingsystem.model.BankAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Banking System ===");
        String accountNumber = readAccountNumber(scanner);

        BankAccount bankAccount = new BankAccount(accountNumber);
        BankingMenu bankingMenu = new BankingMenu(scanner, bankAccount);
        bankingMenu.start();

        scanner.close();
    }

    // Read account number and keep asking until input is valid.
    private static String readAccountNumber(Scanner scanner) {
        while (true) {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine().trim();

            if (!accountNumber.isEmpty()) {
                return accountNumber;
            }

            System.out.println("Account number cannot be empty.");
        }
    }
}
