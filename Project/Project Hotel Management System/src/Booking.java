import java.util.Scanner;

abstract class Booking {
    protected int bookingId;
    protected int guestId;
    protected Room room;
    protected String checkInDate;
    protected String checkOutDate;
    protected double totalAmount;
    private boolean isCompleted;

    public Booking(int bookingId, int guestId, Room room, String checkInDate, String checkOutDate) {
        this.bookingId = bookingId;
        this.guestId = guestId;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = room.getPrice();
        this.isCompleted = false;
    }

    public abstract void calculateTotalAmount();

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeBooking() {
        if (!isCompleted) {
            isCompleted = true;
            System.out.println("Booking ID " + bookingId + " has been completed.");
        } else {
            System.out.println("Booking ID " + bookingId + " is already completed.");
        }
    }

    public abstract void showBookingDetails();
}
class StandardBooking extends Booking {
    public StandardBooking(int bookingId, int guestId, Room room, String checkInDate, String checkOutDate) {
        super(bookingId, guestId, room, checkInDate, checkOutDate);
    }

    @Override
    public void calculateTotalAmount() {
        this.totalAmount = room.getPrice();
    }

    @Override
    public void showBookingDetails() {
        System.out.println("Standard Booking - Booking ID: " + bookingId + ", Room Type: " + room.getRoomType() + ", Price: Rs. " + totalAmount);
    }
}