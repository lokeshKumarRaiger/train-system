// TrainSeatBooking.java

// Import necessary packages
import java.util.*;

public class TrainSeatBooking {

    private static final int ROWS = 12;
    private static final int SEATS_IN_ROW = 7;
    private static final int TOTAL_SEATS = 80;
    private static final Map<Integer, Boolean> seats = new HashMap<>(); // seat_id -> status

    static {
        // Initialize seat availability. Assume some seats are pre-booked.
        for (int i = 1; i <= TOTAL_SEATS; i++) {
            seats.put(i, false); // false indicates available
        }
        // Example of pre-booked seats
        seats.put(10, true);
        seats.put(25, true);
        seats.put(50, true);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the number of seats to book (or -1 to exit):");
            int numSeats = scanner.nextInt();

            if (numSeats == -1) {
                break;
            }

            if (numSeats < 1 || numSeats > 7) {
                System.out.println("You can only book between 1 and 7 seats at a time.");
                continue;
            }

            List<Integer> bookedSeats = bookSeats(numSeats);

            if (bookedSeats.isEmpty()) {
                System.out.println("Sorry, not enough seats available.");
            } else {
                System.out.println("Seats booked: " + bookedSeats);
                displaySeats();
            }
        }

        scanner.close();
    }

    private static List<Integer> bookSeats(int numSeats) {
        List<Integer> bookedSeats = new ArrayList<>();

        for (int row = 1; row <= ROWS; row++) {
            int startSeat = (row - 1) * SEATS_IN_ROW + 1;
            int endSeat = row == ROWS ? TOTAL_SEATS : row * SEATS_IN_ROW;
            
            // Try to book seats in a single row
            for (int i = startSeat; i <= endSeat; i++) {
                if (!seats.get(i) && bookedSeats.size() < numSeats) {
                    bookedSeats.add(i);
                }
            }

            if (bookedSeats.size() == numSeats) {
                for (int seat : bookedSeats) {
                    seats.put(seat, true);
                }
                return bookedSeats;
            } else {
                bookedSeats.clear(); // Reset if we can't fulfill the booking in this row
            }
        }

        // Try to book nearby seats across rows
        for (int i = 1; i <= TOTAL_SEATS; i++) {
            if (!seats.get(i) && bookedSeats.size() < numSeats) {
                bookedSeats.add(i);
            }
        }

        if (bookedSeats.size() == numSeats) {
            for (int seat : bookedSeats) {
                seats.put(seat, true);
            }
        } else {
            bookedSeats.clear();
        }

        return bookedSeats;
    }

    private static void displaySeats() {
        System.out.println("\nSeat Layout:");
        for (int i = 1; i <= TOTAL_SEATS; i++) {
            System.out.print((seats.get(i) ? "[X]" : "[O]") + " ");
            if (i % SEATS_IN_ROW == 0 || i == TOTAL_SEATS) {
                System.out.println();
            }
        }
    }
}