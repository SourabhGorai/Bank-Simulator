import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.sql.*;

public class withdraw extends JFrame implements ActionListener {

    JLabel Text;
    JTextField amt;
    JButton wtdr, Back;
    String PINum, CardNumber;

    withdraw(String CardNumber, String PINnum) {
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

        Text = new JLabel("Enter the amount you want to withdraw");
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

        wtdr = new JButton("Withdraw");
        wtdr.setBounds(405, 440, 150, 30);
        wtdr.setFocusable(false);
        wtdr.setFont(new Font("Raleway", Font.BOLD, 12));
        wtdr.setBorder(BorderFactory.createEtchedBorder());
        wtdr.addActionListener(this);
        img.add(wtdr);

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
        LocalDate d = LocalDate.now();
        LocalTime IST = LocalTime.now();
        if (ae.getSource() == Back) {
            setVisible(false);
            new transactions(CardNumber, PINum).setVisible(true);
        } else if (ae.getSource() == wtdr) {

            String withdraw_amount = amt.getText();

            if (withdraw_amount.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");

            } else {

                try {
                    Conn conn = new Conn();
                    String query1 = "select * from total_amt where Card_Number = '" + CardNumber + "';";
                    ResultSet rs = conn.s.executeQuery(query1);

                    if (rs.next()) {
                        double d_amt = Double.parseDouble(rs.getString("Total_Amount"));
                        double d_FieldAmt = Double.parseDouble(withdraw_amount);

                        if (d_amt >= d_FieldAmt) {
                            d_amt = d_amt - d_FieldAmt;
                            String d_amt2 = Double.toString(d_amt);

                            String query2 = "insert into transactions values ('" + CardNumber + "', ' Withdraw ', '"
                                    + d_FieldAmt + "','" + d + "','" + IST + " '); ";

                            String query3 = "update total_amt set Total_Amount = '" + d_amt2 + "' where Card_Number = '"
                                    + CardNumber + "';";

                            conn.s.executeUpdate(query2);
                            conn.s.executeUpdate(query3);

                            JOptionPane.showMessageDialog(null, "Rs " + withdraw_amount + " debited successfully");

                            amt.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Your Current Balance is " + d_amt + " which is less than the withdrawal amount");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Card Number not found: " + CardNumber);
                    }

                    conn.s.close();
                    conn.c.close();
                } catch (SQLException | NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error processing withdrawal: " + e.getMessage());
                }

            }

        }
    }

    public static void main(String[] args) {
        new withdraw("", "");
    }
}
