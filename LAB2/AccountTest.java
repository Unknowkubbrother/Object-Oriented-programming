import java.util.Date;
class Account{
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account(){
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0.045;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0.045;
        this.dateCreated = new Date();
    }

    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    public Date getDate(){
        return this.dateCreated;
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

    public void setDate(Date date){
        this.dateCreated = date;
    }

    public double getMonthlyInterestRate(){
        return this.annualInterestRate / 12 * 100;
    }

    public double getMonthlyInterest(){
        return this.balance * this.getMonthlyInterestRate() / 100;
    }

    public void withdraw(double money){
        if (this.balance < money){
            return;
        }
        this.balance -= money;
    }

    public void deposit(double money){
        this.balance += money;
    }


}

public class AccountTest {
    public static void main(String args[]){
        Account account1 = new Account(1122,20000);
        account1.withdraw(2500);
        account1.deposit(3000);
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Rate: " + account1.getMonthlyInterest());
    
    }
    
}
