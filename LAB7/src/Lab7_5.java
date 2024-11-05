
public class Lab7_5 {
    public static void main(String[] args) {
        Employee emp = new Manager("1", 1, "aaa", 10000, new Address("Bangkok", "Bangkok"));
        System.out.println(emp.getDetails());
    }
}

class Address{
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }    
    
    public String getaddressInfo(){
        return getCity()+" "+getStreet();
    }
    @Override
    public String toString(){
        return getaddressInfo();
    }
}

class Employee{
    protected int id;
    protected String name;
    protected double salary;
    protected Address address;

    public Employee(int id, String name, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getDetails(){
        return getId()+" "+getName()+" "+getSalary()+" "+getAddress();
    }
}

class Manager extends Employee{
    protected String parkingNo;

    public Manager(String parkingNo, int id, String name, double salary, Address address) {
        super(id, name, salary, address);
        this.parkingNo = parkingNo;
    }

    public String getParkingNo() {
        return parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    @Override
    public String getDetails() {
        return getId()+" "+getName()+" "+getSalary()+" "+getAddress()+" "+getParkingNo();
    }
    
}
