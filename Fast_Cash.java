import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class Fast_Cash extends JFrame implements ActionListener {

    JLabel Text;
    JButton b100, b1000, b5000, b500, b2000, b10000, back;
    String CardNumber, PINnum;

    Fast_Cash(String CardNumber, String PINnum) {

        this.CardNumber = CardNumber;
        this.PINnum = PINnum;

        setTitle("ATM");
        setLocationRelativeTo(null);
        setLayout(null);

        // ********************************************* Image
        // *************************************

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 950, Image.SCALE_DEFAULT);
        ImageIcon ATM_Image = new ImageIcon(i2);
        JLabel img = new JLabel(ATM_Image);
        img.setBounds(140, 0, 1000, 800);
        add(img);

        // ******************************************** JLabel
        // **********************************

        Text = new JLabel("Select Withdrawal Amount");
        Text.setBounds(270, 250, 300, 30);
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("System", Font.BOLD, 15));
        img.add(Text);

        // ******************************************** JButton
        // **************************************

        // JButton Dep, Fst_Csh, Pin_Ch, Csh_withdrawl, mini_stat, Blnc_enq, exit;

        b100 = new JButton("Rs 100");
        b100.setBounds(205, 368, 150, 30);
        b100.setFocusable(false);
        b100.setFont(new Font("Raleway", Font.BOLD, 15));
        b100.setBorder(BorderFactory.createEmptyBorder());
        b100.addActionListener(this);
        img.add(b100);

        b1000 = new JButton("Rs 1000");
        b1000.setBounds(205, 402, 150, 30);
        b1000.setFocusable(false);
        b1000.setFont(new Font("Raleway", Font.BOLD, 15));
        b1000.setBorder(BorderFactory.createEmptyBorder());
        b1000.addActionListener(this);
        img.add(b1000);

        b5000 = new JButton("Rs 5000");
        b5000.setBounds(205, 438, 150, 30);
        b5000.setFocusable(false);
        b5000.setFont(new Font("Raleway", Font.BOLD, 15));
        b5000.setBorder(BorderFactory.createEmptyBorder());
        b5000.addActionListener(this);
        img.add(b5000);

        b500 = new JButton("Rs 500");
        b500.setBounds(405, 368, 150, 30);
        b500.setFocusable(false);
        b500.setFont(new Font("Raleway", Font.BOLD, 15));
        b500.setBorder(BorderFactory.createEmptyBorder());
        b500.addActionListener(this);
        img.add(b500);

        b2000 = new JButton("Rs 2000");
        b2000.setBounds(405, 401, 150, 30);
        b2000.setFocusable(false);
        b2000.setFont(new Font("Raleway", Font.BOLD, 15));
        b2000.setBorder(BorderFactory.createEmptyBorder());
        b2000.addActionListener(this);
        img.add(b2000);

        b10000 = new JButton("Rs 10000");
        b10000.setBounds(405, 435, 150, 30);
        b10000.setFocusable(false);
        b10000.setFont(new Font("Raleway", Font.BOLD, 15));
        b10000.setBorder(BorderFactory.createEmptyBorder());
        b10000.addActionListener(this);
        img.add(b10000);

        back = new JButton("BACK");
        back.setBounds(405, 468, 150, 30);
        back.setFocusable(false);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        img.add(back);

        // *********************************************************************************************
        setUndecorated(true);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == back) {

            setVisible(false);
            new transactions(CardNumber, PINnum);

        } else {

            String amount = ((JButton) ae.getSource()).getText().substring(3);

            LocalDate d = LocalDate.now();
            LocalTime IST = LocalTime.now();

            try {
                Conn conn = new Conn();

                String query1 = "Select * from total_amt where Card_Number = '" + CardNumber + "';";

                ResultSet rs = conn.s.executeQuery(query1);
                if (rs.next()) {
                    double amt = Double.parseDouble(rs.getString("Total_Amount"));

                    if (amt > Double.parseDouble(amount)) {

                        amt = amt - Double.parseDouble(amount);
                        String fa = Double.toString(amt);

                        String query2 = "insert into transactions values ('" + CardNumber + "', ' Withdraw ', '"
                                + amount
                                + "','" + d + "','" + IST + " '); ";

                        conn.s.executeUpdate(query2);

                        String query3 = "update total_amt set Total_Amount = '" + fa + "' where Card_Number = '"
                                + CardNumber + "';";
                        conn.s.executeUpdate(query3);

                        JOptionPane.showMessageDialog(null, amount + " is Debeted from your account");

                    } else {

                        JOptionPane.showMessageDialog(null,
                                "Your Current Balance is " + amt + " which is less then Withdrawal amount");
                    }
                }

            } catch (Exception e) {

                System.out.println(e);

            }
        }

    }

    public static void main(String[] args) {
        new Fast_Cash("", "");
    }
}
