import java.util.*;

public class Admin {

    private String email = "admin@gmail.com";
    private String password = "1234";
    private List<Product> products;

    public Admin(List<Product> products) {
        this.products = products;
    }

    public boolean login(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter Email: ");
        String e = sc.nextLine();

        System.out.print("Enter Password: ");
        String p = sc.nextLine();

        return e.equals(email) && p.equals(password);
    }

    public void addProduct(Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        products.add(new Product(id, name, price, qty));
        System.out.println("Product Added");
    }

    public void viewProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}