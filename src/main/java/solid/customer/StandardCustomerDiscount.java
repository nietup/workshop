package solid.customer;

import org.springframework.stereotype.Component;
import solid.DiscountPolicy;
import solid.Order;
import solid.CustomerType;

@Component
public class StandardCustomerDiscount implements DiscountPolicy {
    @Override
    public boolean appliesTo(Order order) {
        return order.getCustomerType() == CustomerType.STANDARD;
    }

    @Override
    public double discount(double base) {
        return 0.0;
    }
}

