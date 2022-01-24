package ch6ex7;

import java.math.*;

public class SavingsAccount extends Account {
    private int day;
    private int month;
    private int year;
    private BigDecimal savingsBalance;

    // constructor 1
    public SavingsAccount() {
        this(01, 01, 2022);
        savingsBalance = getBalance();
    }

    // constructor 2
    public SavingsAccount(int dd, int mm, int yyyy) {
        day = dd;
        month = mm;
        year = yyyy;
    }

    public void deposit(BigDecimal amount) {
        // BigDecimal savingsBalance = getBalance();
        System.out.println("(inside deposit method) balance inherited from class Account: " + savingsBalance);
        System.out.println("deposit on SavingsAccount: " + amount);

        savingsBalance = savingsBalance.add(amount);
        System.out.println("balance after deposit: " + savingsBalance);
    }

    public boolean withdraw(BigDecimal amount) {
        System.out.println("(inside withdraw method) balance inherited from class Account: " + savingsBalance);
        System.out.println("withdraw on SavingsAccount: " + amount);

        savingsBalance = savingsBalance.subtract(amount);
        System.out.println("balance after withdraw: " + savingsBalance);

        return true;
    }

    // method to calculate monthly interest
    // monthlyInterest = (balance * interestRate) / 12
    public BigDecimal computeInterest();

    // create 2 SavingAccount instances
    // determine interest on a given balance at end of a year
    public static void main(String[] args) {
        SavingsAccount saveAccount1 = new SavingsAccount();

        System.out.println(
                String.format("day: %d, month: %d, year: %d", saveAccount1.day, saveAccount1.month, saveAccount1.year));
        System.out.println();

        saveAccount1.deposit(new BigDecimal("5000"));

        System.out.println();
        saveAccount1.withdraw(new BigDecimal("250"));

        // saveAccount1.computeInterest();
        // System.out.println("balance inherited from class Account: " +
        // saveAccount1.getBalance());

        // System.out.println(saveAccount1.getNumber());
        // System.out.println(saveAccount1.getName());
        // System.out.println(saveAccount1.getBalance());
        // System.out.println(saveAccount1.getInterestRate());
    }
}

// hw2_ch6_p262_pdf267_ex7