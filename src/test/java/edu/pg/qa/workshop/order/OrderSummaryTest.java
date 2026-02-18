package edu.pg.qa.workshop.order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testy generatora podsumowania - WERSJA Z ASERCJAMI
 * <p>
 * ROZWIĄZANIE: Każdy test ma czytelne asercje sprawdzające konkretne wartości.
 * Test SAM mówi, czy przeszedł (zielony) czy nie (czerwony z komunikatem).
 */
class OrderSummaryTest {

    @Test
    void shouldGenerateSummaryForSingleItem() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Jan Kowalski", 1500.00, 1);

        // Then - ✅ Konkretne asercje, automatyczna weryfikacja
        assertTrue(summary.contains("Klient: Jan Kowalski"),
                "Podsumowanie powinno zawierać nazwę klienta");
        assertTrue(summary.contains("Liczba produktów: 1"),
                "Podsumowanie powinno zawierać liczbę produktów");
        assertTrue(summary.contains("1500.00 PLN"),
                "Podsumowanie powinno zawierać kwotę z 2 miejscami po przecinku");
    }

    @Test
    void shouldGenerateSummaryForMultipleItems() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Anna Nowak", 3250.50, 5);

        // Then - ✅ Każda ważna wartość jest sprawdzana
        assertTrue(summary.contains("Anna Nowak"),
                "Nazwa klienta powinna być w podsumowaniu");
        assertTrue(summary.contains("Liczba produktów: 5"),
                "Liczba produktów powinna wynosić 5");
        assertTrue(summary.contains("3250.50 PLN"),
                "Kwota powinna być sformatowana z 2 miejscami po przecinku");
    }

    @Test
    void shouldFormatAmountWithTwoDecimalPlaces() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Piotr Wiśniewski", 99.9, 2);

        // Then - ✅ Sprawdzamy dokładny format kwoty
        assertTrue(summary.contains("99.90 PLN"),
                "Kwota powinna być sformatowana jako 99.90 (z zerem na końcu)");
        assertFalse(summary.contains("99.9 PLN"),
                "Kwota nie powinna być sformatowana jako 99.9 (brak drugiego miejsca)");
    }

    @Test
    void shouldIncludeHeaderAndFooter() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Test User", 100.0, 1);

        // Then - ✅ Sprawdzamy strukturę podsumowania
        assertTrue(summary.startsWith("=== PODSUMOWANIE ZAMÓWIENIA ==="),
                "Podsumowanie powinno zaczynać się od nagłówka");
        assertTrue(summary.endsWith("==============================="),
                "Podsumowanie powinno kończyć się stopką");
    }

    @Test
    void shouldContainAllRequiredFields() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Maria Kowal", 500.25, 3);

        // Then - ✅ Sprawdzamy obecność wszystkich wymaganych pól
        assertAll("Wszystkie wymagane pola powinny być w podsumowaniu",
                () -> assertTrue(summary.contains("Klient:"), "Brak etykiety klienta"),
                () -> assertTrue(summary.contains("Maria Kowal"), "Brak nazwy klienta"),
                () -> assertTrue(summary.contains("Liczba produktów:"), "Brak etykiety liczby produktów"),
                () -> assertTrue(summary.contains("3"), "Brak liczby produktów"),
                () -> assertTrue(summary.contains("Całkowita kwota:"), "Brak etykiety kwoty"),
                () -> assertTrue(summary.contains("500.25"), "Brak kwoty")
        );
    }

}
