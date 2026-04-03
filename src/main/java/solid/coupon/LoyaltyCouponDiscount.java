package solid.coupon;

import org.springframework.stereotype.Component;
import solid.CouponType;
import solid.DiscountPolicy;
import solid.Order;

@Component
public class LoyaltyCouponDiscount implements DiscountPolicy {
    @Override
    public boolean appliesTo(Order order) {
        return order.getCouponType() == CouponType.LOYALTY;
    }

    @Override
    public double discount(double base, Order order) {
        return base >= 200.0 ? 30.0 : 10.0;
    }
}

