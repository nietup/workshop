package solid;

/*
 Cel ćwiczenia:
 Obecnie: rozbudowany if-else/switch zależny od typu klienta i kuponu.
 Zadanie: Zastąpić rozgałęzienia strategią
*/

import solid.coupon.LoyaltyCouponDiscount;
import solid.coupon.NoneCouponDiscount;
import solid.coupon.SeasonalCouponDiscount;
import solid.customer.PremiumCustomerDiscount;
import solid.customer.StandardCustomerDiscount;
import solid.customer.VipCustomerDiscount;
import java.util.Arrays;
import java.util.List;

public class DiscountCalculator {

    private final List<DiscountPolicy> policies;

    public DiscountCalculator() {
        this.policies = Arrays.asList(new LoyaltyCouponDiscount(), new NoneCouponDiscount(), new SeasonalCouponDiscount(), new PremiumCustomerDiscount(), new StandardCustomerDiscount(), new VipCustomerDiscount());
    }

    public double calculate(Order order) {
        double base = order.getAmount();

        double totalDiscount = policies.stream()
                .filter(p -> p.appliesTo(order))
                .mapToDouble(p -> p.discount(base))
                .sum();

        double finalPrice = Math.max(0.0, base - totalDiscount);
        return round2(finalPrice);
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

}

