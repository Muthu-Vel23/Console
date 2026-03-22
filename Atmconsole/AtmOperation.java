import java.util.HashMap;
import java.util.Scanner;

public class AtmOperation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, User> users = new HashMap<>();

        users.put(1, new User(1, "ram", 123, 1000));

        Admin admin = new Admin(123456, users);

        boolean running = true;

        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your role: ");

            int role = in.nextInt();

            switch (role) {

                case 1:
                    System.out.print("Enter admin PIN: ");
                    int adminPin = in.nextInt();

                    if (!admin.login(adminPin)) {
                        System.out.println("Invalid PIN!");
                        break;
                    }

                    boolean adminMenu = true;
                    while (adminMenu) {
                        System.out.println("\n--- ADMIN MENU ---");
                        System.out.println("1. Add User");
                        System.out.println("2. Remove User");
                        System.out.println("3. View Users");
                        System.out.println("4. Reset PIN");
                        System.out.println("5. Back to Main Menu");

                        int choice = in.nextInt();

                        switch (choice) {
                            case 1: admin.accessAdd(); break;
                            case 2: admin.accessRemove(); break;
                            case 3: admin.accessView(); break;
                            case 4: admin.accessResetPin(); break;
                            case 5: adminMenu = false; break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = in.nextInt();

                    User user = users.get(userId);

                    if (user == null) {
                        System.out.println("User not found!");
                        break;
                    }

                    System.out.print("Enter PIN: ");
                    int pin = in.nextInt();

                    if (!user.login(pin)) {
                        System.out.println("Wrong PIN!");
                        break;
                    }

                    boolean userMenu = true;
                    while (userMenu) {
                        System.out.println("\n--- USER MENU ---");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Change PIN");
                        System.out.println("5. Back to Main Menu");

                        int choice = in.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.print("Amount to deposit: ");
                                user.deposit(in.nextInt());
                                break;
                            case 2:
                                System.out.print("Amount to withdraw: ");
                                user.withdraw(in.nextInt());
                                break;
                            case 3:
                                user.checkBalance();
                                break;
                            case 4:
                                System.out.print("New PIN: ");
                                user.changePin(in.nextInt());
                                break;
                            case 5:
                                userMenu = false;
                                break;
                        }
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        in.close();
    }
}