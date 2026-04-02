package solid;

public class Order {
    private final double amount;
    private final CustomerType customerType;
    private final CouponType couponType;

    public Order(double amount, CustomerType customerType, CouponType couponType) {
        this.amount = amount;
        this.customerType = customerType;
        this.couponType = couponType;
    }

    public double getAmount() { return amount; }
    public CustomerType getCustomerType() { return customerType; }
    public CouponType getCouponType() { return couponType; }
}