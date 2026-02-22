package edu.pg.qa.workshop.service;

import edu.pg.qa.workshop.testsupport.CartActions;
import edu.pg.qa.workshop.testsupport.CheckoutActions;
import edu.pg.qa.workshop.testsupport.LoginActions;
import edu.pg.qa.workshop.testsupport.ShopTestActions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Ten test zna tylko LoginActions, CartActions i CheckoutActions.
 * <p>
 * Nie wie nic o metodach admina, raportów itd.
 * Gdy zmieni się część admin/raporty, ten test nie jest dotykany.
 * <p>
 * To jest zastosowanie Interface Segregation Principle
 * w świecie helperów/test utility.
 */
class PlaceOrderGoodTest {

    @Test
    void shouldPlaceOrderUsingSegregatedInterfaces() {
        ShopService shopService = new ShopService();
        ShopTestActions actions = new ShopTestActions(shopService);

        // Można zadeklarować zmienne jako interfejsy
        LoginActions login = actions;
        CartActions cart = actions;
        CheckoutActions checkout = actions;

        login.loginAsDefaultUser();
        cart.addProductToCart("Laptop");
        cart.addProductToCart("Mysz");

        cart.assertCartContains("Laptop");
        cart.assertCartContains("Mysz");

        checkout.checkoutAndAssertOrderPlaced();

        assertTrue(shopService.isOrderPlaced());
        assertEquals(2, shopService.getCart().size());
    }
}
