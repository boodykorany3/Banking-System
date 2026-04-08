# Banking System - Level 2, Task 3

A clean Java OOP console project that simulates basic banking operations.

## Objective
Build a `BankAccount` system with:
- `accountNumber`
- `balance`
- Deposit operation
- Withdraw operation
- Balance check operation
- Input validation and edge-case handling

## What We Implemented
This task was built as a separate project with a clear OOP structure:

- `BankAccount` class for core account data and business rules
- `BankingMenu` class for menu-based user interaction
- `Main` class as the application entry point

## OOP Design
### 1) BankAccount (`model`)
Responsible for account state and operations:
- Stores `accountNumber` and `balance`
- `deposit(amount)` adds funds after validation
- `withdraw(amount)` removes funds only if valid and available
- `checkBalance()` returns current balance

### 2) BankingMenu (`app`)
Responsible for console interaction:
- Displays a looped menu
- Reads and validates user choices
- Calls account methods for deposit, withdrawal, and balance check
- Shows clear feedback messages

### 3) Main
Responsible for startup flow:
- Reads account number from the user
- Creates `BankAccount`
- Starts the menu system

## Validation and Edge Cases
The system prevents common errors:
- Rejects empty account number
- Rejects non-numeric menu input
- Rejects invalid amounts (negative, zero, non-number)
- Prevents withdrawing more than the current balance

## Project Structure
```text
src/
  Main.java
  bankingsystem/
    app/
      BankingMenu.java
    model/
      BankAccount.java
```

## How to Run
### IntelliJ IDEA
1. Open the project.
2. Run `Main`.

### Command Line
```bash
javac -d out src/Main.java src/bankingsystem/app/BankingMenu.java src/bankingsystem/model/BankAccount.java
java -cp out Main
```

## Sample Flow
1. Enter account number
2. Select `Deposit` and add money
3. Select `Withdraw` and enter amount
4. Select `Check Balance`
5. Select `Exit`

## Notes
- Code includes simple comments for clarity.
- The program runs without compilation/runtime errors.
