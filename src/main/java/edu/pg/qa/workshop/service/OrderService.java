package edu.pg.qa.workshop.service;

/**
 * Serwis obsługujący zamówienia.
 */
public class OrderService {

    private final EmailService emailService;

    public OrderService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void placeOrder(String email, String orderNumber) {
        // Tu mogłaby być logika zapisu zamówienia, płatności itd.
        // ...

        // Wysłanie potwierdzenia zamówienia
        emailService.sendOrderConfirmation(email, orderNumber);
    }
}
