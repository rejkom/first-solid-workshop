package edu.pg.qa.workshop.order;

/**
 * Generator podsumowania zamówienia w formacie tekstowym.
 */
public class OrderSummary {

    /**
     * Generuje podsumowanie zamówienia.
     */
    public String generateSummary(String customerName, double total, int itemCount) {
        return "=== PODSUMOWANIE ZAMÓWIENIA ===\n" +
                "Klient: " + customerName + "\n" +
                "Liczba produktów: " + itemCount + "\n" +
                "Całkowita kwota: " + String.format("%.2f", total) + " PLN\n" +
                "===============================";
    }
}
