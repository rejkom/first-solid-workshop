package edu.pg.qa.workshop.discount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DOBRE PRAKTYKI OCP:
 * <p>
 * Użycie testów parametryzowanych (@ParameterizedTest).
 * Dodanie nowego typu klienta wymaga tylko:
 * - Dodania jednej linii danych w metodzie testData()
 * - Zero zmian w logice testu
 * <p>
 * Korzyści:
 * - Brak duplikacji kodu testowego
 * - Łatwe rozszerzanie (Open for extension)
 * - Brak modyfikacji istniejących testów (Closed for modification)
 * - Wszystkie scenariusze w jednym miejscu
 * - Łatwe porównanie zachowania dla różnych typów
 */
class DiscountCalculatorGoodTest {

    private final DiscountCalculator calculator = new DiscountCalculator();
    private final BigDecimal ORDER_AMOUNT = BigDecimal.valueOf(1000);

    @ParameterizedTest(name = "{0}: {1} lat lojalności -> {2}% zniżki")
    @MethodSource("discountTestData")
    void shouldCalculateCorrectDiscount(CustomerType type,
                                        int loyaltyYears,
                                        BigDecimal expectedDiscountAmount,
                                        BigDecimal expectedFinalPrice) {
        // given
        Customer customer = new Customer("Test Customer", type, loyaltyYears);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);
        BigDecimal finalPrice = calculator.calculateFinalPrice(customer, ORDER_AMOUNT);

        // then
        assertEquals(expectedDiscountAmount, discount,
                String.format("Nieprawidłowa zniżka dla %s z %d latami lojalności", type, loyaltyYears));
        assertEquals(expectedFinalPrice, finalPrice,
                String.format("Nieprawidłowa cena końcowa dla %s z %d latami lojalności", type, loyaltyYears));
    }

    /**
     * Źródło danych testowych.
     * <p>
     * Dodanie nowego typu klienta (np. EMPLOYEE) wymaga tylko:
     * Arguments.of(CustomerType.EMPLOYEE, 0, new BigDecimal("80.00"), new BigDecimal("920.00")),
     * Arguments.of(CustomerType.EMPLOYEE, 5, new BigDecimal("130.00"), new BigDecimal("870.00"))
     * <p>
     * To jest OCP w praktyce!
     */
    static Stream<Arguments> discountTestData() {
        return Stream.of(
                // CustomerType, LoyaltyYears, ExpectedDiscount, ExpectedFinalPrice

                // STANDARD: 5% base
                Arguments.of(CustomerType.STANDARD, 0, new BigDecimal("50.00"), new BigDecimal("950.00")),
                Arguments.of(CustomerType.STANDARD, 5, new BigDecimal("100.00"), new BigDecimal("900.00")),
                Arguments.of(CustomerType.STANDARD, 10, new BigDecimal("150.00"), new BigDecimal("850.00")),

                // PREMIUM: 10% base
                Arguments.of(CustomerType.PREMIUM, 0, new BigDecimal("100.00"), new BigDecimal("900.00")),
                Arguments.of(CustomerType.PREMIUM, 3, new BigDecimal("130.00"), new BigDecimal("870.00")),
                Arguments.of(CustomerType.PREMIUM, 10, new BigDecimal("200.00"), new BigDecimal("800.00")),

                // VIP: 15% base
                Arguments.of(CustomerType.VIP, 0, new BigDecimal("150.00"), new BigDecimal("850.00")),
                Arguments.of(CustomerType.VIP, 10, new BigDecimal("250.00"), new BigDecimal("750.00")),

                // CORPORATE: 20% base
                Arguments.of(CustomerType.CORPORATE, 0, new BigDecimal("200.00"), new BigDecimal("800.00")),
                Arguments.of(CustomerType.CORPORATE, 7, new BigDecimal("270.00"), new BigDecimal("730.00"))

                // Dodanie nowego typu wymaga tylko dodania linii tutaj - zero zmian w logice testu!
        );
    }

    /**
     * Osobny test parametryzowany dla przypadków brzegowych lojalności
     */
    @ParameterizedTest(name = "{0}: {1} lat -> bonus lojalności ograniczony do 10%")
    @MethodSource("loyaltyCapTestData")
    void shouldCapLoyaltyBonusAt10Percent(CustomerType type, int loyaltyYears, BigDecimal expectedDiscount) {
        // given
        Customer customer = new Customer("Test Customer", type, loyaltyYears);

        // when
        BigDecimal discount = calculator.calculateDiscount(customer, ORDER_AMOUNT);

        // then
        assertEquals(expectedDiscount, discount,
                "Bonus lojalności powinien być ograniczony do 10%");
    }

    static Stream<Arguments> loyaltyCapTestData() {
        return Stream.of(
                // Sprawdzamy czy bonus jest ograniczony do 10% nawet przy 15+ latach
                Arguments.of(CustomerType.STANDARD, 15, new BigDecimal("150.00")), // 5% + max 10% = 15%
                Arguments.of(CustomerType.PREMIUM, 20, new BigDecimal("200.00")),  // 10% + max 10% = 20%
                Arguments.of(CustomerType.VIP, 12, new BigDecimal("250.00"))       // 15% + max 10% = 25%
        );
    }
}
