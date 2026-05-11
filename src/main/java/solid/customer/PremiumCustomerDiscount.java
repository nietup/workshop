package solid.customer;

import solid.DiscountPolicy;
import solid.Order;
import solid.CustomerType;


public class PremiumCustomerDiscount implements DiscountPolicy {
    @Override
    public boolean appliesTo(Order order) {
        return order.getCustomerType() == CustomerType.PREMIUM;
    }

    @Override
    public double discount(double base) {
        return base * 0.10;
    }
}

