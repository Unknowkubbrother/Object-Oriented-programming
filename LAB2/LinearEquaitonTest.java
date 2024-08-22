/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author studentcs
 */
class LinearEquaiton{
    private double a,b,c,d,e,f;
    private double x,y;
    
    public LinearEquaiton(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public LinearEquaiton(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public double getA(){
        return this.a;
    }
    
    public double getB(){
        return this.b;
    }
    
    
    public double getC(){
        return this.c;
    }
    
    
    public double getD(){
        return this.d;
    }
    
    
    public double getE(){
        return this.e;
    }
    
    public double getF(){
        return this.f;
    }
    
    public boolean isSolvable(){
        double temp = (this.a*this.d-this.b*this.c);
        return (temp != 0) ? true : false;
    }
    
    public double getX(){
        this.calX();
        return this.x;
    }
    
    public double getY(){
        this.calY();
        return this.y;
    }
    
    public void calX(){
        this.x = ((this.e*this.d) - (this.b*this.f)) / ((this.a*this.d) - (this.b*this.c));
    }
    
    public void calY(){
        this.y = ((this.a*this.f) - (this.e*this.c)) / ((this.a*this.d) - (this.b*this.c));
    }
    
   
}

public class LinearEquaitonTest {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double a,b,c,d,e,f;
        System.out.print("Enter a b c d e f : ");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        d = input.nextDouble();
        e = input.nextDouble();
        f = input.nextDouble();
        LinearEquaiton linear = new LinearEquaiton(a,b,c,d,e,f);
        if (linear.isSolvable()){
            System.out.println(String.format("x is %.1f and y is %.1f", linear.getX(),linear.getY()));
        }else{
            System.out.println("The equation has no solution");
        }
    }
    
}
