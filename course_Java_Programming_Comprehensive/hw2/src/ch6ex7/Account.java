package ch6ex7;

import java.math.*;

public class Account {
    private int number;
    private String name;
    private BigDecimal balance;
    private BigDecimal interestRate;

    // constructs new Account with initialized values
    public Account() {
        this(1234567, "myAccount1", new BigDecimal("1000"), new BigDecimal("0.5"));
    }

    // constructs new Account with the specified arguments
    public Account(int num, String n, BigDecimal b, BigDecimal i) {
        number = num;
        name = n;
        balance = b;
        interestRate = i;
    }

    // method to display Account number
    public int getNumber() {
        return number;
    }

    // method to display Account name
    public String getName() {
        return name;
    }

    // method to display Account balance
    public BigDecimal getBalance() {
        balance = balance.setScale(2, RoundingMode.HALF_UP);
        return balance;
    }

    // method to display Account interest rate
    public BigDecimal getInterestRate() {
        interestRate = interestRate.setScale(2, RoundingMode.HALF_UP);
        return interestRate;
    }

    public static void main(String[] args) {
        Account testAccount1 = new Account();
        System.out.println("------- testAccount1 -------");
        System.out.println(String.format("number of Account: %d", testAccount1.getNumber()));
        System.out.println(String.format("name of Account: %s", testAccount1.getName()));
        System.out.println("balance on Account: " + testAccount1.getBalance());
        System.out.println("interestRate on Account: " + testAccount1.getInterestRate());
        System.out.println();
        System.out.println("------- testAccount2 -------");
        Account testAccount2 = new Account(9876543, "myAccount2", new BigDecimal("500"), new BigDecimal("0.25"));
        System.out.println(String.format("number of Account: %d", testAccount2.getNumber()));
        System.out.println(String.format("name of Account: %s", testAccount2.getName()));
        System.out.println("balance on Account: " + testAccount2.getBalance());
        System.out.println("interestRate on Account: " + testAccount2.getInterestRate());
    }
}

// hw2_ch6_p262_pdf267_ex7
