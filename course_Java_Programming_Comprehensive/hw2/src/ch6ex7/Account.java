package ch6ex7;

import java.math.*;

public class Account {
    private int number;
    private String name;
    private BigDecimal balance;
    private BigDecimal interestRate;

    // constructs new Account with initialized values
    public Account() {
        this(1234567, "myAccount", new BigDecimal("1000"), new BigDecimal("0.5"));
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
        // System.out.println(String.format("number of Account: %d", number));
        return number;
    }

    // method to display Account name
    public String getName() {
        // System.out.println(String.format("name of Account: %s", name));
        return name;
    }

    // method to display Account balance
    public BigDecimal getBalance() {
        balance = balance.setScale(2, RoundingMode.HALF_UP);
        // System.out.println("balance on Account: " + balance.toString());
        return balance;
    }

    // method to display Account interest rate
    public BigDecimal getInterestRate() {
        interestRate = interestRate.setScale(2, RoundingMode.HALF_UP);
        // System.out.println("interestRate on Account: " + interestRate.toString());
        return interestRate;
    }

    public static void main(String[] args) {
        Account testAccount = new Account();
        System.out.println(testAccount.getNumber());
        System.out.println(testAccount.getName());
        System.out.println(testAccount.getBalance());
        System.out.println(testAccount.getInterestRate());
        Account testAccount2 = new Account(987654321, "myAccount2", new BigDecimal("500"), new BigDecimal("0.25"));
        System.out.println(testAccount2.getNumber());
        System.out.println(testAccount2.getName());
        System.out.println(testAccount2.getBalance());
        System.out.println(testAccount2.getInterestRate());
    }
}

// hw2_ch6_p262_pdf267_ex7
