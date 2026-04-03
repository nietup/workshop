package solid.customer;

import solid.DiscountPolicy;
import solid.Order;

public class StandardCustomerDiscount implements DiscountPolicy {
    @Override
    public double discount(double base, Order order) {
        return 0.0;
    }
}

