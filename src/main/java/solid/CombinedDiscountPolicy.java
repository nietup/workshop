package solid;

public class CombinedDiscountPolicy implements DiscountPolicy {
    private final DiscountPolicy customerPolicy;
    private final DiscountPolicy couponPolicy;

    public CombinedDiscountPolicy(DiscountPolicy customerPolicy, DiscountPolicy couponPolicy) {
        this.customerPolicy = customerPolicy;
        this.couponPolicy = couponPolicy;
    }

    @Override
    public double discount(double base, Order order) {
        return customerPolicy.discount(base, order) + couponPolicy.discount(base, order);
    }
}

