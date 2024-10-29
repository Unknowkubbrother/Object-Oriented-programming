import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Gui extends JFrame implements ActionListener{
    JPanel mainBody = new JPanel();
    JTextField timer = new JTextField("time to be displayed here");
    JLabel title = new JLabel("Food System",JLabel.CENTER);
    ArrayList<JButton> listBtn = new ArrayList<JButton>();
    String[][] listTextBtn = {
        {"1","2","3"},
        {"4","5","6"},
        {"7","8","9"},
        {"0","Start","Stop"}
    };
    JButton placeFood = new JButton("Food to be placed here");

    Gui(){
        setLayout(new BorderLayout());
        mainBody.setLayout(new BorderLayout());
        JPanel panelBtn = new JPanel(new GridLayout(4,3,2,2));
        for(int i=0;i<listTextBtn.length;i++){
            for(int j=0;j<listTextBtn[i].length;j++){
                JButton btn = new JButton(listTextBtn[i][j]);
                btn.addActionListener(this);
                listBtn.add(btn);
                panelBtn.add(btn);
            }
        }
        mainBody.add(timer,BorderLayout.NORTH);
        mainBody.add(panelBtn,BorderLayout.CENTER);

        add(title,BorderLayout.NORTH);
        add(placeFood,BorderLayout.CENTER);
        add(mainBody,BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        timer.setText(cmd);

    }

    public static void main(String[] args){
        Gui window = new Gui();
        window.setTitle("THE Front of a Microwave Oven");
        window.setSize(400,250);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
