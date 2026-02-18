package edu.pg.qa.workshop.service;

import java.time.LocalDate;

/**
 * Serwis obliczający rabaty zależne od daty.
 */
public class DiscountService {

    /**
     * Oblicza rabat- wyższy w weekendy.
     * PROBLEM: Używa aktualnej daty systemowej!
     */
    public double calculateWeekendDiscount(double orderTotal) {
        LocalDate today = LocalDate.now(); // ❌ Niedeterministyczne!

        int dayOfWeek = today.getDayOfWeek().getValue();

        // Weekend (sobota=6, niedziela=7)
        if (dayOfWeek >= 6) {
            return orderTotal * 0.15; // 15% rabatu w weekend
        } else {
            return orderTotal * 0.05; // 5% rabatu w tygodniu
        }
    }

}
