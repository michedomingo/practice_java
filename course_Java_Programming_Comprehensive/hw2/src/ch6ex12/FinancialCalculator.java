package ch6ex12;

import java.util.*;

public abstract class FinancialCalculator {
    // calendar
    protected Calendar calendar;

    // returns number of days for current month set on calendar
    protected int getDaysInMonth() {
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    // returns number of days in current year set on calendar
    protected int getDaysInYear() {
        return calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    protected abstract void getUserInput();

    protected abstract void compute();
}

// hw2_ch6_p264_pdf269_ex12
