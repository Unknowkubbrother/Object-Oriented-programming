import java.util.Scanner;


public class assignMent3 {
    
    static double side(double x1, double x2,double y1,double y2){
        double result = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
        return result;
    }
    
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        double x1,y1,x2,y2,x3,y3;
        System.out.print("Enter three point for a triangle: ");
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        x3 = input.nextDouble();
        y3 = input.nextDouble();
        
        double side1 = side(x1,x2,y1,y2);
        double side2 = side(x1,x3,y1,y3);
        double side3 = side(x2,x3,y2,y3);
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        String text = String.format("The area of the traingle is %.2f", area);
        System.out.println(text);
        
    }
    
}
