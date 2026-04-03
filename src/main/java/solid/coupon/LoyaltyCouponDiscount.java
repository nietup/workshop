package solid.coupon;

import solid.DiscountPolicy;
import solid.Order;

public class LoyaltyCouponDiscount implements DiscountPolicy {
    @Override
    public double discount(double base, Order order) {
        return base >= 200.0 ? 30.0 : 10.0;
    }
}

