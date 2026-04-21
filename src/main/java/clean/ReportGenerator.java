package clean;

import java.util.ArrayList;
import java.util.List;

/*
 Cel ćwiczenia:

 Klasa zawiera długą metodę do refaktoryzacji (Extract Method, lepsze nazewnictwo, stałe zamiast magicznych liczb,
 guard clauses, wydzielenie Parameter Object dla ustawień raportu itp).
 Utrzymaj zachowanie (uruchom LongMethodApp i testuj ręcznie).
  Wejście: "SALES:100;RETURN:20;SALES:50"
  Parametry: timezone (np. "UTC"), locale (np. "PL" / "EN")
  Wyjście: Tekst raportu z sumami.
*/
public class ReportGenerator {

    private static final String TYPE_SALES = "SALES";
    private static final String TYPE_RETURN = "RETURN";

    public String generateReport(String raw, String timezone, String locale) {
        if (raw == null || raw.trim().isEmpty()) {
            return "EMPTY";
        }
        ReportSettings settings = new ReportSettings(timezone, locale);

        Totals totals = computeTotals(parseEntries(raw));
        String header = header(settings);
        Labels labels = labels(settings);

        return header + "\n" +
                labels.sales + ": " + totals.sales + "\n" +
                labels.returns + ": " + totals.returns + "\n" +
                labels.net + ": " + totals.net();
    }

    private List<Entry> parseEntries(String raw) {
        String[] tokens = raw.split(";");
        List<Entry> entries = new ArrayList<>();
        for (String token : tokens) {
            String t = token.trim();
            if (!t.contains(":")) continue;
            String[] kv = t.split(":");
            if (kv.length < 2) continue;
            String key = kv[0].trim();
            String val = kv[1].trim();
            int amount = Integer.parseInt(val);
            entries.add(new Entry(normalizeType(key), amount));
        }
        return entries;
    }

    private String normalizeType(String key) {
        String k = key.trim();
        if (TYPE_SALES.equalsIgnoreCase(k) || "sprzedaz".equalsIgnoreCase(k) || "sale".equalsIgnoreCase(k)) {
            return TYPE_SALES;
        }
        if (TYPE_RETURN.equalsIgnoreCase(k)) {
            return TYPE_RETURN;
        }
        return "UNKNOWN";
    }

    private Totals computeTotals(List<Entry> entries) {
        int sales = 0;
        int returns = 0;
        for (Entry e : entries) {
            if (TYPE_SALES.equals(e.type)) sales += e.amount;
            else if (TYPE_RETURN.equals(e.type)) returns += e.amount;
        }
        return new Totals(sales, returns);
    }

    private String header(ReportSettings settings) {
        String tz = settings.tzInfoTag();
        switch (settings.language()) {
            case PL: return "Raport Sprzedaży " + tz;
            case EN:
            default: return "Sales Report " + tz;
        }
    }

    private Labels labels(ReportSettings settings) {
        switch (settings.language()) {
            case PL: return new Labels("Sprzedaż", "Zwroty", "Wynik netto");
            case EN:
            default: return new Labels("Sales", "Returns", "Net");
        }
    }

    private record Entry(String type, int amount) {
    }

    private record Totals(int sales, int returns) {
        int net() {
            return sales - returns;
        }
    }

    private record Labels(String sales, String returns, String net) {
    }
}
