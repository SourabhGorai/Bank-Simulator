import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton bck;
    String CardNumber, PINnum, total_amount;

    BalanceEnquiry(String CardNumber, String PINnum) {

        this.CardNumber = CardNumber;
        this.PINnum = PINnum;

        setTitle("ATM");
        setLocationRelativeTo(null);
        setLayout(null);

        // **********************************************************Image

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 950, Image.SCALE_DEFAULT);
        ImageIcon ATM_Image = new ImageIcon(i2);
        JLabel img = new JLabel(ATM_Image);
        img.setBounds(140, 0, 1000, 800);
        add(img);

        // *********************************************************** Query

        String query = "select * from total_amt where Card_Number = '" + CardNumber + "';";
        Conn conn = new Conn();
        
        try {
            ResultSet r = conn.s.executeQuery(query);

            if (r.next()) { // Move the cursor to the first row
                total_amount = r.getString("Total_Amount");
                
            } else {
                JOptionPane.showMessageDialog(null, "No data found for Card Number: " + CardNumber);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        // *********************************************************** JLabel

        JLabel text = new JLabel("Your Current Account Balance is Rs "+ total_amount);
        text.setBounds(200, 240, 300, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        img.add(text);

        // *********************************************************** JButton

        bck = new JButton("BACK");
        bck.setBounds(430, 477, 130, 25);
        bck.setFocusable(false);
        bck.setFont(new Font("Raleway", Font.BOLD, 14));
        bck.setBorder(BorderFactory.createEmptyBorder());
        bck.addActionListener(this);
        img.add(bck);

        // ****************************************************************

        setUndecorated(true);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bck) {
            setVisible(false);
            new transactions(CardNumber, PINnum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("", "");
    }

}
