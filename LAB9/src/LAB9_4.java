import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LAB9_4 extends JFrame{
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel jlbUs = new JLabel("US Dollars ");
    JTextField jtfUs = new JTextField(10);
    JLabel jlbCanada = new JLabel("Canadian Dollars ");
    JTextField jtfCanada = new JTextField(10);
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    
   public LAB9_4(String Title) {
        super(Title);
        setLayout(new BorderLayout());
        setUI();
        setDefult(this);
    }
   
   void setUI(){
       Listener spyListener = new Listener();
       p1.setLayout(new GridLayout(2, 1, 5, 5));
       p1.add(jlbUs);
       p1.add(jlbCanada);
       p2.setLayout(new GridLayout(2, 1, 5, 5));
       jtfUs.setHorizontalAlignment(JTextField.RIGHT);
       jtfCanada.setHorizontalAlignment(JTextField.RIGHT);
       jtfCanada.setEditable(false);
       jtfUs.addActionListener(spyListener);
       jtfCanada.addActionListener(spyListener);
       p2.add(jtfUs);
       p2.add(jtfCanada);
       p3.setLayout(new BorderLayout());
       p3.add(p1,BorderLayout.WEST);
       p3.add(p2,BorderLayout.CENTER);
       add(p3,BorderLayout.CENTER);
       JButton convert = new JButton("Convert");
       convert.addActionListener(spyListener);
       p4.setLayout(new BorderLayout());
       p4.add(convert,BorderLayout.EAST);
       add(p4,BorderLayout.SOUTH);
   }
    
   
   //inner class
    class Listener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("Convert")){
               jtfCanada.setText(""+Double.parseDouble(jtfUs.getText())*1.5);
            }
        }
        
    }
    void setDefult(JFrame window){
        window.setSize(500,150);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new LAB9_4("Convert US Dollars to Canadian Dollars");
    }
}
