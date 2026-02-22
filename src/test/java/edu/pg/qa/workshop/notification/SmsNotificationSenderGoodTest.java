package edu.pg.qa.workshop.notification;

import static org.mockito.Mockito.*;

class SmsNotificationSenderGoodTest extends BaseNotificationSenderContractTest {

    private final SmsClient smsClient = mock(SmsClient.class);

    @Override
    protected NotificationSender createSender() {
        return new SmsNotificationSender(smsClient);
    }

    @Override
    protected String validRecipient() {
        return "+48123123123";
    }

    @Override
    protected String invalidRecipient() {
        return "invalid-phone";
    }

    @Override
    protected void verifyMessageSent(String expectedRecipient, String expectedMessage) {
        verify(smsClient).sendSms(expectedRecipient, expectedMessage);
    }

    @Override
    protected void verifyNoMessageSent() {
        verifyNoInteractions(smsClient);
    }
}
