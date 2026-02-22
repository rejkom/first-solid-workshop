package edu.pg.qa.workshop.order;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuditLogger implements AuditLogger {

    private final List<String> events = new ArrayList<>();

    @Override
    public void log(String eventType, String details) {
        events.add(eventType + "|" + details);
    }

    public List<String> getEvents() {
        return List.copyOf(events);
    }
}
