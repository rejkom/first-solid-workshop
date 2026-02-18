package edu.pg.qa.workshop.service;

public class OrderService {

    private final EmailService emailService;

    public OrderService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void placeOrder(String email, String orderNumber) {
        // ... logika związana z zamówieniem

        emailService.sendOrderConfirmation(email, orderNumber);
    }
}
