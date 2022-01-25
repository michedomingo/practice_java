package ch6ex7;

import java.math.*;

public class SavingsAccount extends Account {
    private int day;
    private int month;
    private int year;
    private BigDecimal savingsBalance = balance;

    // constructor new SavingsAccount with initialized values
    public SavingsAccount() {
        day = 01;
        month = 01;
        year = 2022;
    }

    // constructs new SavingsAccount with the specified arguments
    public SavingsAccount(int num, String n, BigDecimal b, BigDecimal i, int dd, int mm, int yyyy) {
        super(num, n, b, i);
        day = dd;
        month = mm;
        year = yyyy;
    }

    // method to deposit specified amount in savings account
    public void deposit(BigDecimal amount) {
        System.out.println("(inside deposit method) current balance: " + savingsBalance);
        System.out.println("deposit on SavingsAccount: " + amount);

        savingsBalance = savingsBalance.add(amount);
        System.out.println("balance after deposit: " + savingsBalance);
    }

    // method returns false if no withdraw, otherwise withdraw amount
    public boolean withdraw(BigDecimal amount) {
        System.out.println("(inside withdraw method) current balance: " + savingsBalance);
        System.out.println("withdraw on SavingsAccount: " + amount);

        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("Zero withdrawal from savings, balance remains: " + savingsBalance);
            return false;
        }

        savingsBalance = savingsBalance.subtract(amount);
        System.out.println("balance after withdraw: " + savingsBalance);
        return true;
    }

    // method to calculate monthly interest
    // monthlyInterest = (balance * interestRate) / 12
    public BigDecimal computeInterest() {
        BigDecimal monthsToGrow = new BigDecimal("12");
        BigDecimal monthlyInterest = savingsBalance.multiply(interestRate).divide(monthsToGrow);
        return monthlyInterest.setScale(2, RoundingMode.HALF_UP);
    }

    // create 2 SavingAccount instances
    // determine interest on a given balance at end of a year
    public static void main(String[] args) {

        SavingsAccount saveAccount1 = new SavingsAccount();
        System.out.println("------- saveAccount1 -------");
        System.out.println();
        System.out.println("balance inherited from account: " + saveAccount1.balance);

        System.out.println(
                String.format("day: %d, month: %d, year: %d", saveAccount1.day,
                        saveAccount1.month, saveAccount1.year));
        System.out.println();
        saveAccount1.deposit(new BigDecimal("5000"));
        System.out.println();
        saveAccount1.withdraw(new BigDecimal("250"));
        System.out.println("computeInterest: $" + saveAccount1.computeInterest());

        System.out.println();

        SavingsAccount saveAccount2 = new SavingsAccount(7654321, "saveAccount2", new BigDecimal("5000"),
                new BigDecimal("0.0006"), 01, 01, 2024);
        System.out.println("------- saveAccount2 -------");
        System.out.println();
        System.out.println("balance inherited from account: " +
                saveAccount2.balance);

        System.out.println(
                String.format("day: %d, month: %d, year: %d", saveAccount2.day,
                        saveAccount2.month, saveAccount2.year));
        System.out.println();
        saveAccount2.deposit(new BigDecimal("5000"));
        System.out.println();
        saveAccount2.withdraw(new BigDecimal("0"));
        System.out.println("computeInterest: $" + saveAccount2.computeInterest());
    }
}

// hw2_ch6_p262_pdf267_ex7
