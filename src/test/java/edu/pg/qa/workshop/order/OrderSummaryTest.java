package edu.pg.qa.workshop.order;

import org.junit.jupiter.api.Test;

/**
 * Testy generatora podsumowania-WERSJA BEZ ASERCJI
 * <p>
 * PROBLEM: Testy wypisują wynik na konsolę i oczekują ręcznej weryfikacji.
 * Nie ma automatycznej asercji- nie wiadomo czy test przeszedł!
 * <p>
 * Uruchom testy i zobacz: junit pokazuje je jako "zielone", ale czy na pewno działają?
 */
class OrderSummaryTest {

    @Test
    void shouldGenerateSummaryForSingleItem() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Jan Kowalski", 1500.00, 1);

        // Then
        // ❌ Brak asercji! Test "przechodzi" nawet jeśli wynik jest błędny
        System.out.println("=== TEST 1: Pojedynczy produkt ===");
        System.out.println(summary);
        System.out.println("Sprawdź ręcznie czy podsumowanie jest poprawne!\n");
    }

    @Test
    void shouldGenerateSummaryForMultipleItems() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Anna Nowak", 3250.50, 5);

        // Then
        // ❌ Tylko wypisujemy na konsolę-trzeba ręcznie czytać logi
        System.out.println("=== TEST 2: Wiele produktów ===");
        System.out.println(summary);
        System.out.println("Sprawdź ręcznie czy:\n");
        System.out.println("  - Nazwa klienta się zgadza");
        System.out.println("  - Liczba produktów to 5");
        System.out.println("  - Kwota to 3250.50 PLN\n");
    }

    @Test
    void shouldFormatAmountWithTwoDecimals() {
        // Given
        OrderSummary generator = new OrderSummary();

        // When
        String summary = generator.generateSummary("Piotr Wiśniewski", 99.9, 2);

        // Then
        // ❌ Wymaga ręcznej inspekcji- czy kwota ma format "99.90"?
        System.out.println("=== TEST 3: Formatowanie kwoty ===");
        System.out.println(summary);
        System.out.println("WAŻNE: Sprawdź czy kwota ma dokładnie 2 miejsca po przecinku!\n");
    }

}
