import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.awt.Rectangle;

public class DrawGraphic extends JFrame{
    private int x = 0;
    private int y = 0;
    Draw draw = new Draw();

    DrawGraphic(String title){
        super(title);
        setLayout(new BorderLayout());
        // add(new Button(),BorderLayout.SOUTH);
        add(draw,BorderLayout.CENTER);
    }


    class Button extends JPanel implements ActionListener{
        JButton  Right = new JButton("Right");
        JButton Left = new JButton("Left");
        JButton Up = new JButton("Up");
        JButton Down = new JButton("Down");
        Timer timer = new Timer(1000, this);
    
        Button(){
            Up.addActionListener(this);
            Down.addActionListener(this);
            Left.addActionListener(this);
            Right.addActionListener(this);
            add(Up);
            add(Down);
            add(Left);
            add(Right);
            timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e){
                if (e.getSource() == Up){
                    y--;
                }else if (e.getSource() == Down) {
                    y++;
                }else if (e.getSource() == Left){
                    x--;
                }else if (e.getSource() == Right){
                    x++;
                }
                draw.repaint();
        }
    }

    class KeyHandler implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_W){
                y-=10;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                y+=10;
            }
            if (e.getKeyCode() == KeyEvent.VK_A){
                x-=10;
            }
            if (e.getKeyCode() == KeyEvent.VK_D){
                x+=10;
            }
            draw.repaint();
        }

        @Override
        public void keyReleased(KeyEvent e){
            // System.out.println("Key Released");
        }

        @Override
        public void keyTyped(KeyEvent e){
            // System.out.println("Key Typed");
        }
    }

    class MouseMovement implements MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e){
            // System.out.println("Mouse Dragged");
        }

        @Override
        public void mouseMoved(MouseEvent e){
            x = e.getX();
            y = e.getY();
            draw.repaint();
        }

    }

    class Monter {
        Rectangle rect = new Rectangle();
        int x = 200;
        int y = 200;

        Monter(){
            rect.setSize(100, 100);
            rect.x = x;
            rect.y = y;
        }
    }

    class Player {
        Image moodeng = new ImageIcon(getClass().getResource("moodeng.png")).getImage();
        Rectangle rect = new Rectangle();

        Player(){
            rect.setSize(100, 100);
        }

        public void update(){
            rect.setLocation(x, y);
        }
    }
    
    
    class Draw extends JPanel implements Runnable{
        Thread thread = new Thread(this);
        Player player = new Player();
        Monter monter = new Monter();

        Draw(){
            repaint();
            setFocusable(true);
            this.addKeyListener(new KeyHandler());
            thread.start();
            // this.addMouseMotionListener(new MouseMovement());
        }
    
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
    
            // g.fillRect(x,y, 100, 100);
            // g.drawImage(player.moodeng, x, y, 100, 100, this);
            // g.drawRect(x, y, 100, 100);
            // g.drawRect(monter.x, monter.y, 100, 100);



            //Doraemon
            // setBackground(Color.black);
            // g.setColor(Color.cyan);
            // g.fillOval(20, 20, 160, 160);
            // g.setColor(Color.white);
            // g.fillOval(30, 40, 140, 140);
            // g.fillOval(80, 30, 20, 30);
            // g.fillOval(100, 30, 20, 30);
            // g.setColor(Color.red);
            // g.fillOval(95, 55, 10, 10);
            // g.fillArc(50, 55, 100, 100, 0, -180);
            // g.fillRect(62, 170, 76, 10);
            // g.setColor(Color.yellow);
            // g.fillOval(93, 173, 14, 14);
            // g.setColor(Color.black);
            // g.drawArc(65, 120, 70, 70, 22, 138);
            // g.fillOval(99, 181, 2, 2);
            // g.drawLine(100, 183, 100, 187);
            // g.drawArc(90, 160, 20, 20, -45, -90);
            // g.drawOval(80, 30, 20, 30);
            // g.drawOval(100, 30, 20, 30);
            // g.fillOval(88, 42, 4, 6);
            // g.fillOval(108, 42, 4, 6);
            // g.drawLine(100, 65, 100, 105);
            // g.drawLine(50, 70, 80, 80);
            // g.drawLine(50, 85, 80, 85);
            // g.drawLine(50, 100, 80, 90);
            // g.drawLine(120, 80, 150, 70);
            // g.drawLine(120, 85, 150, 85);
            // g.drawLine(120, 90, 150, 100);


            // Shinchan
            g.setColor(Color.pink);
            for(int i=0;i<40;i++)
             g.drawLine(54,95-i,138,80-i);//cheek to ear
            g.setColor(Color.black);
            g.fillArc(46,8,94,62,0,180);//up head
            for(int i=0;i<7;i++)
             g.drawLine(132+i,60,132+i,39);//ear to downHead
            g.setColor(Color.pink);
            g.fillOval(20,40,60,54);//cheek
            g.fillOval(130,60,20,20);//ear
            g.fillOval(46,14,86,52);//down head
            g.setColor(Color.black);
            //EyeBrow
            for(int i=0;i<10;i++){
             g.drawArc(53,10+i,30,24,0,180);
             g.drawArc(90,10+i,30,24,0,180);
            }
            g.drawArc(53,25,30,24,0,180);
            g.drawArc(90,25,30,24,0,180);
            //Eye
            g.fillOval(53,30,30,24);
            g.fillOval(90,30,30,24);
            g.setColor(Color.white);
            g.fillOval(53+10,30+8,10,10);
            g.fillOval(90+10,30+8,10,10);
            //mouth
            g.setColor(Color.red);
            g.fillOval(40,80,22,16);



            
            //Clock

            // int radius = (int)(Math.min(getWidth(), getHeight())*0.4);
            // int xCenter = getWidth()/2;
            // int yCenter = getHeight()/2;
            // g.drawOval(xCenter - radius, yCenter - radius, 2*radius, 2*radius);
            // g.drawString("12", xCenter, yCenter - radius + 12);
            // g.drawString("3", xCenter + radius - 10, yCenter);
            // g.drawString("6", xCenter, yCenter + radius - 5);
            // g.drawString("9", xCenter - radius + 5, yCenter);
            // // g.drawLine(getWidth()/2, getWidth()/2,(int)Math.cos(x), (int)Math.sin(y));
            // int sLength = (int)(radius*0.8);
            // int xSecond = (int)(xCenter + sLength*Math.sin(x * (2 * Math.PI / 60)));
            // int ySecond = (int)(yCenter - sLength*Math.cos(y * (2 * Math.PI / 60)));
            // g.drawLine(xCenter, yCenter, xSecond, ySecond);

            // int mLength = (int)(radius*0.65);
            // int xMinute = (int)(xCenter + mLength*Math.sin(x * (2 * Math.PI / 60)));
            // int yMinute = (int)(yCenter - mLength*Math.cos(y * (2 * Math.PI / 60)));
            // g.drawLine(xCenter, yCenter, xMinute, yMinute);


            // int hLength = (int)(radius*0.5);
            // int xHour = (int)(xCenter + hLength*Math.sin(x * (2 * Math.PI / 60)));
            // int yHour = (int)(yCenter - hLength*Math.cos(y * (2 * Math.PI / 60)));
            // g.drawLine(xCenter, yCenter, xHour, yHour);
        }


        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(30);
                    player.update();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    

    public static void main(String[] args) {
        DrawGraphic window = new DrawGraphic("Draw Graphic");
        window.setSize(400,400);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
    }
}
