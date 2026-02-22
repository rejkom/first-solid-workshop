package edu.pg.qa.workshop.notification;

import java.time.Instant;
import java.util.Objects;

public class Notification {
    private final String recipient;
    private final String message;
    private final Instant createdAt;

    public Notification(String recipient, String message) {
        this.recipient = Objects.requireNonNull(recipient, "recipient cannot be null");
        this.message = Objects.requireNonNull(message, "message cannot be null");
        this.createdAt = Instant.now();
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
