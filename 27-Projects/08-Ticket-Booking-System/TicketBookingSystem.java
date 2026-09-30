import java.util.*;

// A console-based Ticket Booking System: view seats, book, cancel.
public class TicketBookingSystem {

    static final int TOTAL_SEATS = 10;
    static boolean[] seats = new boolean[TOTAL_SEATS]; // false = available, true = booked
    static String[] bookedBy = new String[TOTAL_SEATS];
    static Scanner sc = new Scanner(System.in);

    static void viewSeats() {
        System.out.println("Seat layout (X = booked, O = available):");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print("Seat " + (i + 1) + ": " + (seats[i] ? "X" : "O") + "   ");
            if ((i + 1) % 5 == 0) System.out.println();
        }
        System.out.println();
    }

    static void bookSeat() {
        viewSeats();
        System.out.print("Enter seat number to book (1-" + TOTAL_SEATS + "): ");
        int seatNo = Integer.parseInt(sc.nextLine().trim());

        if (seatNo < 1 || seatNo > TOTAL_SEATS) {
            System.out.println("Invalid seat number.");
            return;
        }
        int index = seatNo - 1;
        if (seats[index]) {
            System.out.println("Seat already booked!");
            return;
        }

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        seats[index] = true;
        bookedBy[index] = name;
        System.out.println("Seat " + seatNo + " booked successfully for " + name + "!");
    }

    static void cancelSeat() {
        System.out.print("Enter seat number to cancel (1-" + TOTAL_SEATS + "): ");
        int seatNo = Integer.parseInt(sc.nextLine().trim());

        if (seatNo < 1 || seatNo > TOTAL_SEATS) {
            System.out.println("Invalid seat number.");
            return;
        }
        int index = seatNo - 1;
        if (!seats[index]) {
            System.out.println("This seat isn't booked.");
            return;
        }

        System.out.println("Booking for " + bookedBy[index] + " on seat " + seatNo + " cancelled.");
        seats[index] = false;
        bookedBy[index] = null;
    }

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Movie Ticket Booking System ===");

        while (running) {
            System.out.println("\n1. View Seats\n2. Book Seat\n3. Cancel Booking\n4. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> viewSeats();
                case "2" -> bookSeat();
                case "3" -> cancelSeat();
                case "4" -> { running = false; System.out.println("Thank you for visiting!"); }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
