package edu.pg.qa.workshop.notification;

public interface NotificationSender {
    /**
     * Wysyła powiadomienie do odbiorcy.
     *
     * @param notification powiadomienie do wysłania
     * @return true, jeśli wysłano, false jeśli nie było to możliwe (np. brak kanału)
     */
    boolean send(Notification notification);
}
