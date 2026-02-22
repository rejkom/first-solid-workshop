package edu.pg.qa.workshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShopService {

    private final List<String> cart = new ArrayList<>();
    private boolean loggedIn;
    private boolean orderPlaced;

    public void login(String username, String password) {
        if (Objects.equals(username, "user") && Objects.equals(password, "password")) {
            loggedIn = true;
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void addToCart(String product) {
        if (!loggedIn) {
            throw new IllegalStateException("User must be logged in to add to cart");
        }
        cart.add(product);
    }

    public List<String> getCart() {
        return List.copyOf(cart);
    }

    public void checkout() {
        if (!loggedIn) {
            throw new IllegalStateException("User must be logged in to checkout");
        }
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }
        orderPlaced = true;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }
}
