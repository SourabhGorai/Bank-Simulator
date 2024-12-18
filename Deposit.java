import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {

    JLabel Text;
    JTextField amt;
    JButton deposit, Back;
    String PINum, CardNumber;

    Deposit(String PINnum, String CardNumber) {
        setTitle("ATM");
        setLocationRelativeTo(null);
        setLayout(null);
        this.PINum = PINnum;
        this.CardNumber = CardNumber;

        // **********************************************************Image

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 950, Image.SCALE_DEFAULT);
        ImageIcon ATM_Image = new ImageIcon(i2);
        JLabel img = new JLabel(ATM_Image);
        img.setBounds(140, 0, 1000, 800);
        add(img);

        // ******************************************************** Jlabel

        Text = new JLabel("Enter the amount you want to deposit");
        Text.setBounds(234, 250, 300, 30);
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("System", Font.BOLD, 15));
        img.add(Text);

        // ********************************************************* JTextField

        amt = new JTextField();
        amt.setBounds(220, 300, 320, 30);
        amt.setFont(new Font("Raleway", Font.PLAIN, 14));
        amt.setBorder(BorderFactory.createEmptyBorder());
        img.add(amt);

        // ********************************************************** JButton

        deposit = new JButton("Deposit");
        deposit.setBounds(405, 440, 150, 30);
        deposit.setFocusable(false);
        deposit.setFont(new Font("Raleway", Font.BOLD, 12));
        deposit.setBorder(BorderFactory.createEtchedBorder());
        deposit.addActionListener(this);
        img.add(deposit);

        Back = new JButton("BACK");
        Back.setBounds(405, 475, 150, 30);
        Back.setFocusable(false);
        Back.setFont(new Font("Raleway", Font.BOLD, 12));
        Back.setBorder(BorderFactory.createEtchedBorder());
        Back.addActionListener(this);
        img.add(Back);

        // ****************************************************************

        setUndecorated(true);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Back) {
            setVisible(false);
            new transactions(CardNumber, PINum).setVisible(true);
        } else if (ae.getSource() == deposit) {
            String Deposit_amt = amt.getText();

            if (Deposit_amt.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {

                LocalDate d = LocalDate.now();
                LocalTime IST = LocalTime.now();

                try {
                    Conn conn = new Conn();
                    String query1 = "insert into transactions values ('" + CardNumber + "', ' Deposit ', '"
                            + Deposit_amt
                            + "','" + d + "','" + IST + " '); ";

                    conn.s.executeUpdate(query1);

                    String query2 = "Select * from total_amt where Card_Number = '" + CardNumber + "';";

                    ResultSet rs = conn.s.executeQuery(query2);
                    if (rs.next()) {
                        double amt = Double.parseDouble(rs.getString("Total_Amount"));
                        amt = amt + Double.parseDouble(Deposit_amt);
                        String fa = Double.toString(amt);

                        String query3 = "update total_amt set Total_Amount = '" + fa + "' where Card_Number = '"
                                + CardNumber + "';";
                        conn.s.executeUpdate(query3);

                    }else{
                        String query4 = "insert into total_amt values ('" + CardNumber + "', '"+ Deposit_amt + "');";
                        conn.s.executeUpdate(query4);
                    }
                    // String query2 = "insert into total_amt values ('" + CardNumber + "', '" +

                    JOptionPane.showMessageDialog(null, "Rs. " + Deposit_amt + " added successfully");
                    amt.setText("");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
    }

    public static void main(String[] args) {
        new Deposit("", "");
    }
}
