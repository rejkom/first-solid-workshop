package edu.pg.qa.workshop.notification;

public interface SmsClient {
    void sendSms(String to, String content);
}
