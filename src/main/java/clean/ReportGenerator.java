package clean;

import java.util.ArrayList;
import java.util.List;

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

        StringBuilder sb = new StringBuilder();
        sb.append(header).append("\n")
          .append(labels.sales).append(": ").append(totals.sales).append("\n")
          .append(labels.returns).append(": ").append(totals.returns).append("\n")
          .append(labels.net).append(": ").append(totals.net());
        return sb.toString();
    }

    private List<Entry> parseEntries(String raw) {
        String[] tokens = raw.split(";");
        List<Entry> entries = new ArrayList<>();
        for (String token : tokens) {
            String t = token.trim();
            if (t.isEmpty() || !t.contains(":")) continue;
            String[] kv = t.split(":");
            if (kv.length < 2) continue;
            String key = kv[0].trim();
            String val = kv[1].trim();
            try {
                int amount = Integer.parseInt(val);
                entries.add(new Entry(normalizeType(key), amount));
            } catch (NumberFormatException ignore) {
                // ignorujemy błędne rekordy
            }
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

    private static final class Entry {
        final String type;
        final int amount;
        Entry(String type, int amount) { this.type = type; this.amount = amount; }
    }

    private static final class Totals {
        final int sales;
        final int returns;
        Totals(int sales, int returns) { this.sales = sales; this.returns = returns; }
        int net() { return sales - returns; }
    }

    private static final class Labels {
        final String sales;
        final String returns;
        final String net;
        Labels(String sales, String returns, String net) {
            this.sales = sales; this.returns = returns; this.net = net;
        }
    }
}
