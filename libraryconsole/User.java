import java.util.*;

class User {

    private HashMap<Integer, Book> books;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private int borrowedCount = 0;

    public User(HashMap<Integer, Book> books) {
        this.books = books;
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        for (Book b : books.values()) {
            System.out.println(b.id + " | " + b.name + " | Qty: " + b.quantity);
        }
    }

    public void borrowBook() {
        Scanner in = new Scanner(System.in);

        if (borrowedCount >= 2) {
            System.out.println("You can borrow only 2 books!");
            return;
        }

        System.out.println("Enter Book ID:");
        int id = in.nextInt();

        if (!books.containsKey(id)) {
            System.out.println("Book not found");
            return;
        }

        Book b = books.get(id);

        if (b.quantity <= 0) {
            System.out.println("Book not available");
            return;
        }

        for (Book bb : borrowedBooks) {
            if (bb.id == id) {
                System.out.println("Already borrowed!");
                return;
            }
        }

        b.quantity--;
        borrowedBooks.add(b);
        borrowedCount++;

        System.out.println("Book borrowed successfully");
    }

    void returnBook() {
        Scanner in = new Scanner(System.in);

        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books");
            return;
        }

        System.out.println("Your Books:");
        for (Book b : borrowedBooks) {
            System.out.println(b.id + " | " + b.name);
        }

        System.out.println("Enter Book ID to return:");
        int id = in.nextInt();

        Iterator<Book> it = borrowedBooks.iterator();

        while (it.hasNext()) {
            Book b = it.next();

            if (b.id == id) {
                b.quantity++;
                borrowedCount--;
                it.remove();

                System.out.println("Returned successfully");
                return;
            }
        }

        System.out.println("Invalid Book ID");
    }
}