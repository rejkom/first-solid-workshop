package edu.pg.qa.workshop.notification;

public interface EmailClient {
    void sendEmail(String to, String content);
}
