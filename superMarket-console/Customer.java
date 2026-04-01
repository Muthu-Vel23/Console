import java.util.*;

public class Customer {

    private String email;
    private String password;
    private double credit = 1000;

    private List<CartItem> cart = new ArrayList<>();
    private List<Bill> history = new ArrayList<>();

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean login(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter Email: ");
        String e = sc.nextLine();

        System.out.print("Enter Password: ");
        String p = sc.nextLine();

        return e.equals(email) && p.equals(password);
    }

    public void viewProducts(List<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void addToCart(List<Product> products, Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.getId() == id) {
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                if (qty <= p.getQuantity()) {
                    cart.add(new CartItem(p, qty));
                    System.out.println("Added to cart");
                } else {
                    System.out.println("Not enough stock");
                }
                return;
            }
        }
        System.out.println("Product not found");
    }

    public double viewCart() {
        double total = 0;

        for (CartItem item : cart) {
            double cost = item.getProduct().getPrice() * item.getQuantity();
            total += cost;
            System.out.println(item);
        }

        System.out.println("Total = ₹" + total);
        return total;
    }

    public void checkout() {
        double total = viewCart();

        if (total > credit) {
            System.out.println("Not enough credit");
            return;
        }

        credit -= total;

        history.add(new Bill(total));

        System.out.println("Payment Successful");
        System.out.println("Remaining Credit: ₹" + credit);

        cart.clear();
    }

    public void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("No purchases yet.");
            return;
        }

        for (Bill b : history) {
            System.out.println(b);
        }
    }
}