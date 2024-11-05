public class Lab8_5 {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(10, "white", true);
        Circle c2 = new Circle(5, "white", true);
        System.out.println(c1.compareTo(c2));
        c2.radius=10;
        System.out.println(c1.compareTo(c2));
        System.out.println(c1.equals(c2));
        Octagon o1 = new Octagon(10, "white", true);
        Octagon o2 = (Octagon)o1.clone();
        o2.side = 5;
        System.out.println(o1.compareTo(o2));
        o2.side = 10;
        System.out.println(o1.compareTo(o2));
        
    }
}

abstract class GeomtricObject{
    private String color = "white";
    private boolean filled;
    protected GeomtricObject(){
        
    }

    protected GeomtricObject(String color,boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Circle extends GeomtricObject{
    double radius;

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return 3.14*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*3.14*radius;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Circle){
            Circle c = (Circle)obj;
            if(radius==c.radius){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}

class Rectangle extends GeomtricObject implements Comparable{
    
    double width;
    double height;

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }
   
    
    
    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*width+2*height;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Rectangle){
            if(((Rectangle) o).height==height&&((Rectangle) o).width==width){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Rectangle){
            Rectangle r = (Rectangle)obj;
            if(width==r.width&&height==r.height){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}

class Octagon extends GeomtricObject implements Comparable<Octagon>,Cloneable{
    
    double side;

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }
    
    
    
    @Override
    public double getArea() {
        return (2+4.0/Math.sqrt(2.0)*side*side);
    }

    @Override
    public double getPerimeter() {
        return 8*side;
    }

    @Override
    public int compareTo(Octagon o) {
        return equals(o)?1:0;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Octagon){
            Octagon o = (Octagon)obj;
            if(this.getArea()==o.getArea()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    @Override
    public Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException ex){
            return null;
        }
    }
    
}

class ComparableCircle extends Circle implements Comparable<Circle>{

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
    
    @Override
    public int compareTo(Circle o) {
        return o.getArea()==this.getArea()?1:0;
    }
}
