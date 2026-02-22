package edu.pg.qa.workshop.notification;

import java.util.Objects;

public class SmsNotificationSender implements NotificationSender {

    private final SmsClient smsClient;

    public SmsNotificationSender(SmsClient smsClient) {
        this.smsClient = Objects.requireNonNull(smsClient);
    }

    @Override
    public boolean send(Notification notification) {
        // Bardzo prosta walidacja telefonu, tylko na potrzeby przykładu
        if (!notification.getRecipient().matches("\\+?[0-9]{9,15}")) {
            return false;
        }
        smsClient.sendSms(notification.getRecipient(), notification.getMessage());
        return true;
    }
}
