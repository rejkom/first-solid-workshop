package edu.pg.qa.workshop.notification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * ANTYWZORZEC LSP + DUŻA DUPLIKACJA:
 * <p>
 * Ten test jest prawie kopią EmailNotificationSenderBadTest,
 * ale dla SmsNotificationSender.
 * <p>
 * Problem:
 * - Te same przypadki (valid/invalid) powielone w innej klasie
 * - Gdy zmienimy kontrakt NotificationSender, musimy pamiętać
 * o zaktualizowaniu wielu podobnych testów
 * - Brak wspólnego "testu kontraktu" dla NotificationSender
 */
class SmsNotificationSenderBadTest {

    private final SmsClient smsClient = mock(SmsClient.class);
    private final SmsNotificationSender sender = new SmsNotificationSender(smsClient);

    @Test
    void shouldSendSmsForValidPhoneNumber() {
        // given
        Notification notification = new Notification("+48123123123", "Hello via SMS!");

        // when
        boolean result = sender.send(notification);

        // then
        assertTrue(result);
        verify(smsClient).sendSms("+48123123123", "Hello via SMS!");
    }

    @Test
    void shouldNotSendSmsForInvalidPhoneNumber() {
        // given
        Notification notification = new Notification("not-a-phone-number", "Hello via SMS!");

        // when
        boolean result = sender.send(notification);

        // then
        assertFalse(result);
        verifyNoInteractions(smsClient);
    }
}
