import java.util.ArrayList;

public class LAB5NO5 {
    public static void main(String[] args) {
        ArrayList<Employee> arrayEarn = new ArrayList<Employee>();
        arrayEarn.add(new Employee("Nutchanon","Supmeechai","1",1000.00));
        arrayEarn.add(new Employee("John","Dev","2",1000.00));
        arrayEarn.get(0).setSinceYears(12);
        arrayEarn.get(1).setSinceYears(4);
        for(int i=0;i<arrayEarn.size();i++){
            arrayEarn.get(i).printEmp();
        }
    }
    
}

class Employee{
    private String firstname;
    private String lastname;
    private String id;
    private double salary;
    private int sinceyear;
  
    public Employee(String firstname,String lastname,String id,double sal){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.salary = sal;
    }

    public double earning(){
        return salary * 0.95;
    }

    public double bonus(int year){
        double salary = this.salary;
        if (this.sinceyear > 5){
            salary = salary * 12;
        }else{
            salary = salary * 6;
        }
        return salary;
    }

    public void setSinceYears(int year){
        this.sinceyear = year;
    }

    public void printEmp(){
        System.out.println(String.format("%s %s %.2f %.2f", this.firstname,this.lastname,this.earning(),this.bonus(this.sinceyear)));
    }
}