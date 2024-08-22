/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author studentcs
 */
class Complex {
    private double r, i;
    
    Complex(double r, double i){
        this.r = r; this.i = i;
    }
    
    Complex(Complex c){
        this(c.r, c.i);
    }
    
    public void add(Complex c){
        r += c.r;
        i += c.i;
    }
    
    public void sub(Complex c){
        r -= c.r;
        i -= c.i;
    }
    
    public void mul(Complex c){
        double tempr = ((this.r*c.r) - (this.i*c.i));
        double tempi = ((this.r*c.i) + (this.i * c.r));
        this.r = tempr;
        this.i = tempi;
    }
    
    public void divide(Complex c){
        double tempr = (this.r*c.r+this.i*c.i) / ((c.r*c.r)+(c.i*c.i));
        double tempi = (this.i*c.r-this.r*c.i) / ((c.r*c.r)+(c.i*c.i));
        this.r = tempr;
        this.i = tempi;
    }
    
    public void print(){
        System.out.println(r + " " + i + "i");
    }
    
    public void setR(double r){
        this.r = r;
    }
    
    public void setI(double i){
        this.i = i;
    }
    
}
public class ComplexTest {
    public static void main(String args[]){
        Complex a = new Complex(1.0, 2.0);//1+2i
        Complex b = new Complex(3.0,4.0);//3+4i
        Complex c = new Complex(a);
        c.add(b);
        c.print();
        c.setR(1.0);
        c.setI(2.0);
        c.sub(b);
        c.print();
        c.setR(1.0);
        c.setI(2.0);
        c.mul(b);
        c.print();
        c.setR(1.0);
        c.setI(2.0);
        c.divide(b);
        c.print();
    }
}
