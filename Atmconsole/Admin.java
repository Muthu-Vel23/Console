import java.util.HashMap;
import java.util.*;

public class Admin {
    Scanner in = new Scanner(System.in);
    private int adminPin;
    private HashMap<Integer, User> users ;    
    public Admin(int adminPin,HashMap<Integer, User> users) {
        this.adminPin = adminPin; // Default admin PIN
        this.users = users;
    }
    public boolean login(int pin) {
        return this.adminPin == pin;
    }
    private void addUser(){
      System.out.println("Enter user ID:");
      int id=in.nextInt();
      System.out.println("Enter user name:");
      String name=in.next();
      System.out.println("Enter user PIN:");
      int pin=in.nextInt();
      System.out.println("Enter the initial amount:");
      int balance=in.nextInt();
      users.put(id,new User(id,name,pin,balance));
      System.out.println("User Added");
    }
    private void removeUser(){
      System.out.println("Enter user ID to remove:");
      int id=in.nextInt();
      if(users.containsKey(id)){
        users.remove(id);
        System.out.println("User Removed");
      }else{
        System.out.println("User not found!");
      }
    }
    private void viewAllUsers(){
      if(users.isEmpty()){
        System.out.println("No users found!");
        return;
      }
      System.out.println("User ID | User Name | Balance");
      for(User user: users.values()){
        System.out.println(user.getUserId()+" | "+user.getUserName()+" | ₹"+user.getBalance());
      }
    }
    private void resetPin(){
      System.out.println("Enter user ID to reset PIN:");
      int id=in.nextInt();
      User user=users.get(id);
      if(user!=null){
        System.out.println("Enter new PIN:");
        int newPin=in.nextInt();
        user.changePin(newPin);
        System.out.println("Pin is changed successfully");
      }else{
        System.out.println("User is not found");
      }
    }  
    public void accessAdd(){
      addUser();
    }
    public void accessRemove(){
      removeUser();
    }
    public void accessView(){
      viewAllUsers();
    }
    public void accessResetPin(){
      resetPin();
    }


}
