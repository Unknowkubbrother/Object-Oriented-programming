import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author studentcs
 */
public class LAB8NO3 extends JFrame{
    
    public LAB8NO3()
    {
        getContentPane().setLayout(new GridLayout(2, 4, 5, 5));
        getContentPane().add(new DrawSq());
        getContentPane().add(new DrawSin());
        getContentPane().add(new DrawCos());
        getContentPane().add(new DrawTan());
        getContentPane().add(new DrawCos5Sin());
        getContentPane().add(new Draw5CosSin());
        getContentPane().add(new logxx2());
    }
    
    public static void main(String args[]){
        LAB8NO3 frame = new LAB8NO3();
        frame.setSize(400, 400);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
    
}

abstract class AbstractDrawFunction extends JPanel {

    /**
     * Polygon to hold the points
     */
    private Polygon p = new Polygon();

    /**
     * Default constructor
     */
    protected AbstractDrawFunction() {
        drawFunction();
        setBackground(Color.white);
    }

    /**
     * Draw the function
     */
    public abstract double f(double x);

    /**
     * Obtain points for x coordinates 100, 101, ..., 300
     */
    public void drawFunction() {
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int) f(x));
        }
    }

    /**
     * Paint the function diagram
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
// Draw x axis
        g.drawLine(10, 200, 390, 200);
// Draw y axis
        g.drawLine(200, 30, 200, 390);
// Draw arrows on x axis
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);
// Draw arrows on y axis
        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
// Draw x, y
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
// Draw a polygon line by connecting the points in the polygon
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}

class DrawSq extends AbstractDrawFunction{
    
    @Override
     public double f(double x){
         return x*x;
     }
} 


class DrawSin extends AbstractDrawFunction{
    
    @Override
     public double f(double x){
         return 10*Math.sin(Math.toRadians(x));
     }
} 

class DrawCos extends AbstractDrawFunction{
    
    @Override
     public double f(double x){
         return 10*Math.cos(Math.toRadians(x));
     }
} 

class DrawTan extends AbstractDrawFunction{
    
    @Override
     public double f(double x){
         return 10*Math.tan(Math.toRadians(x));
     }
} 

class DrawCos5Sin extends AbstractDrawFunction{
    
    @Override
     public double f(double x){
         return 10*(Math.cos(Math.toRadians(x))+ (5*Math.sin(Math.toRadians(x))));
     }
} 

class Draw5CosSin extends AbstractDrawFunction{
    
    @Override
     public double f(double x){
         return 10*(5*Math.cos(Math.toRadians(x))+ (Math.sin(Math.toRadians(x))));
     }
} 

class logxx2 extends AbstractDrawFunction{
    
    @Override
     public double f(double x){
         return 10*(Math.log(x)+Math.pow(x, 2));
     }
} 