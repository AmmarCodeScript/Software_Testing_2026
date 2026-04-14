package src.assign2025.assign1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarTest {

    @Test
    void testFebruaryLeapYear() {
        assertEquals(29, Calendar.calculateDaysInMonth(2, 2024));
    }
}