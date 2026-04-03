package solid.coupon;

import solid.DiscountPolicy;
import solid.Order;

public class SeasonalCouponDiscount implements DiscountPolicy {
    @Override
    public double discount(double base, Order order) {
        return 20.0;
    }
}

