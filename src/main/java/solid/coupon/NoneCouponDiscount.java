package solid.coupon;

import solid.DiscountPolicy;
import solid.Order;

public class NoneCouponDiscount implements DiscountPolicy {
    @Override
    public double discount(double base, Order order) {
        return 0.0;
    }
}

