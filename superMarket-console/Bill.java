import java.util.Date;

public class Bill {
    private static int counter = 1;
    private int billId;
    private double amount;
    private Date date;

    public Bill(double amount) {
        this.billId = counter++;
        this.amount = amount;
        this.date = new Date();
    }

    public String toString() {
        return "Bill ID: " + billId + " | ₹" + amount + " | " + date;
    }
}