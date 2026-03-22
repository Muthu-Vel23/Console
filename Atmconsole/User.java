public class User {
    private int userId;
    private String userName;
    private int userPin;
    private int balance;

    User(int userId, String name, int pin, int balance) {
        this.userId = userId;
        this.userName = name;
        this.userPin = pin;
        this.balance = balance;
    }
    public boolean login(int pin) {
        return this.userPin == pin;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful!");
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: ₹" + balance);
    }

    public void changePin(int newPin) {
        this.userPin = newPin;
        System.out.println("PIN changed successfully!");
    }
    public int getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public int getBalance() {
        return balance;
    }
}