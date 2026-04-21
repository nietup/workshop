package solid.customer;

import solid.DiscountPolicy;
import solid.Order;
import solid.CustomerType;

public class StandardCustomerDiscount implements DiscountPolicy {
    @Override
    public boolean appliesTo(Order order) {
        return order.getCustomerType() == CustomerType.STANDARD;
    }

    @Override
    public double discount(double base) {
        return 0.0;
    }
}

