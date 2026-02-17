package edu.pg.qa.workshop.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WZORZEC - Przykład dobrze napisanych testów zgodnie z zasadami FIRST.
 * <p>
 * Demonstracja dobrych praktyk:
 * - Jasna struktura given-when-then
 * - Czytelne nazwy testów (@DisplayName)
 * - Jeden test = jeden scenariusz
 * - Szybkie, niezależne, powtarzalne, samo‑walidujące się testy
 */
@DisplayName("Testy kalkulatora - wzorzec FIRST")
class CalculatorGoodTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Given: wspólne przygotowanie obiektu przed każdym testem
        calculator = new Calculator();
    }

    // ========= DODAWANIE =========

    @Test
    @DisplayName("Dodawanie dwóch liczb dodatnich powinno zwrócić ich sumę")
    void shouldAddTwoPositiveNumbers() {
        // Given
        int a = 2;
        int b = 3;

        // When
        int result = calculator.add(a, b);

        // Then
        assertEquals(5, result, "2 + 3 powinno dać 5");
    }

    @Test
    @DisplayName("Dodawanie liczby dodatniej i ujemnej powinno zwrócić różnicę")
    void shouldAddPositiveAndNegativeNumber() {
        // Given
        int a = 5;
        int b = -3;

        // When
        int result = calculator.add(a, b);

        // Then
        assertEquals(2, result, "5 + (-3) powinno dać 2");
    }

    // ========= ODEJMOWANIE =========

    @Test
    @DisplayName("Odejmowanie mniejszej liczby od większej daje wynik dodatni")
    void shouldSubtractSmallerFromLargerNumber() {
        // Given
        int a = 5;
        int b = 3;

        // When
        int result = calculator.subtract(a, b);

        // Then
        assertEquals(2, result, "5 - 3 powinno dać 2");
    }

    @Test
    @DisplayName("Odejmowanie większej liczby od mniejszej daje wynik ujemny")
    void shouldSubtractLargerFromSmallerNumber() {
        // Given
        int a = 3;
        int b = 5;

        // When
        int result = calculator.subtract(a, b);

        // Then
        assertEquals(-2, result, "3 - 5 powinno dać -2");
    }

    // ========= MNOŻENIE =========

    @Test
    @DisplayName("Mnożenie przez zero powinno zwrócić zero")
    void shouldReturnZeroWhenMultiplyingByZero() {
        // Given
        int a = 5;
        int b = 0;

        // When
        int result = calculator.multiply(a, b);

        // Then
        assertEquals(0, result, "Mnożenie przez zero powinno dać 0");
    }

    // ========= DZIELENIE =========

    @Test
    @DisplayName("Dzielenie dwóch liczb całkowitych zwraca wynik zmiennoprzecinkowy")
    void shouldDivideTwoIntegers() {
        // Given
        int a = 10;
        int b = 4;

        // When
        double result = calculator.divide(a, b);

        // Then
        assertEquals(2.5, result, 0.0001, "10 / 4 powinno dać 2.5");
    }

    @Test
    @DisplayName("Dzielenie przez zero powinno rzucić IllegalArgumentException")
    void shouldThrowExceptionWhenDividingByZero() {
        // Given
        int a = 10;
        int b = 0;

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(a, b),
                "Dzielenie przez zero powinno rzucić IllegalArgumentException"
        );

        assertTrue(
                exception.getMessage().contains("zero"),
                "Komunikat wyjątku powinien wspominać o dzieleniu przez zero"
        );
    }

    // ========= SILNIA =========

    @Test
    @DisplayName("Silnia z 0 powinna zwrócić 1")
    void shouldReturnOneForFactorialOfZero() {
        // Given
        int n = 0;

        // When
        long result = calculator.factorial(n);

        // Then
        assertEquals(1, result, "0! powinno równać się 1");
    }

    @Test
    @DisplayName("Silnia liczby ujemnej powinna rzucić IllegalArgumentException")
    void shouldThrowExceptionForNegativeFactorial() {
        // Given
        int n = -5;

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.factorial(n),
                "Silnia liczby ujemnej powinna rzucić wyjątek"
        );

        assertTrue(
                exception.getMessage().contains("ujemnych"),
                "Komunikat powinien wspominać o liczbach ujemnych"
        );
    }

    // ========= PARZYSTOŚĆ =========

    @Test
    @DisplayName("Zero powinno być rozpoznane jako liczba parzysta")
    void shouldRecognizeZeroAsEven() {
        // Given
        int zero = 0;

        // When
        boolean result = calculator.isEven(zero);

        // Then
        assertTrue(result, "0 jest liczbą parzystą");
    }

    @Test
    @DisplayName("Liczba nieparzysta powinna być rozpoznana jako nieparzysta")
    void shouldRecognizeOddNumber() {
        // Given
        int oddNumber = 5;

        // When
        boolean result = calculator.isEven(oddNumber);

        // Then
        assertFalse(result, "5 jest liczbą nieparzystą");
    }

}
