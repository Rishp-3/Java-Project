import java.time.LocalTime;
import java.time.Duration;

public class LocalTimeDemo {
    public static void main(String[] args) {

        // LocalTime represents a time of day WITHOUT a date or timezone
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);

        LocalTime specificTime = LocalTime.of(14, 30, 0); // 2:30 PM
        System.out.println("Specific time: " + specificTime);

        LocalTime parsed = LocalTime.parse("09:15:30");
        System.out.println("Parsed time: " + parsed);

        // Time arithmetic
        System.out.println("Plus 2 hours: " + specificTime.plusHours(2));
        System.out.println("Minus 45 minutes: " + specificTime.minusMinutes(45));

        // Comparing times
        System.out.println("Is specificTime before now? " + specificTime.isBefore(now));

        // Extracting fields
        System.out.println("Hour: " + specificTime.getHour());
        System.out.println("Minute: " + specificTime.getMinute());

        // Duration between two times
        Duration duration = Duration.between(specificTime, now);
        System.out.println("Duration until now: " + duration.toMinutes() + " minutes (approx)");
    }
}
