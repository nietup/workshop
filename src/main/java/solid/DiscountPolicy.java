package solid;

public interface DiscountPolicy {
    boolean appliesTo(Order order);
    double discount(double base);
}

