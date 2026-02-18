package edu.pg.qa.workshop.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testy serwisu rabatowego-WERSJA DETERMINISTYCZNA
 * <p>
 * ROZWIĄZANIE: Przekazujemy konkretną datę do metody.
 * Testy są całkowicie POWTARZALNE-działają tak samo zawsze!
 */
class DiscountServiceTest {

    @Test
    void shouldApplyWeekendDiscountOnSaturday() {
        // Given
        DiscountService service = new DiscountService();
        double orderTotal = 1000.0;
        LocalDate saturday = LocalDate.of(2024, 3, 16); // ✅ Konkretna sobota

        // When
        double discount = service.calculateWeekendDiscount(orderTotal, saturday);

        // Then
        // ✅ Ten test zawsze przechodzi-data jest stała!
        assertEquals(150.0, discount, 0.01);
    }

    @Test
    void shouldApplyWeekendDiscountOnSunday() {
        // Given
        DiscountService service = new DiscountService();
        double orderTotal = 1000.0;
        LocalDate sunday = LocalDate.of(2024, 3, 17); // ✅ Konkretna niedziela

        // When
        double discount = service.calculateWeekendDiscount(orderTotal, sunday);

        // Then
        assertEquals(150.0, discount, 0.01);
    }

    @Test
    void shouldApplyWeekdayDiscountOnMonday() {
        // Given
        DiscountService service = new DiscountService();
        double orderTotal = 500.0;
        LocalDate monday = LocalDate.of(2024, 3, 18); // ✅ Konkretny poniedziałek

        // When
        double discount = service.calculateWeekendDiscount(orderTotal, monday);

        // Then
        assertEquals(25.0, discount, 0.01);
    }

    @Test
    void shouldApplyWeekdayDiscountOnFriday() {
        // Given
        DiscountService service = new DiscountService();
        double orderTotal = 500.0;
        LocalDate friday = LocalDate.of(2024, 3, 22); // ✅ Konkretny piątek

        // When
        double discount = service.calculateWeekendDiscount(orderTotal, friday);

        // Then
        assertEquals(25.0, discount, 0.01);
    }

}
