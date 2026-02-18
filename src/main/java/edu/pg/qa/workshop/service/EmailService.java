package edu.pg.qa.workshop.service;

/**
 * Interfejs serwisu e-mail.
 */
public interface EmailService {
    void sendOrderConfirmation(String email, String orderNumber);
}
