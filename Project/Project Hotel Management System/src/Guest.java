import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Guest {
    private int guestId;
    private String name;
    private String contactInfo;
    private List<Booking> bookingHistory;

    public Guest(int guestId, String name, String contactInfo) {
        this.guestId = guestId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.bookingHistory = new ArrayList<>();
    }

    public int getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void bookRoom(Booking booking) {
        bookingHistory.add(booking);
        System.out.println("Booking confirmed for " + name + " with Booking ID: " + booking.getBookingId());
    }

    public void cancelBooking(Scanner scanner) {
        System.out.print("Enter Booking ID to cancel: ");
        int bookingIdToCancel = scanner.nextInt();

        Booking bookingToCancel = null;
        for (Booking booking : bookingHistory) {
            if (booking.getBookingId() == bookingIdToCancel) {
                bookingToCancel = booking;
                break;
            }
        }

        if (bookingToCancel != null) {
            bookingHistory.remove(bookingToCancel);
            System.out.println("Booking with ID " + bookingToCancel.getBookingId() + " has been canceled.");
        } else {
            System.out.println("No such booking found to cancel.");
        }
    }

    public void viewBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println(name + " has no booking history.");
        } else {
            System.out.println("Booking History for " + name + ":");
            for (Booking booking : bookingHistory) {
                System.out.println("Booking ID: " + booking.getBookingId() + ", Room ID: " + booking.getRoom().getRoomId() + ", Total Amount: " + booking.getTotalAmount());
            }
        }
    }
}
