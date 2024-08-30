import java.util.Date;
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122, 100000, 0.02);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Monthly Interest: " + account.getMonthlyInterest());
        System.out.println("Compound interest: " + account.Compoundinterest());
    }
}

class Account{
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    Account(int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        dateCreated = new Date();
    }

    public int getId(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public void setDate(Date dateCreated){
        this.dateCreated = dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/2;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public double Compoundinterest(){
        return balance * Math.pow((1 + getMonthlyInterestRate()), 3);
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }

}
