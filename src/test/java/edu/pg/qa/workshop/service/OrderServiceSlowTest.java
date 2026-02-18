package edu.pg.qa.workshop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Test OrderService używający PRAWDZIWEJ implementacji EmailService.
 * <p>
 * PROBLEM:
 * - Test jest WOLNY (czeka 2 sekundy na "sieć").
 * - W prawdziwym projekcie 2 sekundy mogą zamienić się w 5 sekund, 10 sekund itd.
 * - Przy wielu testach całkowity czas wykonania mocno rośnie.
 */
public class OrderServiceSlowTest {

    @Test
    void shouldSendConfirmationEmailUsingRealEmailService() {
        // Given – używamy realnego serwisu SMTP (symulowanego)
        EmailService realEmailService = new SmtpEmailService();
        OrderService orderService = new OrderService(realEmailService);

        String email = "jan.kowalski@example.com";
        String orderNumber = "ORDER-123";

        // When / Then
        assertDoesNotThrow(() -> orderService.placeOrder(email, orderNumber));
        // Test przechodzi, ale wykonuje się ~2 sekundy
    }
}
