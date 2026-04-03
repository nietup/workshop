package tdd;

import common.TestRunner;

public class StringCalculatorTests {
    public static void main(String[] args) {
        TestRunner tr = new TestRunner();
        StringCalculator calc = new StringCalculator();

        tr.run("empty returns 0", () -> {
            TestRunner.assertEquals(0, calc.add(""));
            TestRunner.assertEquals(0, calc.add(null));
            TestRunner.assertEquals(0, calc.add("   "));
        });

        tr.run("single number", () -> {
            TestRunner.assertEquals(5, calc.add("5"));
            TestRunner.assertEquals(42, calc.add("42"));
        });

        tr.run("two numbers comma separated", () -> {
            TestRunner.assertEquals(3, calc.add("1,2"));
            TestRunner.assertEquals(7, calc.add("3,4"));
        });

        tr.run("newline as separator and mix", () -> {
            TestRunner.assertEquals(6, calc.add("1\n2,3"));
            TestRunner.assertEquals(10, calc.add("1\n2\n3,4"));
        });

        tr.run("ignore numbers greater than 1000", () -> {
            TestRunner.assertEquals(2, calc.add("2,1001"));
            TestRunner.assertEquals(1002, calc.add("2,1000"));
        });

        tr.run("negatives throw with list", () -> {
            boolean thrown = false;
            try {
                calc.add("1,-2,3,-5");
            } catch (IllegalArgumentException e) {
                thrown = e.getMessage().contains("[-2, -5]");
            }
            TestRunner.assertEquals(true, thrown);
        });

        tr.summary();
    }
}

