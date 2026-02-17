package edu.pg.qa.workshop.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ANTYWZORZEC - Przykład źle napisanych testów.
 * <p>
 * Ten plik demonstruje typowe błędy w pisaniu testów:
 * - Brak struktury given-when-then
 * - Niejasne nazwy testów
 * - Testowanie wielu rzeczy naraz ("god test")
 * - Trudne do debugowania po niepowodzeniu
 * <p>
 * UWAGA: To jest celowo ZŁY przykład do analizy podczas warsztatów!
 */
public class CalculatorBadTest {

    // ❌ PROBLEM 1: Niejasna nazwa - co właściwie testujemy?
    @Test
    void test1() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
        assertEquals(10, calc.multiply(2, 5));
        assertEquals(1, calc.subtract(3, 2));
    }

    // ❌ PROBLEM 2: "God test" - testuje zbyt wiele scenariuszy naraz
    @Test
    void testCalculator() {
        Calculator calc = new Calculator();

        // Dodawanie
        assertEquals(5, calc.add(2, 3));
        assertEquals(0, calc.add(-2, 2));
        assertEquals(-5, calc.add(-2, -3));

        // Odejmowanie
        assertEquals(1, calc.subtract(3, 2));
        assertEquals(-1, calc.subtract(2, 3));

        // Mnożenie
        assertEquals(6, calc.multiply(2, 3));
        assertEquals(0, calc.multiply(0, 5));

        // Dzielenie
        assertEquals(2.0, calc.divide(4, 2));
        assertEquals(2.5, calc.divide(5, 2));

        // Silnia
        assertEquals(1, calc.factorial(0));
        assertEquals(1, calc.factorial(1));
        assertEquals(120, calc.factorial(5));
    }

    // ❌ PROBLEM 3: Brak struktury given-when-then
    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        double result = calc.divide(10, 2);
        assertEquals(5.0, result);
        double result2 = calc.divide(7, 2);
        assertEquals(3.5, result2);
        Calculator calc2 = new Calculator();
        assertEquals(2.5, calc2.divide(5, 2));
    }

    // ❌ PROBLEM 4: Niejasna nazwa i brak kontekstu
    @Test
    void testDivByZero() {
        Calculator calc = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }

    // ❌ PROBLEM 5: Brak jasnego scenariusza
    @Test
    void checkFactorial() {
        Calculator c = new Calculator();
        assertEquals(120, c.factorial(5));
        // Czy ten test sprawdza tylko factorial(5), czy coś więcej?
    }

    // ❌ PROBLEM 6: Zbyt skomplikowana logika w teście
    @Test
    void testMultipleOperations() {
        Calculator calc = new Calculator();
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum = calc.add(sum, i);
        }
        assertEquals(15, sum); // Test zaczyna przypominać produkcyjny kod
    }
}
