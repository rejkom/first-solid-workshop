package edu.pg.qa.workshop.user;

public interface AuditLogger {
    void log(String eventType, String details);
}
