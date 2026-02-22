package edu.pg.qa.workshop.order;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test dla OrderServiceBad jest:
 * - wolny (działa na systemie plików)
 * - kruchy (problemy z uprawnieniami, brakiem miejsca itp.)
 * - skomplikowany (trzeba czytać plik, parsować logi)
 * <p>
 * To skutki łamania DIP: wysokopoziomowy serwis
 * zależy bezpośrednio od niskopoziomowego FileAuditLogger.
 */
class OrderServiceBadTest {

    @Test
    void shouldMarkOrderAsPaidAndWriteLogToFile() throws IOException {
        // given
        Path tempFile = Files.createTempFile("audit-log", ".txt");
        Order order = new Order("customer-123");
        OrderServiceBad service = new OrderServiceBad(tempFile.toString());

        // when
        service.processPayment(order);

        // then
        assertTrue(order.isPaid(), "Zamówienie powinno być oznaczone jako opłacone");

        String logContent = Files.readString(tempFile);
        assertTrue(logContent.contains("ORDER_PAID"), "Log powinien zawierać typ zdarzenia ORDER_PAID");
        assertTrue(logContent.contains(order.getId()), "Log powinien zawierać ID zamówienia");
    }
}
