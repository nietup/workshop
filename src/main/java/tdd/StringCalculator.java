package tdd;

/*
 String Calculator Kata (TDD)
 Zaimplementuj metodę add(String numbers) krokami TDD. Zasady startowe:

Pusta wartość -> 0
Pojedyncza liczba -> sama liczba
Dwie liczby rozdzielone przecinkiem -> suma
\n jako separator
Niestandardowy separator na początku: "//;<newline>1;2"
Wyjątek dla liczb ujemnych z listą liczb ujemnych w komunikacie
Ignoruj liczby > 1000
 Zacznij od najprostszej implementacji i refaktoryzuj po każdym zielonym teście.
*/
public class StringCalculator {

    public int add(String numbers) {
        // TODO: zaimplementuj iteracyjnie wg testów (na początek: zwróć 0 dla null lub "")
        if (numbers == null || numbers.isEmpty()) return 0;

        // Prosty, pierwszy krok – obsługa pojedynczej liczby lub dwóch oddzielonych przecinkiem.
        if (!numbers.contains(",") && !numbers.contains("\n")) {
            return Integer.parseInt(numbers.trim());
        }
        String[] parts = numbers.split("[,\n]");
        int sum = 0;
        for (String p : parts) {
            if (!p.isBlank()) {
                int v = Integer.parseInt(p.trim());
                sum += v;
            }
        }
        return sum;
    }

    // Prosty interfejs terminalowy dla demonstracji
    public static void main(String[] args) throws Exception {
        System.out.println("=== TDD demo: StringCalculator ===");
        System.out.println("Wpisz ciag liczb (np. \"1,2,3\" lub pusty), Ctrl+D aby zakończyć:");
        java.util.Scanner sc = new java.util.Scanner(System.in);
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

