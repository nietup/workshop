package tdd;

import common.TestRunner;

public class StringCalculatorTests {
    public static void main(String[] args) {
        TestRunner tr = new TestRunner();
        StringCalculator calc = new StringCalculator();

        tr.run("empty returns 0", () -> {
            TestRunner.assertEquals(0, calc.add(""));
            TestRunner.assertEquals(0, calc.add(null));
        });

        tr.run("single number", () -> {
            TestRunner.assertEquals(5, calc.add("5"));
            TestRunner.assertEquals(42, calc.add("42"));
        });

        tr.run("two numbers comma separated", () -> {
            TestRunner.assertEquals(3, calc.add("1,2"));
            TestRunner.assertEquals(7, calc.add("3,4"));
        });

        tr.run("newline as separator", () -> {
            TestRunner.assertEquals(6, calc.add("1\n2,3"));
        });

        // Kolejne testy dopisuj wg zasad kata (negative numbers, >1000, itp.)
        tr.summary();
    }
}
