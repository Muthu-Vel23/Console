import java.util.*;
public class Admin {
  private HashMap<Integer, Book> books;
  public Admin(HashMap<Integer, Book> books){
    this.books = books;
  }
  private void addBook(){
    Scanner in=new Scanner(System.in);
    System.out.println("Enter Book ID:");
    int bookId=in.nextInt();
    System.out.println("Enter Book Name:");
    String bookName=in.next();
    System.out.println("Enter Book Author:");
    String bookAuthor=in.next();
    System.out.println("Enter Book Details");
    String bookDetails=in.next();
    System.out.println("Enter Book Quantity:");
    int bookQuantity=in.nextInt();
    books.put(bookId, new Book(bookId, bookName, bookAuthor, bookDetails, bookQuantity));
    System.out.println("Book Added Successfully");
  }
  private void viewBooks(){
    if(books.size()==0){
      System.out.println("No Books Available");
    }else{
      for(Map.Entry<Integer, Book> entry : books.entrySet()){
        System.out.println("Book ID: "+entry.getKey());
        System.out.println("Book Name: "+entry.getValue().name);
        System.out.println("Book Author: "+entry.getValue().author);
        System.out.println("Book Details: "+entry.getValue().details);
        System.out.println("Book Quantity: "+entry.getValue().quantity);
        System.out.println("-----------------------------");
      }
    }
  }
  private void deleteBook(){
    Scanner in=new Scanner(System.in);
    System.out.println("Enter Book ID to Delete:");
    int bookId=in.nextInt();
    if(books.containsKey(bookId)){
      books.remove(bookId);
      System.out.println("Book Deleted Successfully");
    }else{
      System.out.println("Book Not Found");
    }
  }

  public void accessAddBook(){
    addBook();
  }
  public void accessViewBooks(){
    viewBooks();
  }
  public void accessDeleteBook(){
    deleteBook(); 
  }
  
}
