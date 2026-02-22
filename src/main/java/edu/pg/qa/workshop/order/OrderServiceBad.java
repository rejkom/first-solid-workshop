package edu.pg.qa.workshop.order;

import java.util.Objects;

/**
 * ANTYWZORZEC DIP:
 * <p>
 * OrderService jest wysokopoziomowym modułem biznesowym,
 * a bezpośrednio tworzy i używa niskopoziomowego FileAuditLogger.
* <p>
 * Skutki:
 * - Twarda zależność na konkretną klasę i na system plików
 * - Trudne testowanie (wymaga prawdziwego pliku)
 * - Brak możliwości podmiany loggera w testach (np. na mock)
 */
public class OrderServiceBad {

    private final String auditFilePath;

    public OrderServiceBad(String auditFilePath) {
        this.auditFilePath = Objects.requireNonNull(auditFilePath);
    }

    public void processPayment(Order order) {
        // tu w prawdziwym systemie byłoby wywołanie bramki płatności itd.
        order.markPaid();

        // Bezpośrednie tworzenie niskopoziomowego loggera
        FileAuditLogger logger = new FileAuditLogger(auditFilePath);
        logger.log("ORDER_PAID", "orderId=" + order.getId());
    }
}
