package ch6ex12;

import java.math.*;
import java.util.*;

public class MortgageCalculator extends FinancialCalculator {
    // total mortgage amount (A)
    private BigDecimal mortgageAmount;

    // number of payments in a year (n)
    private int pymntsInYear;

    // annual interest rate (r - interest rate)
    private BigDecimal interestRateAnnual;

    // monthly interest rate (r / n = interestRateAnnual / pymntsInYear)
    private BigDecimal interestRateMonthly;

    // monthly interest payment amount
    private BigDecimal interestPymntMonthly;

    // total interest payment amount (interestPymntMonthly * pymntsInYear * T)
    private BigDecimal interestPymntTotal;

    // term of the mortgage in years (T)
    private int mortgageTerm;

    // starting month from which to calculate interest
    private int startMonth;

    // starting year from which to calculate interest
    private int startYear;

    // total number of monthly payments (n * T)
    private int totalNumOfPymnts;

    // constructs a GregorianCalendar object...
    public MortgageCalculator() {
        calendar = new GregorianCalendar();
        pymntsInYear = 12;
    }

    // get total number of monthly payments (n * T)
    private int calculateTotalNumOfPayments(int term) {
        // return ((pymntsInYear - monthsIn1stYear) + pymntsInYear * (term - 1));
        return pymntsInYear * term;
    }

    // get monthly interest rate (r / n)
    private BigDecimal calculateInterestRateMonthly(BigDecimal annualRate) {
        BigDecimal percent = new BigDecimal("100");
        BigDecimal numMonthsInYear = BigDecimal.valueOf(pymntsInYear);
        BigDecimal monthlyRate = annualRate.divide(percent).divide(numMonthsInYear, 6, RoundingMode.HALF_UP);
        return monthlyRate;
    }

    // get monthly interest payment amount
    private BigDecimal calculateInterestPymntMonthly(BigDecimal A, BigDecimal monthlyRate, int nT) {
        BigDecimal one = new BigDecimal("1");
        BigDecimal numerator = A.multiply(monthlyRate); // A * r/n
        BigDecimal denominator = one.divide(one.add(interestRateMonthly).pow(totalNumOfPymnts), 6,
                RoundingMode.HALF_UP);
        denominator = one.subtract(denominator.abs()); // 1 - [1/(1+r/n)^nT]
        return numerator.divide(denominator, 2, RoundingMode.HALF_UP);
    }

    // get total interest payment amount
    private BigDecimal calculateInterestPymntTotal(BigDecimal intPaidMonthly, int pymntAmt, int term) {
        return intPaidMonthly.multiply(BigDecimal.valueOf(pymntAmt)).multiply(BigDecimal.valueOf(term));
    }

    // prompts user to enter input...
    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your total mortgage amount (in dollars): ");
        mortgageAmount = new BigDecimal(scanner.next());

        System.out.print("Enter the interest rate (annual %): ");
        interestRateAnnual = new BigDecimal(scanner.next());

        System.out.print("Enter the term of the mortgage in years: ");
        mortgageTerm = scanner.nextInt();

        System.out.print("Enter the starting month and year [e.g. 1 2022 for January 2022]: ");
        startMonth = scanner.nextInt();
        startYear = scanner.nextInt();
    }

    // prints total interest paid on mortgage
    public void compute() {
        // initialize calendar
        calendar.set(startYear, startMonth - 1, 1);

        // get total number of monthly payments (n * T)
        totalNumOfPymnts = calculateTotalNumOfPayments(mortgageTerm);
        System.out.println(String.format("totalNumOfPymnts: %d", totalNumOfPymnts));

        // get monthly interest rate (r / n)
        interestRateMonthly = calculateInterestRateMonthly(interestRateAnnual);
        System.out.println("interestRateMonthly: " + interestRateMonthly + "%");

        // get monthly interest payment amount
        interestPymntMonthly = calculateInterestPymntMonthly(mortgageAmount,
                interestRateMonthly, totalNumOfPymnts);
        System.out.println("interestPymntMonthly: $" + interestPymntMonthly);

        // get total interest payment amount
        interestPymntTotal = calculateInterestPymntTotal(interestPymntMonthly, pymntsInYear, mortgageTerm);
        System.out.println("interestPymntTotal: $" + interestPymntTotal);

    }

    public static void main(String[] args) {
        FinancialCalculator mortgageCalc = new MortgageCalculator();
        mortgageCalc.getUserInput();
        mortgageCalc.compute();
    }
}

// hw2_ch6_p264_pdf269_ex12

// mortgageAmount * interestRateMonthly
// ________________________________________________ = interestPymntMonthly
// 1 - [1/(1+interestRateMonthly)^totalNumOfPymnts]
//
//
// A * r/n
// __________________ = monthly interest payment
// 1 - [1/(1+r/n)^nT]
//
// A - mortgage amount
// r - interest rate
// n - number of payments in a year
// T - term of the mortgage (in years)
