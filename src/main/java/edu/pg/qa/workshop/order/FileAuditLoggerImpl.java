package edu.pg.qa.workshop.order;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

/**
 * Szczegółowa implementacja oparta o plik.
 * Zależy od abstrakcji AuditLogger.
 */
public class FileAuditLoggerImpl implements AuditLogger {

    private final String filePath;

    public FileAuditLoggerImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String eventType, String details) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
            out.printf("%s | %s | %s%n", Instant.now(), eventType, details);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write audit log", e);
        }
    }
}
