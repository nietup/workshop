package solid.customer;

import solid.DiscountPolicy;
import solid.Order;

public class PremiumCustomerDiscount implements DiscountPolicy {
    @Override
    public double discount(double base, Order order) {
        return base * 0.10;
    }
}

