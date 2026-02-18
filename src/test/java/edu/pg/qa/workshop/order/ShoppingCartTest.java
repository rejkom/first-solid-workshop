package edu.pg.qa.workshop.order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testy koszyka zakupowego- WERSJA ZE WSPÓŁDZIELONYM STANEM
 * <p>
 * PROBLEM: Wszystkie testy używają tego samego obiektu 'cart'.
 * Testy są ZALEŻNE od kolejności wykonania!
 * <p>
 * Spróbuj uruchomić testy w losowej kolejności- mogą się posypać.
 */
class ShoppingCartTest {

    // ❌ PROBLEM: Współdzielony stan między testami!
    private static final ShoppingCart cart = new ShoppingCart();

    @Test
    void test1_shouldAddFirstItem() {
        // Given
        String item = "Laptop";

        // When
        cart.addItem(item);

        // Then
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void test2_shouldAddSecondItem() {
        // Given
        String item = "Mouse";

        // When
        cart.addItem(item);

        // Then
        // ❌ Ten test zakłada, że test1 został już wykonany!
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void test3_shouldRemoveItem() {
        // Given- zakładamy, że w koszyku są już 2 produkty
        String item = "Laptop";

        // When
        cart.removeItem(item);

        // Then
        // ❌ Ten test zakłada, że test1 i test2 zostały już wykonane!
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void test4_shouldClearCart() {
        // When
        cart.clear();

        // Then
        // ❌ Ten test zakłada, że poprzednie testy zostały wykonane!
        assertEquals(0, cart.getItemCount());
    }

}
