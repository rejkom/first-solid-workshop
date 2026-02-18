package edu.pg.qa.workshop.order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testy koszyka zakupowego-WERSJA Z NIEZALEŻNYMI TESTAMI
 * <p>
 * ROZWIĄZANIE: Każdy test tworzy własny obiekt 'cart'.
 * Testy są całkowicie NIEZALEŻNE-można je uruchomić w dowolnej kolejności!
 */
class ShoppingCartTest {

    @Test
    void shouldAddSingleItemToEmptyCart() {
        // Given-każdy test tworzy własny koszyk! ✅
        ShoppingCart cart = new ShoppingCart();
        String item = "Laptop";

        // When
        cart.addItem(item);

        // Then
        assertEquals(1, cart.getItemCount());
        assertTrue(cart.getItems().contains("Laptop"));
    }

    @Test
    void shouldAddMultipleItems() {
        // Given-własny, czysty koszyk ✅
        ShoppingCart cart = new ShoppingCart();

        // When
        cart.addItem("Mouse");
        cart.addItem("Keyboard");

        // Then
        assertEquals(2, cart.getItemCount());
    }

    @Test
    void shouldRemoveExistingItem() {
        // Given-przygotowujemy koszyk z produktami ✅
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop");
        cart.addItem("Mouse");

        // When
        cart.removeItem("Laptop");

        // Then
        assertEquals(1, cart.getItemCount());
        assertTrue(cart.getItems().contains("Mouse"));
    }

    @Test
    void shouldClearCartWithMultipleItems() {
        // Given-własny koszyk z danymi testowymi ✅
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Item1");
        cart.addItem("Item2");
        cart.addItem("Item3");

        // When
        cart.clear();

        // Then
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void shouldStartWithEmptyCart() {
        // Given-nowy, pusty koszyk ✅
        ShoppingCart cart = new ShoppingCart();

        // Then
        assertEquals(0, cart.getItemCount());
    }

}
