package edu.pg.qa.workshop.order;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

/**
 * Niskopoziomowy logger audytu – zapisuje zdarzenia do pliku.
 * Normalnie nie chcemy go dotykać w testach jednostkowych.
 */
public class FileAuditLogger {

    private final String filePath;

    public FileAuditLogger(String filePath) {
        this.filePath = filePath;
    }

    public void log(String eventType, String details) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
            out.printf("%s | %s | %s%n", Instant.now(), eventType, details);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write audit log", e);
        }
    }
}
