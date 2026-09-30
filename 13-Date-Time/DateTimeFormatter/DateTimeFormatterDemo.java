import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Default toString: " + now);

        // Predefined formatter
        DateTimeFormatter iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println("ISO format: " + now.format(iso));

        // Custom pattern-based formatters
        DateTimeFormatter dmy = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("dd-MM-yyyy: " + now.format(dmy));

        DateTimeFormatter full = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy hh:mm:ss a");
        System.out.println("Full readable: " + now.format(full));

        DateTimeFormatter time24 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("24-hour time: " + now.format(time24));

        // Parsing a String back into a date-time using a matching formatter
        String dateString = "25-12-2024";
        java.time.LocalDate parsedDate = java.time.LocalDate.parse(dateString, dmy);
        System.out.println("Parsed back: " + parsedDate);
    }
}
