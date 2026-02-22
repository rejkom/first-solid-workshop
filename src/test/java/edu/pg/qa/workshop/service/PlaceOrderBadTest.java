package edu.pg.qa.workshop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ten test potrzebuje tak naprawdę:
 * - logowania
 * - dodania produktu do koszyka
 * - checkoutu
 * <p>
 * Ale przez "duży" UiTestHelper z wieloma metodami, zależy też od:
 * - generowania raportów
 * - administracji użytkownikami
 * - resetowania bazy itd.
 * <p>
 * To jest naruszenie Interface Segregation Principle:
 * test jest zmuszony zależeć od metod, których nie używa.
 */
class PlaceOrderBadTest {

    @Test
    void shouldPlaceOrderUsingUiHelper() {
        ShopService shopService = new ShopService();
        UiTestHelper helper = new UiTestHelper(shopService);

        helper.loginAsDefaultUser();
        helper.addProductToCartAndAssert("Laptop");
        helper.addProductToCartAndAssert("Mysz");

        helper.checkoutAndAssertOrderPlaced();

        assertTrue(shopService.isOrderPlaced());
        assertEquals(2, shopService.getCart().size());
    }
}
