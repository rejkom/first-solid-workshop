package edu.pg.qa.workshop.notification;

import static org.mockito.Mockito.*;

class EmailNotificationSenderGoodTest extends BaseNotificationSenderContractTest {

    private final EmailClient emailClient = mock(EmailClient.class);

    @Override
    protected NotificationSender createSender() {
        return new EmailNotificationSender(emailClient);
    }

    @Override
    protected String validRecipient() {
        return "john.doe@example.com";
    }

    @Override
    protected String invalidRecipient() {
        return "not-an-email";
    }

    @Override
    protected void verifyMessageSent(String expectedRecipient, String expectedMessage) {
        verify(emailClient).sendEmail(expectedRecipient, expectedMessage);
    }

    @Override
    protected void verifyNoMessageSent() {
        verifyNoInteractions(emailClient);
    }
}
