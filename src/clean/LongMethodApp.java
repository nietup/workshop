package clean;

import java.util.Scanner;

public class LongMethodApp {
    public static void main(String[] args) {
        System.out.println("=== Clean Code demo: ReportGenerator (wejście z terminala) ===");
        System.out.println("Podaj wpisy sprzedaży w formacie: SALES:100;RETURN:20;SALES:50");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println("Podaj strefę (np. CET/UTC), oraz locale (np. PL/EN):");
        String tz = sc.next();
        String loc = sc.next();
        ReportGenerator gen = new ReportGenerator();
        String report = gen.generateReport(line, tz, loc);
        System.out.println("Wynik raportu:");
        System.out.println(report);
    }
}