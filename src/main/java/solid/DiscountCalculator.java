package solid;

/*
 Cel ćwiczenia:
 Obecnie: rozbudowany if-else/switch zależny od typu klienta i kuponu.
 Zadanie: Zastąpić rozgałęzienia strategią

 Podpowiedź - stwórz interfejs DiscountPolicy:
 ```
 public interface DiscountPolicy {
    boolean appliesTo(Order order);
    double discount(double base);
 }
 ```
*/

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiscountCalculator {

    private final List<DiscountPolicy> policies;

    public DiscountCalculator(List<DiscountPolicy> policies) {
        this.policies = policies;
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

