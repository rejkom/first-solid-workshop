package edu.pg.qa.workshop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Szybki test jednostkowy OrderService z użyciem prostego mocka EmailService.
 * <p>
 * Zamiast łączyć się z prawdziwym serwerem (wolno, niestabilnie),
 * tworzymy małą klasę w teście, która:
 * - zapamiętuje, że została wywołana,
 * - zapamiętuje parametry.
 * <p>
 * Dzięki temu:
 * - test jest BARDZO SZYBKI,
 * - nie potrzebuje sieci ani SMTP,
 * - nadal sprawdza poprawne zachowanie OrderService.
 */
public class OrderServiceTest {

    /**
     * Prosty "mock" / "fake" EmailService napisany ręcznie.
     * Nie wysyła e-maila - tylko zapamiętuje dane wywołania.
     */
    private static class FakeEmailService implements EmailService {

        boolean wasCalled = false;
        String capturedEmail;
        String capturedOrderNumber;

        @Override
        public void sendOrderConfirmation(String email, String orderNumber) {
            this.wasCalled = true;
            this.capturedEmail = email;
            this.capturedOrderNumber = orderNumber;
        }
    }

    @Test
    void shouldSendConfirmationEmailWhenOrderIsPlaced() {
        // Given – używamy szybkiego, lokalnego mocka zamiast prawdziwego serwisu
        FakeEmailService fakeEmailService = new FakeEmailService();
        OrderService orderService = new OrderService(fakeEmailService);

        String email = "jan.kowalski@example.com";
        String orderNumber = "ORDER-123";

        // When
        orderService.placeOrder(email, orderNumber);

        // Then – test jest szybki i w pełni automatyczny
        assertTrue(fakeEmailService.wasCalled,
                "Powinien zostać wywołany serwis e-mail z potwierdzeniem");
        assertEquals(email, fakeEmailService.capturedEmail,
                "Adres e-mail powinien zostać przekazany poprawnie");
        assertEquals(orderNumber, fakeEmailService.capturedOrderNumber,
                "Numer zamówienia powinien zostać przekazany poprawnie");
    }

}
