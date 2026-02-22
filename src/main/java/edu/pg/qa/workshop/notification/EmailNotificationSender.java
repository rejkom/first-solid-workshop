package edu.pg.qa.workshop.notification;

import java.util.Objects;

public class EmailNotificationSender implements NotificationSender {

    private final EmailClient emailClient;

    public EmailNotificationSender(EmailClient emailClient) {
        this.emailClient = Objects.requireNonNull(emailClient);
    }

    @Override
    public boolean send(Notification notification) {
        if (!notification.getRecipient().contains("@")) {
            return false;
        }
        emailClient.sendEmail(notification.getRecipient(), notification.getMessage());
        return true;
    }
}
