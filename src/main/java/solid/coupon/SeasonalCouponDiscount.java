package solid.coupon;

import solid.CouponType;
import solid.DiscountPolicy;
import solid.Order;

public class SeasonalCouponDiscount implements DiscountPolicy {
    @Override
    public boolean appliesTo(Order order) {
        return order.getCouponType() == CouponType.SEASONAL;
    }

    @Override
    public double discount(double base) {
        return 20.0;
    }
}

