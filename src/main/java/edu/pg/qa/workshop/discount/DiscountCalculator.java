package edu.pg.qa.workshop.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountCalculator {

    public BigDecimal calculateDiscount(Customer customer, BigDecimal orderAmount) {
        BigDecimal discountPercentage = getDiscountPercentage(customer);
        return orderAmount
                .multiply(discountPercentage)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    private BigDecimal getDiscountPercentage(Customer customer) {
        BigDecimal baseDiscount = switch (customer.getType()) {
            case STANDARD -> BigDecimal.valueOf(5);
            case PREMIUM -> BigDecimal.valueOf(10);
            case VIP -> BigDecimal.valueOf(15);
            case CORPORATE -> BigDecimal.valueOf(20);
        };

        // Bonus za lojalność: +1% za każdy rok (max 10%)
        BigDecimal loyaltyBonus = BigDecimal.valueOf(Math.min(customer.getLoyaltyYears(), 10));

        return baseDiscount.add(loyaltyBonus);
    }

    public BigDecimal calculateFinalPrice(Customer customer, BigDecimal orderAmount) {
        BigDecimal discount = calculateDiscount(customer, orderAmount);
        return orderAmount.subtract(discount).setScale(2, RoundingMode.HALF_UP);
    }
}
