import java.awt.*;
import javax.swing.*;

/**
 *
 * @author studentcs
 */
public class LAB9_6 extends JFrame {

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JTextField jtfMonitor = new JTextField(10);

    public LAB9_6(String Title) {
        super(Title);
        setDefult(this);
        add(new DrawArea());
    }

    class DrawArea extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(20 + 40, 220, 20 + 40, 20);
            g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);
            g.drawLine(20 + 40 + 100, 20, 20 + 40 + 100, 40);
            int radius = 20;
            g.drawOval(20 + 40 + 100 - radius, 40, 2 * radius, 2 * radius);
            g.drawLine(20 + 40 + 100 - (int) (radius
                    * Math.cos(Math.toRadians(45))),
                    40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                    20 + 40 + 100 - 60, 40 + radius + 60);
            g.drawLine(20 + 40 + 100 + (int) (radius
                    * Math.cos(Math.toRadians(45))),
                    40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                    20 + 40 + 100 + 60, 40 + radius + 60);
            g.drawLine(20 + 40 + 100, 40 + 2 * radius,
                    20 + 40 + 100, 40 + radius + 80);
            g.drawLine(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 - 40,
                    40 + radius + 80 + 40);
            g.drawLine(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 + 40,
                    40 + radius + 80 + 40);
        }
    }

    void setDefult(JFrame window) {
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new LAB9_6("Hungman");
    }

}
