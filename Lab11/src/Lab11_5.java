import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab11_5 extends JFrame {

    public Lab11_5() {
        add(new RaceCar());
    }

    public static void main(String[] args) {
        Lab11_5 frame = new Lab11_5();
        frame.setTitle("Exercise");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}

class RaceCar extends JPanel implements Runnable{

    private int xBase = 0;
    private Thread thread;
    private int time = 10;
    
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(time);
                repaint();
            }catch(InterruptedException e){
                System.out.print(e.getMessage());
            }
        }
    }

    public RaceCar() {
        thread = new Thread(this);
        thread.start();
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    if (time > 5) {
                        time -= 5;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    time+=1;
                }
            }
        });
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int yBase = getHeight();

        if (xBase > getWidth()) {
            xBase = -20;
        } else {
            xBase += 1;
        }
        g.setColor(Color.BLACK);
        g.fillOval(xBase + 10, yBase - 10, 10, 10);
        g.fillOval(xBase + 30, yBase - 10, 10, 10);
        g.setColor(Color.GREEN);
        g.fillRect(xBase, yBase - 20, 50, 10);
        g.setColor(Color.RED);
        Polygon polygon = new Polygon();
        polygon.addPoint(xBase + 10, yBase - 20);
        polygon.addPoint(xBase + 20, yBase - 30);
        polygon.addPoint(xBase + 30, yBase - 30);
        polygon.addPoint(xBase + 40, yBase - 20);
        g.fillPolygon(polygon);
    }
}
