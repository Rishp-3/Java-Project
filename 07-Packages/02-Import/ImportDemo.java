// import brings classes from other packages into scope.
import java.util.ArrayList;   // single class import
import java.util.List;
import java.util.*;           // wildcard import - brings in all classes from java.util
import java.time.LocalDate;   // import from a different package entirely

public class ImportDemo {
    public static void main(String[] args) {

        // Using ArrayList and List after importing them
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        System.out.println("Fruits: " + fruits);

        // Using HashMap from the wildcard import
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Rishabh", 22);
        System.out.println("Ages: " + ages);

        // Using LocalDate from java.time
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);

        // Fully qualified name - used WITHOUT an import, when there's a naming clash
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        System.out.println("SQL date (fully qualified, no import needed): " + sqlDate);
    }
}
