package BonusTask;

public class BankActivityV1 {

    public static void main(String[] args) {
        BankAccountV1 account_1 = new BankAccountV1();
        BankAccountV1 account_2 = new BankAccountV1(10);
        account_1.deposit(5);
        account_1.transfer(account_2,2);
        account_1.printBalance();
        account_2.printBalance();

    }

}
