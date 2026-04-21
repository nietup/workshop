package tdd;

import java.util.ArrayList;
import java.util.List;

/*
 String Calculator Kata (TDD)
 Zaimplementuj metodę add(String numbers) krokami TDD.
 Zacznij od najprostszej implementacji i refaktoryzuj po każdym zielonym teście.

 To do:
 [x] Pusta wartość -> 0
 [x] Pojedyncza liczba -> sama liczba
 [x] Dwie liczby rozdzielone przecinkiem -> suma
 [ ] Wyjątek dla liczb ujemnych z listą liczb ujemnych w komunikacie
 [ ] Ignoruj liczby > 1000
*/
public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isBlank()) return 0;

        String[] parts = numbers.split(",");

        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String p : parts) {
            if (p.isBlank()) continue;
            int v = Integer.parseInt(p.trim());
            if (v < 0) {
                negatives.add(v);
                continue;
            }
            if (v > 1000) continue;
            sum += v;
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
        return sum;
    }

    // Prosty interfejs terminalowy dla demonstracji
    public static void main(String[] args) throws Exception {
        System.out.println("=== TDD demo: StringCalculator ===");
        System.out.println("Wpisz ciag liczb (np. \"1,2,3\" lub pusty), Ctrl+D aby zakończyć:");
        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            StringCalculator calc = new StringCalculator();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                try {
                    int result = calc.add(line);
                    System.out.println("Wynik: " + result);
                } catch (Exception e) {
                    System.out.println("Błąd: " + e.getMessage());
                }
            }
        }
    }
}

