package solid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;
import java.util.Scanner;

/*
 Wejście/wyjście z terminala:

Podaj kwotę, typ klienta (STANDARD/PREMIUM/VIP), kupon (NONE/SEASONAL/LOYALTY)

Program wyświetli finalną cenę po zniżkach.
*/
@SpringBootApplication
public class DiscountApp {
    public static void main(String[] args) {
        SpringApplication.run(DiscountApp.class, args);
    }

    @Bean
    CommandLineRunner cli(DiscountCalculator calc) {
        return args -> {
            System.out.println("=== SOLID demo: DiscountCalculator (Spring Boot) ===");
            try(Scanner sc = new Scanner(System.in)) {
                System.out.println("Podaj kwotę (np. 250.0):");
                double amount = Double.parseDouble(sc.nextLine().trim());

                System.out.println("Podaj typ klienta (STANDARD/PREMIUM/VIP):");
                CustomerType ctype = CustomerType.valueOf(
                        sc.nextLine().trim().toUpperCase(Locale.ROOT));

                System.out.println("Podaj kupon (NONE/SEASONAL/LOYALTY):");
                CouponType coupon = CouponType.valueOf(
                        sc.nextLine().trim().toUpperCase(Locale.ROOT));

                Order order = new Order(amount, ctype, coupon);
                double price = calc.calculate(order);
                System.out.println("Cena po zniżkach: " + price);
            } catch (Exception e) {
                System.out.println("Błąd: " + e.getMessage());
            }
        };
    }
}
