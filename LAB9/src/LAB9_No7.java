
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class LAB9_No7 extends JFrame {
    private static String url = "jdbc:mysql://localhost:3306/lab9_no7";
    private static String user = "root";
    private static String password = "";
    private static Statement sql;
    JPanel header = new JPanel();
    JPanel body = new JPanel();
    JPanel footer = new JPanel();
    Listener spyListener = new Listener();
    String[] Days = { "01", "02" , "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    String[] Months = {
            "01", "02" , "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"
    };

    // field
    JTextField inputId;
    JTextField inputMoney;
    JTextField inputRate;
    JComboBox<String> inputDateOpenAccountDay;
    JComboBox<String> inputDateOpenAccountMonth;
    JComboBox<String> inputDateOpenAccountYears;
    JTextField inputFirstName;
    JTextField inputLastName;
    JComboBox<String> inputBdDay;
    JComboBox<String> inputBdMonth;
    JComboBox<String> inputBdYears;
    JTextField inputAge;

    public LAB9_No7(String Title) {
        super(Title);
        setLayout(new BorderLayout());
        setHeader();
        setBody();
        setFooter();
        setLayoutMain();
        setDefult(this);
    }

    void setLayoutMain() {
        add(header, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    void setHeader() {
        header.setLayout(new BorderLayout());
        JLabel title = new JLabel("ACCOUNT MONEY");
        title.setHorizontalAlignment(JLabel.CENTER);
        header.add(title, BorderLayout.CENTER);
    }

    void setFooter() {
        footer.setLayout(new BorderLayout());
        JPanel footerLayout = new JPanel();
        footerLayout.setLayout(new FlowLayout());
        JButton save = new JButton("SAVE");
        setAction(save);
        JButton show = new JButton("SHOW");
        setAction(show);
        save.setHorizontalAlignment(JButton.RIGHT);
        show.setHorizontalAlignment(JButton.LEFT);
        footerLayout.add(save);
        footerLayout.add(show);
        footer.add(footerLayout, BorderLayout.EAST);
    };

    void setBody() {
        body.setLayout(new BorderLayout());
        JPanel bodyLayout = new JPanel();
        bodyLayout.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel titleBody = new JPanel();
        titleBody.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("Enter Data Account Money");
        title.setHorizontalAlignment(JLabel.LEFT);
        titleBody.add(title);
        body.add(titleBody, BorderLayout.NORTH);

        JPanel form1 = new JPanel();
        form1.setLayout(new FlowLayout());
        JLabel id = new JLabel("ID : ");
        inputId = new JTextField(10);
        setAction(inputId);
        JLabel money = new JLabel("MONEY :");
        inputMoney = new JTextField(10);
        setAction(inputMoney);
        JLabel bath = new JLabel("BATH :");
        form1.add(id);
        form1.add(inputId);
        form1.add(money);
        form1.add(inputMoney);
        form1.add(bath);
        bodyLayout.add(form1);

        JPanel form2 = new JPanel();
        form2.setLayout(new FlowLayout());
        JLabel rate = new JLabel("ANNUAL INTEREST RATE : ");
        inputRate = new JTextField(10);
        setAction(inputRate);
        form2.add(rate);
        form2.add(inputRate);
        bodyLayout.add(form2);

        JPanel form3 = new JPanel();
        form3.setLayout(new FlowLayout());
        JLabel dateOpenAccount = new JLabel("DAY OPEN ACCOUNT : ");
        inputDateOpenAccountDay = new JComboBox<>(Days);
        setAction(inputDateOpenAccountDay);
        inputDateOpenAccountDay.insertItemAt("day", 0);
        inputDateOpenAccountDay.setSelectedIndex(0);
        inputDateOpenAccountMonth = new JComboBox<>(Months);
        setAction(inputDateOpenAccountMonth);
        inputDateOpenAccountMonth.insertItemAt("month", 0);
        inputDateOpenAccountMonth.setSelectedIndex(0);
        form3.add(dateOpenAccount);
        form3.add(inputDateOpenAccountDay);
        form3.add(inputDateOpenAccountMonth);
        bodyLayout.add(form3);

        JPanel form4 = new JPanel();
        form4.setLayout(new FlowLayout());
        inputDateOpenAccountYears = new JComboBox<>();
        setAction(inputDateOpenAccountYears);
        for (int i = 1900; i <= 2024; i++) {
            inputDateOpenAccountYears.addItem("" + i);
        }
        inputDateOpenAccountYears.insertItemAt("year", 0);
        inputDateOpenAccountYears.setSelectedIndex(0);
        form4.add(inputDateOpenAccountYears);
        JLabel firstName = new JLabel("FIRST NAME : ");
        inputFirstName = new JTextField(15);
        setAction(inputFirstName);
        form4.add(firstName);
        form4.add(inputFirstName);
        bodyLayout.add(form4);

        JPanel form5 = new JPanel();
        form5.setLayout(new FlowLayout());
        JLabel lastName = new JLabel("LAST NAME : ");
        inputLastName = new JTextField(15);
        setAction(inputLastName);
        form5.add(lastName);
        form5.add(inputLastName);
        bodyLayout.add(form5);

        JPanel form6 = new JPanel();
        form6.setLayout(new FlowLayout());
        JLabel bd = new JLabel("BIRTHDAY : ");
        inputBdDay = new JComboBox<>(Days);
        setAction(inputBdDay);
        inputBdDay.insertItemAt("day", 0);
        inputBdDay.setSelectedIndex(0);
        inputBdMonth = new JComboBox<>(Months);
        setAction(inputBdMonth);
        inputBdMonth.insertItemAt("month", 0);
        inputBdMonth.setSelectedIndex(0);
        inputBdYears = new JComboBox<>();
        setAction(inputBdYears);
        for (int i = 1900; i <= 2024; i++) {
            inputBdYears.addItem("" + i);
        }
        inputBdYears.insertItemAt("year", 0);
        inputBdYears.setSelectedIndex(0);
        form6.add(bd);
        form6.add(inputBdDay);
        form6.add(inputBdMonth);
        form6.add(inputBdYears);
        bodyLayout.add(form6);

        JPanel form7 = new JPanel();
        form7.setLayout(new FlowLayout());
        JLabel age = new JLabel("AGE : ");
        inputAge = new JTextField(10);
        setAction(inputAge);
        JLabel year = new JLabel("YEAR");
        form7.add(age);
        form7.add(inputAge);
        form7.add(year);
        bodyLayout.add(form7);

        body.add(bodyLayout, BorderLayout.CENTER);

    }

    void setAction(JTextField textField) {
        textField.addActionListener(spyListener);
    }

    void setAction(JButton button) {
        button.addActionListener(spyListener);
    }

    void setAction(JComboBox<String> comboBox) {
        comboBox.addActionListener(spyListener);
    }

    void setDefult(JFrame window) {
        window.setSize(385, 380);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String cmd = e.getActionCommand();
            if (cmd.equals("SAVE")) {
                if (inputId.getText().equals("") 
                        || inputMoney.getText().equals("")
                        || inputRate.getText().equals("")
                        || inputDateOpenAccountDay.getSelectedIndex() == 0
                        || inputDateOpenAccountMonth.getSelectedIndex() == 0
                        || inputDateOpenAccountYears.getSelectedIndex() == 0 
                        || inputFirstName.getText().equals("")
                        || inputLastName.getText().equals("") 
                        || inputBdDay.getSelectedIndex() == 0
                        || inputBdMonth.getSelectedIndex() == 0 
                        || inputBdYears.getSelectedIndex() == 0
                        || inputAge.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the information", "Warning",
                    JOptionPane.WARNING_MESSAGE);
                }else{
                    String checkTable = "SELECT * FROM accounts_money";
                    try{
                        sql.executeQuery(checkTable);
                    }catch(Exception ex){
                        String createTable = "CREATE TABLE accounts_money (id INT PRIMARY KEY, money DOUBLE, rate DOUBLE, date_open_account DATE, first_name VARCHAR(255), last_name VARCHAR(255), bd DATE, age INT)";
                        try{
                            sql.executeUpdate(createTable);
                        }catch(Exception e1){
                            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    try {
                        String id = inputId.getText();
                        String money = inputMoney.getText();
                        String rate = inputRate.getText();
                        String dateOpenAccount = inputDateOpenAccountYears.getSelectedItem() + "-"
                                + inputDateOpenAccountMonth.getSelectedItem() + "-" + inputDateOpenAccountDay.getSelectedItem();
                        String firstName = inputFirstName.getText();
                        String lastName = inputLastName.getText();
                        String bd = inputBdYears.getSelectedItem() + "-" + inputBdMonth.getSelectedItem() + "-"
                                + inputBdDay.getSelectedItem();
                        String age = inputAge.getText();
                        String sqlInsert = "INSERT INTO accounts_money (id, money, rate, date_open_account, first_name, last_name, bd, age) VALUES ('"
                                + Integer.parseInt(id) + "', '" + Double.parseDouble(money) + "', '" + Double.parseDouble(rate) + "', '" + dateOpenAccount + "', '" + firstName
                                + "', '" + lastName + "', '" + bd + "', '" + Integer.parseInt(age) + "')";
                        sql.executeUpdate(sqlInsert);
                        JOptionPane.showMessageDialog(null, "Save data successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }   
                }

            }else if ((cmd.equals("SHOW"))){
                if(inputId.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill in ID", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    try{
                        String query = "SELECT * FROM accounts_money WHERE id = " + Integer.parseInt(inputId.getText());
                        ResultSet rs = sql.executeQuery(query);
                        String text = "";
                        while (rs.next()) {
                            String firtname = rs.getString("first_name");
                            String lastname = rs.getString("last_name");
                            double money = rs.getDouble("money");
                            text = "First Name : " + firtname + "\n" + "Last Name : " + lastname + "\n" + "Money : " + money;
                        }
                        if (text.equals("")) {
                            JOptionPane.showMessageDialog(null, "Not found", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, text, "Show Details Account Money", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Create a frame
        new LAB9_No7("Show Details Account Money");

        // Connect to the database

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);

        if (con != null) {
            System.out.println("Connected to the database");
        }

        sql = con.createStatement();

    }
}
