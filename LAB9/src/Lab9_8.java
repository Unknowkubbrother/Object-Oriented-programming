import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Rectangle;


public class Lab9_8 extends JFrame implements ActionListener{
    
    JPanel head = new JPanel(new GridLayout(1, 2));
    JPanel data = new JPanel(new GridLayout(3, 3));
    JPanel inputmain = new JPanel(new BorderLayout());
    JPanel psubmit = new JPanel(new FlowLayout());
    
    JLabel jlbscore = new JLabel("SCORE:");
    
    JTextField jtfBirdPos = new JTextField();
    JTextField jtfSpeed = new JTextField();
    JTextField jtfAngle = new JTextField();
    
    JButton jbtsubmit = new JButton("OK");
    
    DrawArea draw = new DrawArea();
    public Lab9_8() {
        head.add(new JLabel("SCENE 1: At Tokyo"));
        head.add(jlbscore);
        addData();
        psubmit.add(jbtsubmit);
        inputmain.add(data,BorderLayout.CENTER);
        inputmain.add(psubmit,BorderLayout.SOUTH);
        add(head,BorderLayout.NORTH);
        add(draw,BorderLayout.CENTER);
        add(inputmain,BorderLayout.SOUTH);
        jbtsubmit.addActionListener(this);
    }
    
    public void addData(){
        data.add(new JLabel("Bird Position in y-axis"));
        data.add(jtfBirdPos);
        data.add(new JLabel("m"));
        data.add(new JLabel("Shooting speed"));
        data.add(jtfSpeed);
        data.add(new JLabel("m/s"));
        data.add(new JLabel("Angle"));
        data.add(jtfAngle);
        data.add(new JLabel("degree"));
    }
    
    public static double projectile(double x,double speed,double dregge){
        return speed*Math.sin((dregge*3.14)/180)*x-(1.0/2.0*9.81*x*x);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            draw.y = Integer.parseInt(jtfBirdPos.getText());
            draw.speed = Integer.parseInt(jtfSpeed.getText());
            draw.dregge = Integer.parseInt(jtfAngle.getText());
            draw.repaint();
        }catch(NumberFormatException ex){
            
        }
    }
    
    class DrawArea extends JPanel{
        Image imgBg = new ImageIcon(getClass().getResource("tokyothings.jpeg")).getImage();
        Image imgBird = new ImageIcon(getClass().getResource("bird.png")).getImage();
        Image imgPig = new ImageIcon(getClass().getResource("pig.png")).getImage();
        Image yc = new ImageIcon(getClass().getResource("yellowcircle.png")).getImage();
        int y=250,speed=0,dregge=0;
        Rectangle imgPigBounds = new Rectangle(450, 100, 50, 50);
        Rectangle ycBounds = new Rectangle((int)(100)+25, (int)(y-projectile(0,speed,dregge))+25, 10, 10);
        

        public DrawArea() {
            
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imgBg, 0, 0, getWidth(), getHeight(), this);
            g.drawImage(imgBird, 100, y, 50, 50, this);
            g.drawImage(imgPig, 450, 100, 50, 50, this);
            double i=0;
            do{
                g.drawImage(yc,(int)(100+i*speed)+25, (int)(y-projectile(i,speed,dregge))+25, 10, 10,this);
                ycBounds.setBounds((int)(100+i*speed)+25, (int)(y-projectile(i,speed,dregge))+25, 10, 10);
                if (ycBounds.intersects(imgPigBounds)) {
                    jlbscore.setText("SCORE: 100");
                    break;
                }else{
                    jlbscore.setText("SCORE: ");
                }
                i+=0.5;
            }while(getHeight() + projectile(i,speed,dregge) > 0);
        }
    }
    
    public static void main(String[] args) {
        Lab9_8 j = new Lab9_8();
        j.setTitle("AbgryBirds");
        j.setSize(600,500);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
    }
}

//250 70 50
