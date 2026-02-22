package edu.pg.qa.workshop.order;

public interface AuditLogger {
    void log(String eventType, String details);
}
