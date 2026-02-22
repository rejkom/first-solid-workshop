package edu.pg.qa.workshop.testsupport;

import edu.pg.qa.workshop.service.ShopService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IMPLEMENTACJA wielu małych interfejsów.
 * <p>
 * Testy zakupowe mogą zależeć tylko od LoginActions, CartActions, CheckoutActions.
 * Testy administracyjne mogą zależeć od AdminActions, ReportingActions.
 * <p>
 * Dzięki ISP każdy test "widzi" tylko ten fragment API helpera, którego potrzebuje.
 */
public class ShopTestActions implements LoginActions, CartActions, CheckoutActions, AdminActions, ReportingActions {

    private final ShopService shopService;

    public ShopTestActions(ShopService shopService) {
        this.shopService = shopService;
    }

    // ===== LoginActions =====

    @Override
    public void loginAsDefaultUser() {
        shopService.login("user", "password");
        assertTrue(shopService.isLoggedIn(), "Użytkownik powinien być zalogowany");
    }

    // ===== CartActions =====

    @Override
    public void addProductToCart(String product) {
        int before = shopService.getCart().size();
        shopService.addToCart(product);
        List<String> cart = shopService.getCart();
        assertEquals(before + 1, cart.size());
        assertTrue(cart.contains(product));
    }

    @Override
    public void assertCartContains(String product) {
        assertTrue(shopService.getCart().contains(product),
                "Koszyk powinien zawierać produkt: " + product);
    }

    // ===== CheckoutActions =====

    @Override
    public void checkoutAndAssertOrderPlaced() {
        shopService.checkout();
        assertTrue(shopService.isOrderPlaced(), "Zamówienie powinno być złożone");
    }

    // ===== AdminActions =====

    @Override
    public void createAdminUser(String username) {
        // Udawana implementacja na potrzeby przykładu
    }

    @Override
    public void assignRoleToUser(String username, String role) {
        // Udawana implementacja na potrzeby przykładu
    }

    // ===== ReportingActions =====

    @Override
    public void generateSalesReportForLastMonth() {
        // Udawana implementacja na potrzeby przykładu
    }
}
