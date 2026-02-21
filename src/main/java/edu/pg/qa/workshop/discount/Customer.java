package edu.pg.qa.workshop.discount;

public class Customer {
    private final String name;
    private final CustomerType type;
    private final int loyaltyYears;

    public Customer(String name, CustomerType type, int loyaltyYears) {
        this.name = name;
        this.type = type;
        this.loyaltyYears = loyaltyYears;
    }

    public String getName() {
        return name;
    }

    public CustomerType getType() {
        return type;
    }

    public int getLoyaltyYears() {
        return loyaltyYears;
    }
}
