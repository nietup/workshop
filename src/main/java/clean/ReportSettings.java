package clean;

import java.util.Locale;
import java.util.Objects;

public final class ReportSettings {
    public enum Timezone { UTC, CET, OTHER, NA }
    public enum Language { PL, EN }

    private final Timezone timezone;
    private final Language language;

    public ReportSettings(String tzRaw, String localeRaw) {
        this.timezone = parseTimezone(tzRaw);
        this.language = parseLanguage(localeRaw);
    }

    private Timezone parseTimezone(String tz) {
        if (tz == null) return Timezone.NA;
        switch (tz.toUpperCase(Locale.ROOT)) {
            case "UTC": return Timezone.UTC;
            case "CET": return Timezone.CET;
            default: return Timezone.OTHER;
        }
    }

    private Language parseLanguage(String loc) {
        if (loc == null) return Language.EN;
        return "PL".equalsIgnoreCase(loc) ? Language.PL : Language.EN;
    }

    public Timezone timezone() { return timezone; }
    public Language language() { return language; }

    public String tzInfoTag() {
        switch (timezone) {
            case UTC: return "[UTC]";
            case CET: return "[CET]";
            case OTHER: return "[TZN]";
            case NA:
            default: return "[NA]";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReportSettings other)) return false;
        return timezone == other.timezone && language == other.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timezone, language);
    }
}

