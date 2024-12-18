import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JButton login, Clear, Signup;
    JTextField cardField;
    JPasswordField PINField;

    login() {
        setTitle("Automated Teller Machine");
        // setVisible(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setBounds(100, 100, 1000, 500);
        // setLocation(100, 200);
        setLayout(null);
        setResizable(true);

        // getContentPane().setBackground(Color.WHITE);

        ImageIcon bank_img = new ImageIcon(ClassLoader.getSystemResource("images/bank.png"));
        Image bank_img2 = bank_img.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
        ImageIcon bank_img3 = new ImageIcon(bank_img2);

        JLabel label1 = new JLabel(bank_img3);
        label1.setBounds(200, 130, 140, 140);
        add(label1);

        JLabel heading = new JLabel("Welcome to ATM");
        heading.setBounds(400, 170, 500, 40);
        heading.setFont(new Font("Osward", Font.BOLD, 50));
        add(heading);

        JLabel card_no = new JLabel("Card No : ");
        card_no.setBounds(270, 350, 250, 40);
        card_no.setFont(new Font("Osward", Font.BOLD, 30));
        add(card_no);

        JLabel PIN = new JLabel("PIN : ");
        PIN.setBounds(270, 450, 250, 40);
        PIN.setFont(new Font("Osward", Font.BOLD, 30));
        add(PIN);

        cardField = new JTextField();
        cardField.setBounds(500, 355, 220, 35);
        cardField.setFont(new Font("Raleway", Font.PLAIN, 20));
        cardField.setBorder(BorderFactory.createEtchedBorder());
        cardField.setEditable(true);
        add(cardField);

        PINField = new JPasswordField();
        PINField.setBorder(BorderFactory.createEtchedBorder());
        PINField.setEchoChar('*');
        PINField.setFont(new Font("Raleway", Font.PLAIN, 20));
        PINField.setBounds(500, 455, 220, 35);
        PINField.setEditable(true);
        add(PINField);

        login = new JButton("SIGN IN");
        login.setBounds(500, 555, 100, 35);
        login.setBorder(BorderFactory.createEtchedBorder());
        login.addActionListener(this);
        login.setFocusable(false);
        add(login);

        Clear = new JButton("CLEAR");
        Clear.setBounds(620, 555, 100, 35);
        Clear.setBorder(BorderFactory.createEtchedBorder());
        Clear.addActionListener(this);
        Clear.setFocusable(false);
        add(Clear);

        Signup = new JButton("SIGN UP");
        Signup.setBounds(500, 605, 220, 35);
        Signup.setBorder(BorderFactory.createEtchedBorder());
        Signup.addActionListener(this);
        Signup.setFocusable(false);
        add(Signup);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Clear) {
            cardField.setText("");
            PINField.setText("");
        } else if (e.getSource() == login) {

            Conn conn = new Conn();
            String cardNum = cardField.getText();
            String PINNumber = PINField.getText();

            String query = "SELECT * FROM login where Card_Number = '" + cardNum + "' AND PIN = '" + PINNumber + "';";

            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){                                         // rs.next() means kya data nikal k aya hai ?
                    setVisible(false);
                    new transactions(cardNum,PINNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource() == Signup) {
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new login();
    }
}
