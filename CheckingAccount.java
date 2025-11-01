import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    private double balance;

    public CheckingAccount() { this(0.0); }
    public CheckingAccount(double opening) { this.balance = opening; }

    public double getBalance() { return balance; }
    public void setBalance(double v) { balance = v; }

    @Override
    public String menu() {
        return "=== Checking Account ===\n"
             + "1) Deposit\n"
             + "2) Withdraw\n"
             + "3) Show balance\n"
             + "0) Back\n"
             + "Select: ";
    }

    @Override
    public void start() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(menu());
            int choice = in.nextInt();

            if (choice == 0) return;

            if (choice == 1) {
                System.out.printf("Current balance: $%.2f%n", balance);
                System.out.print("Enter deposit amount: ");
                double amount = in.nextDouble();
                balance += amount;
                System.out.printf("New balance: $%.2f%n%n", balance);

            } else if (choice == 2) {
                System.out.printf("Current balance: $%.2f%n", balance);
                System.out.print("Enter withdrawal amount: ");
                double amount = in.nextDouble();
                if (amount > balance) {
                    System.out.println("Insufficient funds.\n");
                } else {
                    balance -= amount;
                    System.out.printf("New balance: $%.2f%n%n", balance);
                }

            } else if (choice == 3) {
                System.out.printf("Your balance: $%.2f%n%n", balance);

            } else {
                System.out.println("Invalid choice.\n");
            }
        }
    }


    public static void main(String[] args) {
        new CheckingAccount(100).start();
    }
}
