package org.sid.datediff;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void testDates() {
        assertDates(LocalDate.of(2000, 01, 02), LocalDate.of(2000, 01, 02));
        assertDates(LocalDate.of(2000, 01, 02), LocalDate.of(2023, 01, 02));
        assertDates(LocalDate.of(2000, 01, 02), LocalDate.of(2024, 12, 02));
        assertDates(LocalDate.of(2000, 01, 02), LocalDate.of(2024, 12, 02));
        assertDates(LocalDate.of(2000, 01, 23), LocalDate.of(2024, 12, 02));
        assertDates(LocalDate.of(2000, 12, 23), LocalDate.of(2024, 1, 02));
        assertDates( LocalDate.of(2024, 1, 02), LocalDate.of(2000, 12, 23));
        assertDates(LocalDate.of(2000, 2, 23), LocalDate.of(2024, 3, 02));
        assertDates(LocalDate.of(2000, 2, 29), LocalDate.of(2024, 3, 02));
        assertDates(LocalDate.of(2000, 3, 29), LocalDate.of(2024, 3, 02));
    }

    private void assertDates(LocalDate date1, LocalDate date2) {
        long expected = Math.abs(date1.toEpochDay() - date2.toEpochDay());
        assertEquals(expected, Sol2.dateDiff(date1, date2), String.format("Didnt match for %s , %s", date1, date2));
    }
}