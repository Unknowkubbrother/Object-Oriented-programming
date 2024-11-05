import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author studentcs
 */
public class LAB9_6_1 extends JFrame {

    JPanel p1 = new JPanel();
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");

    public LAB9_6_1(String Title) {
        super(Title);
        JPanel p1 = new JPanel();
        p1.add(start);
        p1.add(stop);
        add(p1, BorderLayout.NORTH);
        add(new DrawArea(), BorderLayout.CENTER);
    }

    class DrawArea extends JPanel implements ActionListener {

        int line1 = 20 + 40 + 100;
        int n = 1;
        int pos = 1;
        Timer time = new Timer(1, this);

        public DrawArea() {
//            time.start();
            start.addActionListener(this);
            stop.addActionListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(20 + 40, 220, 20 + 40, 20);
            g.drawLine(20 + 40, 20, 20 + 40 + 100, 20);
            g.drawLine(20 + 40 + 100, 20, line1, 40);
            int radius = 20;
            g.drawOval(line1 - radius, 40, 2 * radius, 2 * radius); //  head
            g.drawLine(line1 - (int) (radius
                    * Math.cos(Math.toRadians(45))),
                    40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                    line1 + pos - 60, 40 + radius + 60 - 15); // armLeft
            g.drawLine(line1 + (int) (radius
                    * Math.cos(Math.toRadians(45))),
                    40 + radius + (int) (radius * Math.sin(Math.toRadians(45))),
                    line1 + 2 * pos + 60, 40 + radius + 60 - 15); // armRight
            g.drawLine(line1, 40 + 2 * radius,
                    line1, 40 + radius + 80); // body
            g.drawLine(line1, 40 + radius + 80, line1 + pos - 60,
                    40 + radius + 80 + 40); // legLeft
            g.drawLine(line1, 40 + radius + 80, line1 + 2 * pos + 60,
                    40 + radius + 80 + 40); // LegRight
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (pos > 60) {
                n = -1;
            } else if (pos <= -60) {
                n = 1;
            }
            line1 += n;
            pos += n;
            checkState(e);
            repaint();
        }

        void checkState(ActionEvent e) {
            if (e.getSource() == start) {
                time.start();
            } else if (e.getSource() == stop) {
                time.stop();
            }
        }

    }

    public static void main(String[] args) {
        JFrame window = new LAB9_6_1("Hungman");
        window.setSize(300, 350);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
