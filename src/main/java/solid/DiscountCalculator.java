package solid;

public class DiscountCalculator {
    private final DiscountPolicyFactory factory;

    public DiscountCalculator() {
        this.factory = new DiscountPolicyFactory();
    }

    public DiscountCalculator(DiscountPolicyFactory factory) {
        this.factory = factory;
    }

    // Zwraca kwotę po zniżce
    public double calculate(Order order) {
        double base = order.getAmount();
        DiscountPolicy policy = factory.forOrder(order);
        double discount = policy.discount(base, order);
        double finalPrice = Math.max(0.0, base - discount);
        return round2(finalPrice);
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}

