package BonusTask;

public class BankAccountV1 {

    private double balance;

    public BankAccountV1(){
    }

    public BankAccountV1(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount){
        if (amount <= this.balance) {
            this.balance = this.balance - amount;
        } else {
            System.out.println("Not enough money.");
        }
    }

    public void printBalance(){
        System.out.println("Your current balance is : " + this.balance);
    }

    public void transfer(BankAccountV1 account, double amount){
        if (amount <= this.balance) {
            this.withdraw(amount);
            account.deposit(amount);
        } else {
            System.out.println("Not enough money.");
        }
    }
}
