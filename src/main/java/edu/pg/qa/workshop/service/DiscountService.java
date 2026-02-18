package edu.pg.qa.workshop.service;

import java.time.LocalDate;

/**
 * Serwis obliczający rabaty zależne od daty- WERSJA DETERMINISTYCZNA.
 * Przyjmuje datę jako parametr, zamiast używać LocalDate.now().
 */
public class DiscountService {

    /**
     * Oblicza rabat na podstawie podanej daty.
     * ✅ Teraz data jest kontrolowana przez wywołującego (w tym testy)!
     */
    public double calculateWeekendDiscount(double orderTotal, LocalDate date) {
        int dayOfWeek = date.getDayOfWeek().getValue();

        // Weekend (sobota=6, niedziela=7)
        if (dayOfWeek >= 6) {
            return orderTotal * 0.15; // 15% rabatu w weekend
        } else {
            return orderTotal * 0.05; // 5% rabatu w tygodniu
        }
    }

}
