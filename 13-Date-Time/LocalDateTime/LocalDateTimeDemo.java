import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeDemo {
    public static void main(String[] args) {

        // LocalDateTime combines a date AND a time, still without a timezone
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now);

        LocalDateTime specific = LocalDateTime.of(2025, Month.JUNE, 15, 10, 30);
        System.out.println("Specific: " + specific);

        LocalDateTime parsed = LocalDateTime.parse("2025-03-10T08:00:00");
        System.out.println("Parsed: " + parsed);

        // Arithmetic
        System.out.println("Plus 3 days: " + now.plusDays(3));
        System.out.println("Plus 5 hours: " + now.plusHours(5));
        System.out.println("Minus 30 minutes: " + now.minusMinutes(30));

        // Extracting date/time parts
        System.out.println("Date part: " + now.toLocalDate());
        System.out.println("Time part: " + now.toLocalTime());

        System.out.println("Is specific before now? " + specific.isBefore(now));
    }
}
