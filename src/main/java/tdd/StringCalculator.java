package tdd;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isBlank()) return 0;

        String[] tokens = numbers.split("[,\n]");

        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String t : tokens) {
            if (t.isBlank()) continue;
            int v = Integer.parseInt(t.trim());
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

    // Interfejs terminalowy
    public static void main(String[] args) {
        System.out.println("=== TDD demo: StringCalculator ===");
        System.out.println("Wpisz ciąg liczb rozdzielonych przecinkiem lub nową linią (np. \"1,2,3\" lub \"1\n2,3\"). Ctrl+D aby zakończyć:");
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

