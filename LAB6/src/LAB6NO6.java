
public class LAB6NO6 {

    public static void main(String[] args) {
        SavingAccount account1 = new SavingAccount(1123,20000,4.5,new Person("Nutchanon","Supmeechai",19,20,"March",2005));
        Account account2 = new Account(1100,20000,4.5,new Person("John","Dev",19,20,"March",2005)); 
        account1.withdraw(2500);
        account1.deposit(3000);
        account1.transferMoney(account2, 500);
        System.out.println(account1);
        FixAccount account3 = new FixAccount(1124,20000,7,new Person("Rich","Star",19,20,"March",2005));
        account3.withdraw(2500);
        account3.deposit(3000);
        account3.transferMoney(account2, 500);
        System.out.println(account3);
    }
    
}

class Date{
    private int day;
    private String month;
    private int year;

    public Date(){
        this.day = 14;
        this.month = "August";
        this.year = 2024;
    }

    public Date(int day,String month,int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public String getMonth(){
        return this.month;
    }

    public void setMonth(String month){
        this.month = month;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }
}

class Person{
    private String name;
    private String surname;
    private int age;
    private Date bDate;

    public Person(){
        this.name = "";
        this.surname = "";
        this.age = 0;
        this.bDate = new Date();
    }

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.age = 0;
        this.bDate = new Date();
    }

    public Person(String name, String surname,int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bDate = new Date();
    }


    public Person(String name, String surname, int age, int day, String month, int year ){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bDate = new Date(day,month,year);
    }
    
    
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurName(){
        return this.surname;
    }

    public void setSurName(String surname){
        this.surname = surname;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public Date getBDate(){
        return this.bDate;
    }

    public void setAge(Date bDate){
        this.bDate = bDate;
    }

}

class Account{
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private Person objPerson;
    private Date lastdeposit;

    public Account(){
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
        this.objPerson = new Person();
        this.lastdeposit = new Date();
    }

    public Account(int id, double balance , double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate/100;
        this.objPerson = new Person();
        this.dateCreated = new Date();
        this.lastdeposit = new Date();
    }

    public Account(int id, double balance , double annualInterestRate, Person employee){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate/100;
        this.objPerson = employee;
        this.dateCreated = new Date();
        this.lastdeposit = new Date();
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
    
    public Date getLastDateDeposit(){
        return this.lastdeposit;
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
        return (this.annualInterestRate / 12) * 100;
    }

    public double getMonthlyInterest(){
        return (this.balance * this.getMonthlyInterestRate()) / 100;
    }

    public void withdraw(double money){
        if (this.balance < money){
            return;
        }
        this.balance -= money;
    }

    public void deposit(double money){
        this.balance += money;
        this.lastdeposit = new Date();
    }

    public void transferMoney(Account acc1,double amount){
        this.setBalance(this.getBalance()-amount);
        acc1.setBalance(acc1.getBalance()+amount);
    }

    @Override
    public String toString(){
        return String.format("%d %s %s %.2f %.2f",this.id,this.objPerson.getName(),this.objPerson.getSurName(),this.balance,this.getMonthlyInterest());
    }

}


class SavingAccount extends Account{
    
    public SavingAccount(int id, double balance , double annualInterestRate, Person employee){
        super(id,balance,annualInterestRate,employee);
    }
    
    @Override
    public void transferMoney(Account acc1,double amount){
        super.setBalance(super.getBalance()-amount-20);
        acc1.setBalance(acc1.getBalance()+amount);
    }
}

class FixAccount extends Account{
    
    public FixAccount(int id, double balance , double annualInterestRate, Person employee){
        super(id,balance,annualInterestRate,employee);
    }
    
    @Override
    public void transferMoney(Account acc1,double amount){
        System.out.println("Error Transfer");
    }
    
    @Override
     public void withdraw(double money){
         if(2026 - super.getLastDateDeposit().getYear() <= 1){
            return;
         }
         
        if (super.getBalance() < money){
            return;
        }
        super.setBalance(super.getBalance() - money);
    }
}
