package solid;

public interface DiscountPolicy {
    double discount(double base, Order order);
}

