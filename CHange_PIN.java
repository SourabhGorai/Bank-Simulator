import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CHange_PIN extends JFrame implements ActionListener {

    JLabel text1, text2, text3;
    JPasswordField np, re_np;
    String CardNumber, PINnum;
    JButton chng, bck;

    CHange_PIN(String CardNumber, String PINnum) {

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

        // ******************************************************** Jlabel

        text1 = new JLabel("CHANGE YOUR PIN");
        text1.setBounds(290, 220, 300, 30);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System", Font.BOLD, 18));
        img.add(text1);

        text2 = new JLabel("New PIN:");
        text2.setBounds(210, 268, 150, 30);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System", Font.BOLD, 15));
        img.add(text2);

        text3 = new JLabel("Re-Enter New PIN:");
        text3.setBounds(210, 308, 300, 30);
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("System", Font.BOLD, 15));
        img.add(text3);

        // *********************************************************** TextField

        np = new JPasswordField();
        np.setBounds(520, 270, 180, 25);
        np.setBorder(BorderFactory.createEmptyBorder());
        np.setFont(new Font("Raleway", Font.BOLD, 15));
        add(np);

        re_np = new JPasswordField();
        re_np.setBounds(520, 310, 180, 25);
        re_np.setBorder(BorderFactory.createEmptyBorder());
        re_np.setFont(new Font("Raleway", Font.BOLD, 15));
        add(re_np);

        // *********************************************************** JButton

        chng = new JButton("CHANGE");
        chng.setBounds(430, 442, 130, 25);
        chng.setFocusable(false);
        chng.setFont(new Font("Raleway", Font.BOLD, 14));
        chng.setBorder(BorderFactory.createEmptyBorder());
        chng.addActionListener(this);
        img.add(chng);

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
            new transactions(CardNumber, PINnum);

        } else if (ae.getSource() == chng) {

            if (np.getText().equals(re_np.getText()) && np.getText().length() == 4) {

                String newPIN = np.getText();
                String query1 = "update signup3 set PIN = '" + newPIN + "' where PIN = '" + PINnum + "';";
                String query2 = "update login set PIN = '" + newPIN + "' where PIN = '" + PINnum + "';";

                try {
                    Conn conn = new Conn();
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "PIN Change Successfull");
                    np.setText("");
                    re_np.setText("");
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {

                if (!np.getText().equals(re_np.getText())) {

                    JOptionPane.showMessageDialog(null, "PIN does not match");

                } else if (np.getText().length() != 4) {

                    JOptionPane.showMessageDialog(null, "PIN can not be greater than 4 digits");
                }

            }

        }

    }

    public static void main(String[] args) {
        new CHange_PIN("", "");
    }
}
