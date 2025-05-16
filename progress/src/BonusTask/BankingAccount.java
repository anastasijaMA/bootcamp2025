package BonusTask;

public class BankingAccount {
    private final String name;
    private double balance;

    public BankingAccount(String name) {
        this.name = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
           System.out.println("Deposit amount must be positive");
           return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }
        if (amount > balance) {
            System.out.println("Not Enough Funds");
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean transfer(BankingAccount target, double amount) {
        if (target == null) {
            System.out.println("Target account cannot be null");
        }
        if (withdraw(amount)) {
            target.deposit(amount);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return name + " - Balance: $" + String.format("%.2f", balance);
    }
}