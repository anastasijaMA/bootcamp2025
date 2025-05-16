package BonusTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankingAccountTest {
    private static final double EMPTY_BALANCE = 0.0;
    private static final double DEFAULT_DEPOSIT = 100.0;
    private static final double VALID_WITHDRAW = 50.0;
    private static final double EXCESS_WITHDRAW = 120.0;
    private static final double INVALID_DEPOSIT = -100.0;
    private static final double VALID_TRANSFER = 80.0;

    @Test
    @DisplayName("Should create bank account with provided name, with balance 0.0")
    void init() {
        BankingAccount ba = new BankingAccount("Nancy");
        Assertions.assertEquals("Nancy", ba.getName());
        Assertions.assertEquals(EMPTY_BALANCE, ba.getBalance());
    }

    @Test
    @DisplayName("Should increase balance by amount of money passed as argument")
    void deposit() {
        BankingAccount ba = new BankingAccount("TestUser1");
        ba.deposit(DEFAULT_DEPOSIT);
        Assertions.assertEquals(DEFAULT_DEPOSIT, ba.getBalance());
    }

    @Test
    @DisplayName("Should not change balance if amount of money passed is less than 0")
    void depositFail() {
        BankingAccount ba = new BankingAccount("TestUser2");
        ba.deposit(INVALID_DEPOSIT);
        Assertions.assertEquals(EMPTY_BALANCE, ba.getBalance());
    }

    @Test
    @DisplayName("Should decrease balance by amount of money passed as an argument")
    void withdraw() {
        BankingAccount ba = new BankingAccount("TestUser3");
        ba.deposit(DEFAULT_DEPOSIT);
        boolean staus = ba.withdraw(VALID_WITHDRAW);

        Assertions.assertTrue(staus);
        Assertions.assertEquals(VALID_WITHDRAW, ba.getBalance());
    }

    @Test
    @DisplayName("Should fail withdraw balance if amount of money exceeds balance")
    void withdrawFail() {
        BankingAccount ba = new BankingAccount("TestUser3");
        ba.deposit(DEFAULT_DEPOSIT);
        boolean staus = ba.withdraw(EXCESS_WITHDRAW);

        Assertions.assertFalse(staus);
        Assertions.assertEquals(DEFAULT_DEPOSIT, ba.getBalance());
    }

    @Test
    @DisplayName("Should not make transfer if amount of money exceeds balance")
    void transferFailBalance() {
        BankingAccount ba = new BankingAccount("TestUser3");
        BankingAccount ba2 = new BankingAccount("User4");
        ba.deposit(DEFAULT_DEPOSIT);
        boolean status = ba.transfer(ba2, EXCESS_WITHDRAW);
        Assertions.assertFalse(status);
        Assertions.assertEquals(DEFAULT_DEPOSIT, ba.getBalance());
        Assertions.assertEquals(EMPTY_BALANCE, ba2.getBalance());
    }


    @Test
    @DisplayName("Should make transfer")
    void transfer() {
        BankingAccount ba = new BankingAccount("TestUser3");
        BankingAccount ba2 = new BankingAccount("User4");
        ba.deposit(DEFAULT_DEPOSIT);
        boolean status = ba.transfer(ba2, VALID_TRANSFER);
        Assertions.assertTrue(status);
        Assertions.assertEquals(DEFAULT_DEPOSIT - VALID_TRANSFER, ba.getBalance());
        Assertions.assertEquals(VALID_TRANSFER, ba2.getBalance());
    }

    @Test
    @DisplayName("Should return string in 'Name - Balance: $amount' format")
    void testToString() {
        BankingAccount ba2 = new BankingAccount("User4");
        String str = ba2.toString();
        Assertions.assertEquals("User4 - Balance: $0.00", str);
    }
}