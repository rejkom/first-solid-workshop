package edu.pg.qa.workshop.calculator;

/**
 * Prosty kalkulator do demonstracji testów jednostkowych.
 *
 * Klasa zawiera podstawowe operacje matematyczne i służy jako przykład
 * do nauki pisania testów zgodnie z zasadami FIRST i SOLID.
 */
public class Calculator {

    /**
     * Dodaje dwie liczby.
     *
     * @param a pierwsza liczba
     * @param b druga liczba
     * @return suma a + b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Odejmuje drugą liczbę od pierwszej.
     *
     * @param a odjemna
     * @param b odjemnik
     * @return różnica a - b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Mnoży dwie liczby.
     *
     * @param a pierwszy czynnik
     * @param b drugi czynnik
     * @return iloczyn a * b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Dzieli pierwszą liczbę przez drugą.
     *
     * @param a dzielna
     * @param b dzielnik
     * @return iloraz a / b
     * @throws IllegalArgumentException gdy b jest zerem
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Dzielenie przez zero jest niedozwolone");
        }
        return (double) a / b;
    }

    /**
     * Oblicza silnię liczby (factorial).
     * Uwaga: metoda działa tylko dla liczb nieujemnych.
     *
     * @param n liczba do obliczenia silni
     * @return silnia n!
     * @throws IllegalArgumentException gdy n < 0
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Silnia nie jest zdefiniowana dla liczb ujemnych");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Sprawdza, czy liczba jest parzysta.
     *
     * @param number liczba do sprawdzenia
     * @return true jeśli liczba jest parzysta, false w przeciwnym razie
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
