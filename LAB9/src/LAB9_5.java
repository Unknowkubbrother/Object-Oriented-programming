import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LAB9_5 extends JFrame {

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JTextField jtfMonitor = new JTextField(10);
    Listener spyListener = new Listener();
    double result = 0;
    String tempResult = "";

    String[] buttons = {
        "√", "x^2", "+/-", "C",
        "7", "8", "9", "+",
        "6", "5", "4", "-",
        "1", "2", "3", "*",
        "0", ".", "=", "/"
    };

    public LAB9_5(String Title) {
        super(Title);
        setLayout(new BorderLayout());
        setPanel();
        setButton();
        setDefult(this);
    }

    void setButton() {
        JButton[] tempBtn = new JButton[20];
        for (int i = 0; i < buttons.length; i++) {
            tempBtn[i] = new JButton(buttons[i]);
            p1.add(tempBtn[i]);
            setAction(tempBtn[i]);
        }
        p2.add(p1, BorderLayout.CENTER);
        jtfMonitor.setHorizontalAlignment(JTextField.RIGHT);
        p2.add(jtfMonitor, BorderLayout.NORTH);
        add(p2);
    }

    void setAction(JButton button) {
        button.addActionListener(spyListener);
    }

    void setPanel() {
        p1.setLayout(new GridLayout(5, 4));
        p2.setLayout(new BorderLayout());
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
                jtfMonitor.setText(jtfMonitor.getText() + command);
            } else if (command.equals("C")) {
                result = 0.0;
                tempResult = "";
                jtfMonitor.setText("");
            } else if (command.equals("=")) {
                tempResult += jtfMonitor.getText();
                result = calculator(tempResult);
                jtfMonitor.setText(String.valueOf(result));
                tempResult = ""; // Clear tempResult after calculating
            } else if (command.equals("+/-")) {
                if (!jtfMonitor.getText().isEmpty()) {
                    double value = Double.parseDouble(jtfMonitor.getText());
                    jtfMonitor.setText(String.valueOf(-value));
                }
            } else if (command.equals("√")) {
                if (!jtfMonitor.getText().isEmpty()) {
                    double value = Double.parseDouble(jtfMonitor.getText());
                    jtfMonitor.setText(String.valueOf(Math.sqrt(value)));
                }
            } else if (command.equals("x^2")) {
                if (!jtfMonitor.getText().isEmpty()) {
                    double value = Double.parseDouble(jtfMonitor.getText());
                    jtfMonitor.setText(String.valueOf(value * value));
                }
            } else {
                tempResult += jtfMonitor.getText() + command;
                jtfMonitor.setText(""); // Clear the display for next number
            }
        }

        double calculator(String temp) {
            String[] tokens = temp.split("(?=[+*/-])|(?<=[+*/-])");
            double tempResult = Double.parseDouble(tokens[0]);
            for (int i = 1; i < tokens.length; i += 2) {
                String op = tokens[i];
                double num = Double.parseDouble(tokens[i + 1]);
                switch (op) {
                    case "+":
                        tempResult += num;
                        break;
                    case "-":
                        tempResult -= num;
                        break;
                    case "*":
                        tempResult *= num;
                        break;
                    case "/":
                        if (num != 0) {
                            tempResult /= num;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                            return 0;
                        }
                        break;
                }
            }
            return tempResult;
        }
    }

    void setDefult(JFrame window) {
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new LAB9_5("Simple Calculator");
    }
}
