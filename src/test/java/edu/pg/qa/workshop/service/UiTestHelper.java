package edu.pg.qa.workshop.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ANTYWZORZEC ISP:
 * Jeden "duży" helper z wieloma metodami do wszystkiego.
 * <p>
 * Testy, które potrzebują tylko logowania i koszyka,
 * muszą zależeć też od metod raportowych, admina itd.
 * <p>
 * Gdy zmieniamy jeden obszar, helper wymusza rekompilację
 * i możliwe zmiany we wszystkich testach, które go używają.
 */
public class UiTestHelper {

    private final ShopService shopService;

    public UiTestHelper(ShopService shopService) {
        this.shopService = shopService;
    }

    // ===== Sekcja: logowanie =====

    public void loginAsDefaultUser() {
        shopService.login("user", "password");
        assertTrue(shopService.isLoggedIn(), "Użytkownik powinien być zalogowany");
    }

    public void loginAs(String username, String password, boolean expectedSuccess) {
        try {
            shopService.login(username, password);
            assertEquals(expectedSuccess, shopService.isLoggedIn());
        } catch (Exception e) {
            assertFalse(expectedSuccess, "Logowanie nie powinno rzucać wyjątku dla poprawnych danych");
        }
    }

    // ===== Sekcja: koszyk =====

    public void addProductToCartAndAssert(String product) {
        int before = shopService.getCart().size();
        shopService.addToCart(product);
        List<String> cart = shopService.getCart();
        assertEquals(before + 1, cart.size());
        assertTrue(cart.contains(product));
    }

    public void assertCartContains(String product) {
        assertTrue(shopService.getCart().contains(product),
                "Koszyk powinien zawierać produkt: " + product);
    }

    // ===== Sekcja: checkout =====

    public void checkoutAndAssertOrderPlaced() {
        shopService.checkout();
        assertTrue(shopService.isOrderPlaced(), "Zamówienie powinno być złożone");
    }

    // ===== Sekcja: admin / raporty / inne (udawane) =====

    public void generateSalesReportForLastMonth() {
        // Symulacja metody, która w testach posiada inne odpowiedzialności
        // (np. korzysta z dodatkowych zależności, plików, bazy danych itd.)
        // Tu pusta implementacja- chodzi o pokazanie mnogości metod klasy pomocniczej (helpera).
    }

    public void resetDatabase() {
        // kolejna metoda, której większość testów nie potrzebuje
    }

    public void createAdminUser(String username) {
        // metoda administacyjna- kompletnie zbędna dla testów koszyka
    }

    public void assignRoleToUser(String username, String role) {
        // kolejna metoda, której przeciętny test nie użyje
    }

    // Wyobraźmy sobie jeszcze 10 podobnych metod :)
}
