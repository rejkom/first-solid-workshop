package edu.pg.qa.workshop.notification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * ANTYWZORZEC LSP W TESTACH:
 * <p>
 * Test jest przywiązany do konkretnej klasy EmailNotificationSender
 * i jej szczegółów implementacyjnych (np. użycia EmailClient).
 * <p>
 * Gdy dodajemy SmsNotificationSender, musimy skopiować całą logikę testową
 * i zmienić tylko typ klienta. To łamie idee LSP i DRY:
 * - test nie sprawdza kontraktu interfejsu NotificationSender,
 *   tylko konkretną implementację
 * - brak współdzielonego zestawu przypadków dla wielu implementacji
 */
class EmailNotificationSenderBadTest {

    private final EmailClient emailClient = mock(EmailClient.class);
    private final EmailNotificationSender sender = new EmailNotificationSender(emailClient);

    @Test
    void shouldSendEmailForValidRecipient() {
        Notification notification = new Notification("john.doe@example.com", "Hello!");

        boolean result = sender.send(notification);

        assertTrue(result);
        verify(emailClient).sendEmail("john.doe@example.com", "Hello!");
    }

    @Test
    void shouldNotSendEmailForInvalidRecipient() {
        Notification notification = new Notification("not-an-email", "Hello!");

        boolean result = sender.send(notification);

        assertFalse(result);
        verifyNoInteractions(emailClient);
    }

}
