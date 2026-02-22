package edu.pg.qa.workshop.testsupport;

public interface CartActions {
    void addProductToCart(String product);

    void assertCartContains(String product);
}
