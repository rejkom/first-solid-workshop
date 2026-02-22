package edu.pg.qa.workshop.order;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Order {
    private final String id;
    private final String customerId;
    private final Instant createdAt;
    private boolean paid;

    public Order(String customerId) {
        this.id = UUID.randomUUID().toString();
        this.customerId = Objects.requireNonNull(customerId);
        this.createdAt = Instant.now();
        this.paid = false;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public boolean isPaid() {
        return paid;
    }

    public void markPaid() {
        this.paid = true;
    }
}
