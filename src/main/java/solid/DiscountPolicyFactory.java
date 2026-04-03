package solid;

import solid.coupon.LoyaltyCouponDiscount;
import solid.coupon.NoneCouponDiscount;
import solid.coupon.SeasonalCouponDiscount;
import solid.customer.PremiumCustomerDiscount;
import solid.customer.StandardCustomerDiscount;
import solid.customer.VipCustomerDiscount;

public class DiscountPolicyFactory {

    public DiscountPolicy forOrder(Order order) {
        DiscountPolicy customer = customerPolicy(order);
        DiscountPolicy coupon = couponPolicy(order);
        return new CombinedDiscountPolicy(customer, coupon);
    }

    private DiscountPolicy customerPolicy(Order order) {
        switch (order.getCustomerType()) {
            case PREMIUM: return new PremiumCustomerDiscount();
            case VIP: return new VipCustomerDiscount();
            case STANDARD:
            default: return new StandardCustomerDiscount();
        }
    }

    private DiscountPolicy couponPolicy(Order order) {
        switch (order.getCouponType()) {
            case SEASONAL: return new SeasonalCouponDiscount();
            case LOYALTY: return new LoyaltyCouponDiscount();
            case NONE:
            default: return new NoneCouponDiscount();
        }
    }
}

