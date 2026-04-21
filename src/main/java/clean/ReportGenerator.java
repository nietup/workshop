package clean;

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
    public String generateReport(String raw, String timezone, String locale) {
        if (raw == null || raw.trim().isEmpty()) {
            return "EMPTY";
        }
        String[] split = raw.split(";");
        int salesSum = 0;
        int returnSum = 0;
        for (int i = 0; i < split.length; i++) {
            String entry = split[i];
            if (entry.contains(":")) {
                String[] kv = entry.split(":");
                String key = kv[0].trim();
                String value = kv[1].trim();
                int v = 0;
                try {
                    v = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    // ignorujemy błędne rekordy
                    continue;
                }
                if (key.equals("SALES")) {
                    salesSum += v;
                } else if (key.equals("RETURN")) {
                    returnSum += v;
                } else if (key.equals("sale") || key.equals("sprzedaz")) {
                    // specjalne przypadki
                    salesSum += v;
                } else {
                    // nieznany typ
                }
            }
        }
        int net = salesSum - returnSum;
        String tzInfo = "";
        if (timezone != null) {
            if (timezone.equals("UTC")) {
                tzInfo = "[UTC]";
            } else if (timezone.equals("CET")) {
                tzInfo = "[CET]";
            } else {
                tzInfo = "[TZN]";
            }
        } else {
            tzInfo = "[NA]";
        }
        String locInfo = "";
        if (locale == null) {
            locInfo = "EN";
        } else {
            if (locale.equalsIgnoreCase("PL")) {
                locInfo = "PL";
            } else {
                locInfo = "EN";
            }
        }
        String header;
        if (locInfo.equals("PL")) {
            header = "Raport Sprzedaży " + tzInfo;
        } else {
            header = "Sales Report " + tzInfo;
        }
        String salesLabel = locInfo.equals("PL") ? "Sprzedaż" : "Sales";
        String returnLabel = locInfo.equals("PL") ? "Zwroty" : "Returns";
        String netLabel = locInfo.equals("PL") ? "Wynik netto" : "Net";

        String result = header + "\n";
        result += salesLabel + ": " + salesSum + "\n";
        result += returnLabel + ": " + returnSum + "\n";
        result += netLabel + ": " + net;
        return result;
    }
}
