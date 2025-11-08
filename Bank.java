import java.util.ArrayList;
import java.util.Scanner;

public class Bank implements HasMenu {

    private Admin admin;
    private ArrayList<Customer> customers;

    public Bank() {
        admin = new Admin();          
        customers = new ArrayList<>();
        loadSampleCustomers();       
    }

    
    @Override
    public String menu() {
        return "\nBank Menu\n"
             + "0) Exit system\n"
             + "1) Login as admin\n"
             + "2) Login as customer\n"
             + "Select: ";
    }

    @Override
    public void start() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print(menu());         
            int choice = in.nextInt();        
            in.nextLine();                    

            if (choice == 0) {
                System.out.println("Exiting system...");
                break;

            } else if (choice == 1) {
                System.out.println("Logging in admin system...");
                if (admin.login()) {
                    System.out.println("Admin login successful.");
                    startAdmin();             
                } else {
                    System.out.println("Admin login failed.");
                }

            } else if (choice == 2) {
                loginAsCustomer();            

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

   
    private void loadSampleCustomers() {
        customers.add(new Customer("Tommy", "1111"));
        customers.add(new Customer("Bob", "2222"));
        customers.add(new Customer("Cindy", "3333"));
    }

    
    private void startAdmin() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print(admin.menu());
            int c = in.nextInt();
            in.nextLine();

            if (c == 0) {
                break;
            } else if (c == 1) {
                fullCustomerReport();
            } else if (c == 2) {
                addUser();
            } else if (c == 3) {
                applyInterest();
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

  
    private void loginAsCustomer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String name = in.nextLine();
        System.out.print("Enter PIN: ");
        String pin = in.nextLine();

        Customer current = null;
        for (Customer c : customers) {
            if (c.login(name, pin)) {   
                current = c;
                break;
            }
        }

        if (current != null) {
            System.out.println("Login successful. Welcome, " + name + "!");
            current.start();            
        } else {
            System.out.println("Login failed.");
        }
    }

   
    private void fullCustomerReport() {
        System.out.println("\nFull Customer Report:");
        for (Customer c : customers) {
            System.out.println(c.getReport());
        }
    }

    
    private void addUser() {
        Scanner in = new Scanner(System.in);
        System.out.print("New user name: ");
        String name = in.nextLine();
        System.out.print("PIN: ");
        String pin = in.nextLine();

        customers.add(new Customer(name, pin));
        System.out.println("Customer " + name + " added.");
    }

    
    private void applyInterest() {
        System.out.println("Applying interest to all savings accounts...");
        for (Customer c : customers) {
            
            c.getSavingsAccount().calcInterest();
        }
        System.out.println("Done.");
    }

    
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();
    }
}
