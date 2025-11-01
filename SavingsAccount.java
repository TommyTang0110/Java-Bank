public class SavingsAccount extends CheckingAccount {
    private double interestRate;

    public SavingsAccount() {
        super();
        this.interestRate = 0.01;
    }

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double rate) { this.interestRate = rate; }

 
    public void calcInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
}
