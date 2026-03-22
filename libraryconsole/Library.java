import java.util.*;
class Library {
  public static void main(String args[]) {

    Scanner in = new Scanner(System.in);
    HashMap<Integer, Book> books = new HashMap<>();

    Admin admin = new Admin(books);
    User user = new User(books);

    int choice;
    do {
        System.out.println("\n===== Library System =====");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");

        choice = in.nextInt();
        switch (choice) {

          //  ADMIN
          case 1:
              System.out.println("------Admin Login------");
              System.out.print("Enter Admin Name: ");
              String adminName = in.next();

              System.out.print("Enter Admin Password: ");
              String adminPassword = in.next();

              if (adminName.equals("admin") && adminPassword.equals("admin123")) {

                  int adminChoice;
                  do {
                      System.out.println("\n--- Admin Menu ---");
                      System.out.println("1. Add Book");
                      System.out.println("2. View Books");
                      System.out.println("3. Delete Book");
                      System.out.println("4. Logout");

                      adminChoice = in.nextInt();

                      switch (adminChoice) {
                          case 1:
                              admin.accessAddBook();
                              break;
                          case 2:
                              admin.accessViewBooks();
                              break;
                          case 3:
                              admin.accessDeleteBook();
                              break;
                          case 4:
                              System.out.println("Logging out...");
                              break;
                          default:
                              System.out.println("Invalid choice");
                      }

                  } while (adminChoice != 4);

              } else {
                  System.out.println("Invalid Admin Login");
              }
              break;

          //  USER
          case 2:
              System.out.println("------User Login------");
              System.out.print("Enter User Name: ");
              String userName = in.next();

              System.out.print("Enter User Password: ");
              String userPassword = in.next();

              if (userName.equals("user") && userPassword.equals("user123")) {

                  int userChoice;
                  do {
                      System.out.println("\n--- User Menu ---");
                      System.out.println("1. View Books");
                      System.out.println("2. Borrow Book");
                      System.out.println("3. Return Book");
                      System.out.println("4. Logout");

                      userChoice = in.nextInt();

                      switch (userChoice) {
                          case 1:
                              user.viewBooks();
                              break;
                          case 2:
                              user.borrowBook();
                              break;
                          case 3:
                              user.returnBook();
                              break;
                          case 4:
                              System.out.println("Logging out...");
                              break;
                          default:
                              System.out.println("Invalid choice");
                      }

                  } while (userChoice != 4);

              } else {
                  System.out.println("Invalid User Login");
              }
              break;

          case 3:
              System.out.println("Exiting system...");
              break;

          default:
              System.out.println("Invalid choice");
      }

  } while (choice != 3);

  in.close();
  }
}