package solid;

/*
 Cel ćwiczenia:
 Obecnie: rozbudowany if-else/switch zależny od typu klienta i kuponu.
 Zadanie: Zastąpić rozgałęzienia strategią
*/
public class DiscountCalculator {

    public double calculate(Order order) {
        double base = order.getAmount();
        double discount = 0.0;

        // Zniżki zależne od klienta
        if (order.getCustomerType() == CustomerType.PREMIUM) {
            discount += base * 0.10;
        } else if (order.getCustomerType() == CustomerType.VIP) {
            discount += base * 0.15;
        } else {
            // STANDARD
        }

        // Kupony
        switch (order.getCouponType()) {
            case SEASONAL:
                discount += 20.0;
                break;
            case LOYALTY:
                discount += base >= 200 ? 30.0 : 10.0;
                break;
            case NONE:
            default:
                break;
        }

        // Minimalna cena nie może spaść poniżej 0
        double finalPrice = base - discount;
        if (finalPrice < 0) finalPrice = 0;

        return round2(finalPrice);
    }

    private double round2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

}

