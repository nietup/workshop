package solid.coupon;

import org.springframework.stereotype.Component;
import solid.CouponType;
import solid.DiscountPolicy;
import solid.Order;

@Component
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

