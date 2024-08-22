class RegularPolygon{
    private int n;
    private double side;
    private double x;
    private double y;

    public RegularPolygon(){
        this.n = 3;
        this.side = 1;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int n, double side){
        this.n = n;
        this.side = side;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int n, double side, double x, double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getN(){
        return this.n;
    }

    public double getSide(){
        return this.side;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setN(int n){
        this.n = n;
    }

    public void setSide(double side){
        this.side = side;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getPerimeter(){
        return this.n * this.side;
    }

    public double getArea(){
        return (this.n * this.side * this.side) / (4 * Math.tan(Math.PI / this.n));
    }

}

public class RegularPolygonTest {
    public static void main(String args[]){
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("The perimeter of a is " + polygon1.getPerimeter() + " and the area is " + polygon1.getArea());
        System.out.println("The perimeter of b is " + polygon2.getPerimeter() + " and the area is " + polygon2.getArea());
        System.out.println("The perimeter of c is " + polygon3.getPerimeter() + " and the area is " + polygon3.getArea());

    }    
}
