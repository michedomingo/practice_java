package ch6ex7;

import java.math.*;

public class Account {
    protected int number;
    protected String name;
    protected BigDecimal balance;
    protected BigDecimal interestRate;

    // constructs new Account with initialized values
    public Account() {
        number = 1234567;
        name = "myAccount1";
        balance = new BigDecimal("1000");
        interestRate = new BigDecimal("0.0006");
    }

    // constructs new Account with the specified arguments
    public Account(int num, String n, BigDecimal b, BigDecimal i) {
        number = num;
        name = n;
        balance = b;
        interestRate = i;
    }

    // method to display Account number
    public void printNumber() {
        System.out.println(String.format("number of Account: %d", number));
    }

    // method to display Account name
    public void printName() {
        System.out.println(String.format("name of Account: %s", name));
    }

    // method to display Account balance
    public void printBalance() {
        balance = balance.setScale(2, RoundingMode.HALF_UP);
        System.out.println("balance on Account: " + balance);
    }

    // method to display Account interest rate
    public void printInterestRate() {
        interestRate = interestRate.setScale(4, RoundingMode.HALF_UP);
        System.out.println("interestRate on Account: " + interestRate);
    }

    public static void main(String[] args) {
        Account testAccount1 = new Account();
        System.out.println("------- testAccount1 -------");
        testAccount1.printNumber();
        testAccount1.printName();
        testAccount1.printBalance();
        testAccount1.printInterestRate();

        System.out.println();
        System.out.println("------- testAccount2 -------");
        Account testAccount2 = new Account(9876543, "myAccount2", new BigDecimal("500"), new BigDecimal("0.0006"));
        testAccount2.printNumber();
        testAccount2.printName();
        testAccount2.printBalance();
        testAccount2.printInterestRate();
    }
}

// hw2_ch6_p262_pdf267_ex7
