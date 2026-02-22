package edu.pg.qa.workshop.order;

import java.util.Objects;

/**
 * DOBRA WERSJA DIP:
 * <p>
 * OrderService zależy tylko od abstrakcji AuditLogger.
 * Nie wie, czy log jest do pliku, bazy, konsoli czy do mocka w testach.
 * <p>
 * Dzięki temu:
 * - serwis jest łatwo testowalny (można wstrzyknąć mock/stub)
 * - niskopoziomowe szczegóły logowania można zmieniać bez ruszania serwisu
 */
public class OrderService {

    private final AuditLogger auditLogger;

    public OrderService(AuditLogger auditLogger) {
        this.auditLogger = Objects.requireNonNull(auditLogger);
    }

    public void processPayment(Order order) {
        // tu w prawdziwym systemie byłoby wywołanie bramki płatności itd.
        order.markPaid();

        auditLogger.log("ORDER_PAID", "orderId=" + order.getId());
    }
}
