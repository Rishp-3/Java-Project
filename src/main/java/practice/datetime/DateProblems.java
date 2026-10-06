package practice.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/** Module 13 - Date & Time: LocalDate, Period, ChronoUnit, DateTimeFormatter. */
public final class DateProblems {
    private DateProblems() {}

    /** Problem 1: whole days between two dates (negative if end is before start). */
    public static long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    /** Problem 2: age in complete years on a given day. */
    public static int ageOn(LocalDate birthDate, LocalDate today) {
        return Period.between(birthDate, today).getYears();
    }

    /** Problem 3: is this day a Saturday or Sunday? */
    public static boolean isWeekend(LocalDate date) {
        DayOfWeek d = date.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }

    /** Problem 4: add business days, skipping weekends. */
    public static LocalDate addBusinessDays(LocalDate start, int days) {
        LocalDate d = start;
        int added = 0;
        while (added < days) {
            d = d.plusDays(1);
            if (!isWeekend(d)) added++;
        }
        return d;
    }

    /** Problem 5: format as "05 Oct 2026". */
    public static String pretty(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH));
    }

    /** Problem 6: parse "dd/MM/yyyy" text and reject impossible dates such as 31/02/2026. */
    public static LocalDate parseDayFirst(String text) {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(java.time.format.ResolverStyle.STRICT));
    }

    /** Problem 7: last day of the month containing the date. */
    public static LocalDate endOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }
}
