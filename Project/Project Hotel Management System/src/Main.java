import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Grand Plaza", "Colombo");

        // Adding rooms to the hotel
        for (int i = 1; i <= 5; i++) {
            hotel.addRoom(new Room(100 + i, 10000.0, "Single"));
            hotel.addRoom(new Room(200 + i, 15000.0, "Double"));
            hotel.addRoom(new Room(300 + i, 25000.0, " Suite"));
        }

        hotel.displayHotelInfo();

        System.out.println();
        // Guest registration
        System.out.print("Enter Guest ID: ");
        int guestId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        Guest guest = new Guest(guestId, guestName, contactInfo);

        // Room booking
        Room room = hotel.getRoomById(scanner);
        if (room == null) {
            System.out.println("Invalid Room ID. Exiting...");
            return;
        }

        System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.println();
        System.out.println("Enter Check-Out Date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();

        Booking booking = new StandardBooking(1001, guest.getGuestId(), room, checkInDate, checkOutDate);
        guest.bookRoom(booking);

        booking.showBookingDetails();

        System.out.println("Completing the booking...");
        booking.completeBooking();

        guest.viewBookingHistory();

        // Payment process
        System.out.println("\n--- Payment Process ---");
        System.out.print("Enter amount to be paid: Rs. ");
        double amountPaid = scanner.nextDouble();

        // Call the Payment class to handle payment
        Payment payment = new Payment(2001, booking.getBookingId(), amountPaid, getCurrentDate(), ""); // Assuming empty payment method for now
        Payment.PaymentMethod paymentMethod = Payment.selectPaymentMethod(scanner, amountPaid);

        // Generate payment receipt
        if (paymentMethod != null) {
            payment.generatePaymentReceipt();
        }

        // Cancel a booking
        guest.cancelBooking(scanner);
        guest.viewBookingHistory();
    }

    // Utility method to get current date as a string (e.g., YYYY-MM-DD)
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}