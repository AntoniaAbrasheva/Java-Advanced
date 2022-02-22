package DefiningClasses.lab.bankAccount;

public class BankAccount {

    private int id;
    private static int accountCounter = 0;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount() {
        accountCounter++;
        this.id = accountCounter;
        this.balance = 0;

    }



    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public void setId(int id) {
         this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double money) {
        this.balance += money;
    }

    public double getInterest(int years) {
        return years * interestRate * this.balance;
    }
}
