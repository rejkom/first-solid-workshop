package edu.pg.qa.workshop.service;

/**
 * "Prawdziwa" implementacja serwisu e-mail.
 * W testach jednostkowych nie chcemy jej używać, bo jest wolna.
 */
public class SmtpEmailService implements EmailService {

    @Override
    public void sendOrderConfirmation(String email, String orderNumber) {
        // Symulacja połączenia z zewnętrznym serwerem SMTP / API
        simulateNetworkLatency();

        // Tu byłby realny kod wysyłający e-mail
        System.out.println("Wysyłam e-mail do: " + email + " dla zamówienia: " + orderNumber);
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2000); // 2 sekundy "sieci"
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
