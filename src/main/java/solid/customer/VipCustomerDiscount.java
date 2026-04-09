package solid.customer;

import solid.DiscountPolicy;
import solid.Order;
import solid.CustomerType;

public class VipCustomerDiscount implements DiscountPolicy {
    @Override
    public boolean appliesTo(Order order) {
        return order.getCustomerType() == CustomerType.VIP;
    }

    @Override
    public double discount(double base) {
        return base * 0.15;
    }
}

