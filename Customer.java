import java.util.Scanner;

public class Customer extends User {
    private CheckingAccount checking;
    private SavingsAccount  savings;

    public Customer() {
        super("Alice", "0000");            
        this.checking = new CheckingAccount();
        this.savings  = new SavingsAccount();
    }

    public Customer(String name, String pin) {
        super(name, pin);
        this.checking = new CheckingAccount();
        this.savings  = new SavingsAccount();
    }

    @Override
    public String menu() {
        return "\nCustomer Menu\n"
             + "0) Exit\n"
             + "1) Manage Checking Account\n"
             + "2) Manage Savings Account\n"
             + "3) Change PIN\n"
             + "Select: ";
    }

    @Override
    public void start() {
       
        if (!login()) {
            System.out.println("Login failed.");
            return;
        }
        System.out.println("Login Successful\n");

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(menu());
            int c = in.nextInt();
            in.nextLine(); 

            if (c == 0) break;
            switch (c) {
                case 1:
                    System.out.println("\nChecking Account\n");
                    checking.start();
                    break;
                case 2:
                    System.out.println("\nSavings Account\n");
                    savings.start();   
                    break;
                case 3:
                    System.out.print("Enter new PIN: ");
                    String np = in.nextLine();
                    setPIN(np);
                    System.out.println("PIN changed.\n");
                    break;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    @Override
    public String getReport() {
        return String.format(
            "Customer: %s%nChecking Balance: %.2f%nSavings Balance: %.2f",
            getUserName(), checking.getBalance(), savings.getBalance()
        );
    }

    
    public static void main(String[] args) {
        new Customer().start();
    }
    public CheckingAccount getCheckingAccount() {
    return checking;
}

public SavingsAccount getSavingsAccount() {
    return savings;
}
}
