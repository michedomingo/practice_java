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
        savingsBalance = savingsBalance.add(amount);
    }

    // method returns false if no withdraw, otherwise withdraw amount
    public boolean withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }
        savingsBalance = savingsBalance.subtract(amount);
        return true;
    }

    // method to calculate monthly interest
    public BigDecimal computeInterest() {
        BigDecimal monthsToGrow = new BigDecimal("12");
        // monthlyInterest = (balance * interestRate) / 12
        return savingsBalance.multiply(interestRate).divide(monthsToGrow, 2, RoundingMode.HALF_UP);
    }

    // method to determine interest on a given balance at end of a year
    public void printTotalInterest(BigDecimal addAmount, BigDecimal minusAmount) {
        int totalMonths = 12;
        BigDecimal monthlyInterest = new BigDecimal("0");
        BigDecimal totalInterest = new BigDecimal("0");

        while (totalMonths > 0) {
            System.out.print(String.format("\n*** Month %d ***\n", totalMonths));
            System.out.println("current balance: " + savingsBalance);
            deposit(addAmount);
            withdraw(minusAmount);
            monthlyInterest = computeInterest();
            deposit(monthlyInterest);
            totalInterest = totalInterest.add(monthlyInterest);
            totalMonths--;
        }
        System.out.println("\n\nEnd of year balance: $" + savingsBalance);
        System.out.println("Total interest earned: $" + totalInterest);
    }

    // create 2 SavingAccount instances
    public static void main(String[] args) {
        SavingsAccount saveAccount1 = new SavingsAccount();
        System.out.println("------- Savings Account #1 -------\n");
        System.out.println(
                String.format("        start date: %02d/%02d/%d", saveAccount1.day, saveAccount1.month,
                        saveAccount1.year));
        System.out.println(" beginning balance: $" + saveAccount1.balance);
        System.out.println("   monthly deposit: $0.00");
        System.out.println("monthly withdrawal: $0.00");
        saveAccount1.printTotalInterest(new BigDecimal("0"), new BigDecimal("0"));
        System.out.println();
        SavingsAccount saveAccount2 = new SavingsAccount(7654321, "saveAccount2", new BigDecimal("5000"),
                new BigDecimal("0.005"), 01, 01, 2024);
        System.out.println("------- Savings Account #2 -------\n");
        System.out.println(
                String.format("        start date: %02d/%02d/%d", saveAccount2.day, saveAccount2.month,
                        saveAccount2.year));
        System.out.println(" beginning balance: $" + saveAccount2.balance);
        System.out.println("   monthly deposit: $500.00");
        System.out.println("monthly withdrawal: $75.00");
        saveAccount2.printTotalInterest(new BigDecimal("500"), new BigDecimal("75"));
    }
}

// hw2_ch6_p262_pdf267_ex7
