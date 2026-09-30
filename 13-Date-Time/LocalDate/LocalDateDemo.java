import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class LocalDateDemo {
    public static void main(String[] args) {

        // LocalDate represents a date WITHOUT time or timezone (year, month, day)
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalDate specificDate = LocalDate.of(2024, Month.DECEMBER, 25);
        System.out.println("Specific date: " + specificDate);

        LocalDate parsed = LocalDate.parse("2025-01-15");
        System.out.println("Parsed date: " + parsed);

        // Date arithmetic
        System.out.println("Tomorrow: " + today.plusDays(1));
        System.out.println("Next month: " + today.plusMonths(1));
        System.out.println("Last year: " + today.minusYears(1));

        // Comparing dates
        System.out.println("Is specificDate before today? " + specificDate.isBefore(today));
        System.out.println("Is specificDate after today? " + specificDate.isAfter(today));

        // Extracting fields
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day of week: " + today.getDayOfWeek());
        System.out.println("Is leap year: " + today.isLeapYear());

        // Period between two dates
        Period period = Period.between(specificDate, today);
        System.out.println("Period between dates: " + period.getYears() + " years, " +
            period.getMonths() + " months, " + period.getDays() + " days");
    }
}
