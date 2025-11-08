//Admin.java
public class Admin extends User{
	public Admin(){
		super("admin","0000");
	}
	private void printMenu(){
		System.out.println();
		System.out.println("Admin Menu");
		System.out.println("0 Exit this menu");
		System.out.println("1 Full customer report");
		System.out.println("2 Add user");
		System.out.println("3 Apply interest to sving accounts");
		System.out.print("Action: ");
	}

	@Override
	public void start(){
		java.util.Scanner in = new java.util.Scanner(System.in);
		while (true){
			printMenu();
			int c = in.nextInt();
			if (c==0)break;
			System.out.println("(Bank.adminStart()");
		}
	}

	@Override
	public String menu(){
		return "Admin Menu (unused)";
	}
	@Override
	public String getReport(){
		return "Admin: " + getUserName() + " (PIN: " + getPIN() + ")";
	}
}
