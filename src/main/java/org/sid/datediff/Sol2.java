package org.sid.datediff;

import java.time.LocalDate;
import java.time.Month;

public class Sol2 {
    public static int dateDiff(LocalDate date1, LocalDate date2) {
        if (date1.getYear() > date2.getYear() ||
                (date1.getYear() == date2.getYear() && date1.getMonthValue() > date2.getMonthValue()) ||
                (date1.getYear() == date2.getYear() && date1.getMonthValue() == date2.getMonthValue() &&
                        date1.getDayOfMonth() > date2.getDayOfMonth())
        ) {
            return orderedDateDifference(date2, date1);
        }
        return orderedDateDifference(date1, date2);
    }

    private static int orderedDateDifference(LocalDate lower, LocalDate higher) {

        int dateDiff = (higher.getYear() - lower.getYear()) * 365;
        dateDiff += (higher.getYear() - lower.getYear()) / 4;
        if (lower.getYear() % 4 > higher.getYear() % 4) {
            dateDiff++;
        }

        if ( lower.getMonthValue() <= higher.getMonthValue()) {
            for ( int i=lower.getMonthValue();i< higher.getMonthValue();i++) {
                dateDiff += daysInMonth(i);
            }
        }else {
            for ( int i=lower.getMonthValue();i> higher.getMonthValue();i--) {
                dateDiff -= daysInMonth(i);
            }
        }
        int dayDiff = lower.getDayOfMonth() - higher.getDayOfMonth();
        if ( lower.getDayOfMonth() > higher.getDayOfMonth() ){
            dayDiff *=-1;
            if ( lower.getMonthValue() > higher.getMonthValue()) {
                dayDiff--;
            }
        }
        dateDiff += dayDiff;

        if ( lower.getYear() %4 == 0 && lower.getMonthValue() < 3 &&
                (higher.getYear() > lower.getYear() || higher.getMonthValue() > 2)) {
            dateDiff++;
        }

        return dateDiff;
    }
    private static int daysInMonth(int month) {
        return Month.of(month).length(false);
    }
}
