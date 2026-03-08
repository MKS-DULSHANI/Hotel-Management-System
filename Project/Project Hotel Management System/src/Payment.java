import java.text.DecimalFormat;
import java.util.Scanner;

class Payment {
    private int paymentId;
    private int bookingId;
    private double amountPaid;
    private String paymentDate;
    private String paymentMethod;

    public Payment(int paymentId, int bookingId, double amountPaid, String paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Generate payment receipt with improved formatting
    public void generatePaymentReceipt() {
        DecimalFormat df = new DecimalFormat("#,###.00"); // To format the amount to two decimal places
        System.out.println("\n--- Payment Receipt ---");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Amount Paid: Rs. " + df.format(amountPaid));
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("-----------------------\n");
    }

    // Optional: Method to validate payment amount
    public boolean isValidAmount() {
        return amountPaid > 0;
    }

    // Abstract class for Payment Method
    abstract class PaymentMethod {
        protected String paymentMethod;
        protected double amountPaid;

        public PaymentMethod(String paymentMethod, double amountPaid) {
            this.paymentMethod = paymentMethod;
            this.amountPaid = amountPaid;
        }

        public abstract void processPayment();

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public double getAmountPaid() {
            return amountPaid;
        }
    }

    // CreditCardPayment class
    class CreditCardPayment extends PaymentMethod {
        public CreditCardPayment(double amountPaid) {
            super("Credit Card", amountPaid);
        }

        @Override
        public void processPayment() {
            System.out.println("Processing payment through Credit Card...");
            // Add credit card payment logic here
            System.out.println("Amount Paid: Rs. " + amountPaid);
        }
    }

    // CashPayment class
    class CashPayment extends PaymentMethod {
        public CashPayment(double amountPaid) {
            super("Cash", amountPaid);
        }

        @Override
        public void processPayment() {
            System.out.println("Processing payment through Cash...");
            // Add cash payment logic here
            System.out.println("Amount Paid: Rs." + amountPaid);
        }
    }

    // Method to process the payment
    public static PaymentMethod selectPaymentMethod(Scanner scanner, double amountPaid) {
        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        PaymentMethod paymentMethod = null;
        if (choice == 1) {
            paymentMethod = new Payment(0, 0, amountPaid, "", "Credit Card").new CreditCardPayment(amountPaid);
        } else if (choice == 2) {
            paymentMethod = new Payment(0, 0, amountPaid, "", "Cash").new CashPayment(amountPaid);
        }

        if (paymentMethod != null) {
            paymentMethod.processPayment();
        } else {
            System.out.println("Invalid payment method.");
        }

        return paymentMethod;
    }
}
