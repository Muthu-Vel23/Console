import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        Admin admin = new Admin(products);
        Customer customer = new Customer("user@gmail.com", "1234");

        while (true) {
            System.out.println("\n1. Admin Login\n2. Customer Login\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (admin.login(sc)) {
                        while (true) {
                            System.out.println("\n--- Admin Menu ---");
                            System.out.println("1. Add Product");
                            System.out.println("2. View Products");
                            System.out.println("3. Back");

                            int ch = sc.nextInt();

                            if (ch == 1)
                                admin.addProduct(sc);
                            else if (ch == 2)
                                admin.viewProducts();
                            else
                                break;
                        }
                    } else {
                        System.out.println("❌ Invalid Admin Login");
                    }
                    break;

                case 2:
                    if (customer.login(sc)) {
                        while (true) {
                            System.out.println("\n--- Customer Menu ---");
                            System.out.println("1. View Products");
                            System.out.println("2. Add to Cart");
                            System.out.println("3. View Cart");
                            System.out.println("4. Checkout");
                            System.out.println("5. Purchase History");
                            System.out.println("6. Back");

                            int ch = sc.nextInt();

                            if (ch == 1)
                                customer.viewProducts(products);
                            else if (ch == 2)
                                customer.addToCart(products, sc);
                            else if (ch == 3)
                                customer.viewCart();
                            else if (ch == 4)
                                customer.checkout();
                            else if (ch == 5)
                                customer.viewHistory();
                            else
                                break;
                        }
                    } else {
                        System.out.println("❌ Invalid Customer Login");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}