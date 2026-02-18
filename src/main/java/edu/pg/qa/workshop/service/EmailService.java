package edu.pg.qa.workshop.service;

public interface EmailService {
    void sendOrderConfirmation(String email, String orderNumber);
}