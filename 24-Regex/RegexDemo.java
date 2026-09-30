import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {

        // matches() checks if the WHOLE string matches a pattern
        System.out.println("'12345'.matches(\"\\\\d+\"): " + "12345".matches("\\d+"));
        System.out.println("'abc123'.matches(\"\\\\d+\"): " + "abc123".matches("\\d+"));

        // Common regex patterns
        String emailRegex = "^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        System.out.println("Valid email: " + "test@example.com".matches(emailRegex));
        System.out.println("Invalid email: " + "not-an-email".matches(emailRegex));

        String phoneRegex = "^\\d{10}$";
        System.out.println("Valid phone: " + "9876543210".matches(phoneRegex));

        // Pattern + Matcher for more control (finding, replacing, extracting groups)
        Pattern pattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})"); // e.g. 123-456-7890
        Matcher matcher = pattern.matcher("Call me at 123-456-7890 or 987-654-3210.");

        while (matcher.find()) {
            System.out.println("Found phone number: " + matcher.group());
            System.out.println("  Area code: " + matcher.group(1));
        }

        // Replacing text using regex
        String text = "The rain in Spain falls mainly on the plain";
        String replaced = text.replaceAll("ain", "AIN");
        System.out.println("After replaceAll: " + replaced);

        // Splitting using regex
        String csv = "apple,  banana ,cherry,   date";
        String[] parts = csv.split("\\s*,\\s*"); // splits on comma, trims surrounding spaces
        System.out.println("Split result: " + java.util.Arrays.toString(parts));

        // Validating a password (min 8 chars, at least one digit, one letter)
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$";
        System.out.println("'abc12345' is a valid password: " + "abc12345".matches(passwordRegex));
        System.out.println("'short1' is a valid password: " + "short1".matches(passwordRegex));
    }
}
