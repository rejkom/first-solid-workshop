package edu.pg.qa.workshop.discount;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ANTYWZORZEC OCP:
 * <p>
 * Każdy typ klienta ma osobny test z duplikacją logiki.
 * Dodanie nowego typu klienta (np. EMPLOYEE) wymaga:
 * - Skopiowania całego testu
 * - Zmiany tylko danych wejściowych
 * - Ryzyko błędów przy kopiowaniu
 * <p>
 * Problem:
 * - Duplikacja kodu testowego
 * - Trudne utrzymanie
 * - Każda zmiana logiki wymaga modyfikacji wszystkich testów
 * - Łamanie OCP: modyfikujemy istniejący kod zamiast rozszerzać
 */
class DiscountCalculatorBadTest {

    private final DiscountCalculator calculator = new DiscountCalculator();
    private final BigDecimal ORDER_AMOUNT = BigDecimal.valueOf(1000);

    @Test
    void shouldCalculateDiscountForStandardCustomer() {
        // given
        Customer customer = new Customer("Jan Kowalski", CustomerType.STANDARD, 0);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("50.00"), discount); // 5%
        assertEquals(new BigDecimal("950.00"), finalPrice);
    }

    @Test
    void shouldCalculateDiscountForStandardCustomerWith5YearsLoyalty() {
        // given
        Customer customer = new Customer("Jan Kowalski", CustomerType.STANDARD, 5);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("100.00"), discount); // 5% + 5% loyalty = 10%
        assertEquals(new BigDecimal("900.00"), finalPrice);
    }

    @Test
    void shouldCalculateDiscountForPremiumCustomer() {
        // given
        Customer customer = new Customer("Anna Nowak", CustomerType.PREMIUM, 0);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("100.00"), discount); // 10%
        assertEquals(new BigDecimal("900.00"), finalPrice);
    }

    @Test
    void shouldCalculateDiscountForPremiumCustomerWith3YearsLoyalty() {
        // given
        Customer customer = new Customer("Anna Nowak", CustomerType.PREMIUM, 3);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("130.00"), discount); // 10% + 3% loyalty = 13%
        assertEquals(new BigDecimal("870.00"), finalPrice);
    }

    @Test
    void shouldCalculateDiscountForVipCustomer() {
        // given
        Customer customer = new Customer("Piotr Wiśniewski", CustomerType.VIP, 0);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("150.00"), discount); // 15%
        assertEquals(new BigDecimal("850.00"), finalPrice);
    }

    @Test
    void shouldCalculateDiscountForVipCustomerWith10YearsLoyalty() {
        // given
        Customer customer = new Customer("Piotr Wiśniewski", CustomerType.VIP, 10);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("250.00"), discount); // 15% + 10% loyalty = 25%
        assertEquals(new BigDecimal("750.00"), finalPrice);
    }

    @Test
    void shouldCalculateDiscountForCorporateCustomer() {
        // given
        Customer customer = new Customer("Tech Corp", CustomerType.CORPORATE, 0);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("200.00"), discount); // 20%
        assertEquals(new BigDecimal("800.00"), finalPrice);
    }

    @Test
    void shouldCalculateDiscountForCorporateCustomerWith7YearsLoyalty() {
        // given
        Customer customer = new Customer("Tech Corp", CustomerType.CORPORATE, 7);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(new BigDecimal("270.00"), discount); // 20% + 7% loyalty = 27%
        assertEquals(new BigDecimal("730.00"), finalPrice);
    }

    // Problem: Jeśli dodamy nowy typ EMPLOYEE, musimy skopiować 2 kolejne metody!
    // To łamie zasadę Open/Closed - modyfikujemy istniejący kod zamiast go rozszerzać
}
