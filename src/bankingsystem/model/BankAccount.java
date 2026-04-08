package bankingsystem.model;

public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        this.accountNumber = accountNumber.trim();
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Add money to the account.
    public boolean deposit(double amount) {
        if (!isValidAmount(amount)) {
            return false;
        }
        balance += amount;
        return true;
    }

    // Withdraw money if enough balance is available.
    public boolean withdraw(double amount) {
        if (!isValidAmount(amount) || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double checkBalance() {
        return balance;
    }

    private boolean isValidAmount(double amount) {
        return Double.isFinite(amount) && amount > 0.0;
    }
}
