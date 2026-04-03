package common;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    private final List<String> failures = new ArrayList<>();

    public void run(String name, Runnable test) {
        try {
            test.run();
            System.out.println("[OK] " + name);
        } catch (AssertionError ae) {
            System.out.println("[FAIL] " + name + " -> " + ae.getMessage());
            failures.add(name + ": " + ae.getMessage());
        } catch (Exception e) {
            System.out.println("[ERROR] " + name + " -> " + e);
            failures.add(name + ": " + e.toString());
        }
    }

    public void summary() {
        System.out.println("-----");
        if (failures.isEmpty()) {
            System.out.println("Wszystkie testy OK");
        } else {
            System.out.println("Niektóre testy nie przeszły:");
            failures.forEach(System.out::println);
            System.exit(1);
        }
    }

    // Pomocnicza asercja
    public static void assertEquals(Object expected, Object actual) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}

