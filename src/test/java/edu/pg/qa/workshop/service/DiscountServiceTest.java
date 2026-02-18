package edu.pg.qa.workshop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testy serwisu rabatowego-WERSJA NIEDETERMINISTYCZNA
 * <p>
 * PROBLEM: Test zachowuje się inaczej w zależności od dnia tygodnia!
 * W weekend przechodzi, w tygodniu pada (lub odwrotnie).
 * <p>
 * Uruchom ten test w poniedziałek i w sobotę-zobaczysz różne wyniki.
 */
public class DiscountServiceTest {

    @Test
    void shouldApplyWeekendDiscount() {
        // Given
        DiscountService service = new DiscountService();
        double orderTotal = 1000.0;

        // When
        double discount = service.calculateWeekendDiscount(orderTotal);

        // Then
        // ❌ Ten test działa tylko w weekendy!
        // W poniedziałek-piątek pada, bo rabat wynosi 50, nie 150
        assertEquals(150.0, discount, 0.01);
    }

    @Test
    void shouldApplyWeekdayDiscount() {
        // Given
        DiscountService service = new DiscountService();
        double orderTotal = 500.0;

        // When
        double discount = service.calculateWeekendDiscount(orderTotal);

        // Then
        // ❌ Ten test działa tylko w tygodniu!
        // W weekend pada, bo rabat wynosi 75, nie 25
        assertEquals(25.0, discount, 0.01);
    }

}
