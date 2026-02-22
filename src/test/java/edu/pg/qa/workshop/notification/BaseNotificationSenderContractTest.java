package edu.pg.qa.workshop.notification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BAZOWY TEST KONTRAKTU DLA NotificationSender.
 * <p>
 * Zawiera zestaw przypadków, które MUSI spełniać każda poprawna implementacja:
 * - zwraca true dla poprawnego odbiorcy i faktycznie "wysyła" wiadomość
 * - zwraca false dla niepoprawnego odbiorcy i nic nie wysyła
 * <p>
 * Konkretne testy (Email/SMS) tylko dostarczają implementację
 * i sposób weryfikacji "wysłania".
 * <p>
 * To jest LSP w testach:
 * - ten sam zestaw testów działa dla wielu implementacji
 * - jeśli nowa implementacja łamie kontrakt, testy to wychwycą
 */
abstract class BaseNotificationSenderContractTest {

    protected abstract NotificationSender createSender();

    protected abstract String validRecipient();

    protected abstract String invalidRecipient();

    /**
     * Jak zweryfikować, że wiadomość została fizycznie wysłana.
     * Np. verify(mock).sendEmail(...), verify(mock).sendSms(...)
     */
    protected abstract void verifyMessageSent(String expectedRecipient, String expectedMessage);

    /**
     * Jak zweryfikować, że NIE wysłano wiadomości.
     */
    protected abstract void verifyNoMessageSent();

    @Test
    void shouldSendNotificationForValidRecipient() {
        NotificationSender sender = createSender();
        String recipient = validRecipient();
        String message = "Hello from contract test!";
        Notification notification = new Notification(recipient, message);

        boolean result = sender.send(notification);

        assertTrue(result, "Dla poprawnego odbiorcy wynik powinien być true");
        verifyMessageSent(recipient, message);
    }

    @Test
    void shouldNotSendNotificationForInvalidRecipient() {
        NotificationSender sender = createSender();
        String recipient = invalidRecipient();
        String message = "Hello from contract test!";
        Notification notification = new Notification(recipient, message);

        boolean result = sender.send(notification);

        assertFalse(result, "Dla niepoprawnego odbiorcy wynik powinien być false");
        verifyNoMessageSent();
    }
}
