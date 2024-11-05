import java.util.ArrayList;

public class LAB8NO4 {

    public static void main(String args[]) {
        ArrayList<Employee> person = new ArrayList<Employee>();
        person.add(new SalariedEmployee("F1","L1","1",1000));
        person.add(new SalariedEmployee("F2","L2","2",2000));
        person.add(new ComEmployee("F3","L3","3",3000,0.05));
        person.add(new ComEmployee("F4","L4","4",4000,0.05));
        printEmp(person);
    }
    
    static void printEmp(ArrayList<Employee> a){
        ArrayList<Employee> arrayEmp = new ArrayList<Employee>();
        ArrayList<Double> arrayEarn = new ArrayList<Double>();
        ArrayList<Double> arrayBonus = new ArrayList<Double>();
        for(int i=0;i<a.size();i++){
            Employee temp = a.get(i);
            if (temp instanceof SalariedEmployee){
                double earning = ((SalariedEmployee)temp).earning();
                double bonus = ((SalariedEmployee)temp).bonus(5+i);
                arrayEarn.add(earning);
                arrayBonus.add(bonus);
                arrayEmp.add(temp);
            }else if (temp instanceof ComEmployee){
                double earning = ((ComEmployee)temp).earning();
                double bonus = ((ComEmployee)temp).bonus(5+i);
                arrayEarn.add(earning);
                arrayBonus.add(bonus);
                arrayEmp.add(temp);
            }
        }
        for(int i=0;i<arrayEmp.size();i++){
            System.out.println(arrayEmp.get(i).getFirstname()+" "+arrayEmp.get(i).getLastname()+" "+arrayEarn.get(i)+" "+arrayBonus.get(i));
        }
    }

}

abstract class Employee {

    private String firstname;
    private String lastname;
    private String id;

    public Employee(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public abstract double earning();

    public abstract double bonus(int year);
    
    public String getFirstname(){
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    
    
}

class SalariedEmployee extends Employee{
    double salary;
    
    SalariedEmployee(String firstname, String lastname, String id, double sal){
        super(firstname,lastname,id);
        this.salary = sal;
    }
    
    public double earning(){
        return salary * 0.95;
    }
    
    public double bonus(int year){
        return (year > 5) ? salary*12 : salary*6;
    }
    
}

class ComEmployee extends Employee{
    double grossSale;
    double ComRate;
    
    public ComEmployee(String firstname,String lastname,String id, double sales, double percent){
        super(firstname,lastname,id);
        this.grossSale = sales;
        this.ComRate = percent;
    }
    
    public double earning(){
        return  grossSale+grossSale*ComRate;
    }
    
    public double bonus(int year){
        return (year > 5) ? grossSale*6 : grossSale*3;
    }
    
}