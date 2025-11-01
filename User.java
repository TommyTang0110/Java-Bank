import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
    private String userName;
    private String PIN;

    public User() {}
    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }

    
    public boolean login() {
        Scanner in = new Scanner(System.in);
        System.out.print("User name: ");
        String u = in.nextLine();
        System.out.print("PIN: ");
        String p = in.nextLine();
        return login(u, p);
    }

   
    public boolean login(String u, String p) {
        return this.userName != null && this.userName.equals(u)
            && this.PIN != null && this.PIN.equals(p);
    }

    public String getUserName() { return userName; }
    public void setUserName(String name) { this.userName = name; }
    public String getPIN() { return PIN; }
    public void setPIN(String pin) { this.PIN = pin; }

    
    public abstract String getReport();
    public abstract String menu();
    public abstract void start();
}
