import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SolarSystem extends JFrame{
    Image bg = new ImageIcon(getClass().getResource("solarbg.jpg")).getImage();
    int x = 0;
    int pos = 55;
    planet Sun = new planet(0, 750+pos, 500-pos, 100);
    planet Mercury = new planet(180, 750-10+pos, 500+10-pos, 10);
    planet Venus = new planet(250, 750-15+pos, 500+15-pos, 15);
    planet Earth = new planet(350, 750-20+pos, 500+20-pos, 35);
    planet Moon = new planet(55, (int)(Earth.x+(Earth.radius/2)*Math.sin(x*(2*Math.PI/820)))-Earth.radiusPlanet/2, (int)(Earth.y-(Earth.radius/2)*Math.cos(x*(2*Math.PI/820)))-Earth.radiusPlanet/2, 10);
    planet Mars = new planet(500, 750-30+pos,500+30-pos, 30);
    planet Jupiter = new planet(700, 750-50+pos,500+50-pos, 60);
    planet Saturn = new planet(850, 750-60+pos,500+60-pos, 50);

    public SolarSystem(){
        add(new DrawArea());
    }
    
    public class DrawArea extends JPanel{
        Timer time = new Timer(1,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        public DrawArea() {
            time.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(bg, 0, 0,getWidth(),getHeight(), this);
            g.setColor(Color.YELLOW);
            Sun.Draw(g, x, 360);
            g.setColor(Color.MAGENTA);
            Mercury.Draw(g, x, 400);
            g.setColor(Color.GREEN);
            Venus.Draw(g, x, 500);
            g.setColor(Color.BLUE);
            Earth.Draw(g, x, 820);
            g.setColor(Color.GRAY);
            Moon.Draw(g, x, 360);
            g.setColor(Color.red);
            Mars.Draw(g, x, 900);
            g.setColor(Color.ORANGE);
            Jupiter.Draw(g, x, 1200);
            g.setColor(Color.white);
            Saturn.Draw(g, x, 1500);
            x+=1;
        }
        
        public void update(){
            Moon.x=(int)(Earth.x+(Earth.radius/2)*Math.sin(x*(2*Math.PI/820)));
            Moon.y=(int)(Earth.y-(Earth.radius/2)*Math.cos(x*(2*Math.PI/820)));
        }
        
    }
    
    public class planet{
        public int radius;
        public int x,y;
        public int radiusPlanet;

        public planet(int radius, int x, int y, int radiusPlanet) {
            this.radius = radius;
            this.x = x;
            this.y = y;
            this.radiusPlanet = radiusPlanet;
        }
        
        public void Draw(Graphics g,int x,int n){
            g.fillOval((int)(this.x+(radius/2)*Math.sin(x*(2*Math.PI/n)))-radiusPlanet/2, (int)(y-(radius/2)*Math.cos(x*(2*Math.PI/n)))-radiusPlanet/2, radiusPlanet, radiusPlanet);
            //g.drawOval(this.x-radius/2, this.y-radius/2, radius, radius);
        }
    }
    
    public static void main(String[] args) {
        SolarSystem j = new SolarSystem();
        j.setTitle("Solar System");
        j.setSize(1500, 1000);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setVisible(true);
        
    }
}
