package org.sid.datediff;

import java.time.LocalDate;
import java.time.Month;

public class Solution {

    public static int dateDiff(LocalDate date1, LocalDate date2) {

        if (date1.getYear() > date2.getYear() ||
                ( date1.getYear() == date2.getYear() && date1.getMonthValue() > date2.getMonthValue()) ||
                ( date1.getYear() == date2.getYear() && date1.getMonthValue() == date2.getMonthValue() &&
                        date1.getDayOfMonth() > date2.getDayOfMonth())) {
            return orderedDateDiff(date2, date1);
        }
            return orderedDateDiff(date1, date2);
    }

    private static int orderedDateDiff (LocalDate lower, LocalDate upper) {
        //Number of days in between years
        int daysInBetweenYears = upper.getYear() - lower.getYear();
        int numberOfLeaps = daysInBetweenYears / 4;
        if (lower.getYear() % 4 > upper.getYear() % 4) {
            numberOfLeaps++;
        }
        int yearDiffToDays = daysInBetweenYears * 365 + numberOfLeaps;

        int monthDiffToDays = 0;
        int currMonth = lower.getMonthValue();
        boolean lowerMonthIsGreater = lower.getMonthValue()  > upper.getMonthValue();
        while (currMonth != upper.getMonthValue()){
            monthDiffToDays += daysInMonth(currMonth);
            currMonth += lowerMonthIsGreater ? -1 : 1;
        }
        if ( lower.getMonthValue()  > upper.getMonthValue() ){
            monthDiffToDays *= -1;
        }

        int dayDiff = lower.getDayOfMonth() - upper.getDayOfMonth();
        if ( lower.getDayOfMonth() > upper.getDayOfMonth() ){
            dayDiff *=-1;
            if ( lower.getMonthValue() > upper.getMonthValue()) {
                dayDiff--;
            }
        }

        if (lower.getYear() % 4 == 0 && lower.getMonthValue() < 3 && ( lower.getYear() != upper.getYear() || upper.getMonthValue() > 2)) {
            yearDiffToDays++;
        }


        return yearDiffToDays + monthDiffToDays + dayDiff;
    }

    private static int daysInMonth(int month) {
        return Month.of(month).length(false);
    }
}
