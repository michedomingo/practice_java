package ch6ex12;

import java.math.*;
import java.util.*;

public class MortgageCalculator extends FinancialCalculator {
    // monthly mortgage payment (A - mortage amount)
    private BigDecimal mortgagePymnt;

    // annual interest rate (r - interest rate)
    private BigDecimal interestRateAnnual;

    // monthly interest rate (r/num pymnts in a year = interestRateAnnual/12 )
    private BigDecimal interestRateMonthly;

    // term of the mortgage in years (T)
    private int mortageTerm;

    // starting month from which to calculate interest
    private int startMonth;

    // starting year from which to calculate interest
    private int startYear;

    // constructs a GregorianCalendar object...
    public MortgageCalculator() {
        calendar = new GregorianCalendar();
    }

    // get monthly interest rate
    private BigDecimal calculateMonthlyInterestRate(BigDecimal annualRate) {
        BigDecimal numMonthsInYear = new BigDecimal("12"); // (n - number of payments in a year)
        BigDecimal monthlyRate = annualRate.divide(numMonthsInYear, 6, RoundingMode.HALF_UP); // (r/n)

        System.out.println("annualRate: " + annualRate + "%");
        System.out.println("monthlyRate: " + monthlyRate);

        return monthlyRate;
    }

    // prompts user to enter input...
    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your monthly mortgage payment (in dollars): ");
        mortgagePymnt = new BigDecimal(scanner.next());

        System.out.print("Enter the interest rate (annual %): ");
        interestRateAnnual = new BigDecimal(scanner.next());

        System.out.print("Enter the term of the mortgage in years: ");
        mortageTerm = scanner.nextInt();

        System.out.print("Enter the starting month and year [e.g. 1 2022 for January 2022]: ");
        startMonth = scanner.nextInt();
        startYear = scanner.nextInt();
    }

    // prints total interest paid on mortgage
    public void compute() {
        // initialize calendar
        calendar.set(startYear, startMonth - 1, 1);

        // get total number of payments made
        int pymntsInYear = 12; // (n - number of payments in a year)
        int totalNumOfPymnts = ((pymntsInYear - startMonth) + pymntsInYear * (mortageTerm - 1)); // (nT)
        System.out.println(String.format("totalNumOfPymnts: %d", totalNumOfPymnts));

        // get monthly interest rate
        interestRateMonthly = calculateMonthlyInterestRate(interestRateAnnual);
        System.out.println("interestRateAnnual: " + interestRateAnnual + "%");
        System.out.println("interestRateMonthly: " + interestRateMonthly + "%");

        // get amount of monthly interest paid
        BigDecimal interestPaid;

        // get total amount of interest paid
        BigDecimal totalInterestPaid;

    }

    public static void main(String[] args) {
        FinancialCalculator mortgageCalc = new MortgageCalculator();
        mortgageCalc.getUserInput();
        mortgageCalc.compute();
    }
}

// hw2_ch6_p264_pdf269_ex12

// A * r/n
// __________________ = monthly payment
// 1 - [1/(1+r/n)^nT]
//
//
// A * r/n
// __________________ = monthly payment
// 1 - [1/(1+r/n)^nT]
//
// A - mortage amount
// r - interest rate
// n - number of payments in a year
// T - term of the mortage (in years)