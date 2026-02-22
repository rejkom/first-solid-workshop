package edu.pg.qa.workshop.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test dla OrderService w wersji z DIP:
 * <p>
 * - nie dotyka systemu plików
 * - używa prostego in-memory loggera jako test double
 * - skupia się tylko na zachowaniu serwisu (biznes),
 * a nie na szczegółach infrastruktury
 */
class OrderServiceGoodTest {

    @Test
    void shouldMarkOrderAsPaidAndLogEventUsingAbstraction() {
        // given
        InMemoryAuditLogger inMemoryLogger = new InMemoryAuditLogger();
        OrderService service = new OrderService(inMemoryLogger);
        Order order = new Order("customer-123");

        // when
        service.processPayment(order);

        // then
        assertTrue(order.isPaid(), "Zamówienie powinno być oznaczone jako opłacone");
        assertEquals(1, inMemoryLogger.getEvents().size());

        String event = inMemoryLogger.getEvents().getFirst();
        assertTrue(event.contains("ORDER_PAID"));
        assertTrue(event.contains(order.getId()));
    }
}
