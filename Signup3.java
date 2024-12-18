import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
// import java.sql.*;

public class Signup3 extends JFrame implements ActionListener {

    JLabel heading, acc_type, card_no, card_no2, pin, text2, service_req, card_Val, pin_val;
    JRadioButton Recurring_dep_acc, fixed_deposit_acc, curr_acc, savings_acc;
    JButton back, Submit, Cancel;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formNo;

    Signup3(String formNo) {
        setVisible(true);
        setTitle("SignUp Page 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setSize(600, 800);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(null);
        // setLocation(350, 0);
        this.formNo = formNo;

        heading = new JLabel("Page 3 : Account Details");
        heading.setBounds(470, 40, 400, 35);
        heading.setFont(new Font("Osward", Font.BOLD, 30));
        add(heading);

        acc_type = new JLabel("Account Type");
        acc_type.setBounds(380, 130, 170, 30);
        acc_type.setFont(new Font("Osward", Font.BOLD, 25));
        add(acc_type);

        card_no = new JLabel("Card Number :");
        card_no.setBounds(380, 280, 150, 30);
        card_no.setFont(new Font("Osward", Font.BOLD, 20));
        add(card_no);

        card_no2 = new JLabel("Your 16 Digit Card Number");
        card_no2.setBounds(382, 305, 220, 30);
        card_no2.setFont(new Font("Osward", Font.PLAIN, 13));
        add(card_no2);

        card_Val = new JLabel("XXXX-XXXX-XXXX-6897");
        card_Val.setBounds(630, 280, 350, 30);
        card_Val.setFont(new Font("Raleway", Font.BOLD, 20));
        add(card_Val);

        pin = new JLabel("PIN :");
        pin.setBounds(380, 355, 220, 30);
        pin.setFont(new Font("Osward", Font.BOLD, 20));
        add(pin);

        pin_val = new JLabel("XXXX");
        pin_val.setBounds(630, 355, 220, 30);
        pin_val.setFont(new Font("Osward", Font.BOLD, 20));
        add(pin_val);

        text2 = new JLabel("Enter 4 Digit Password");
        text2.setBounds(382, 377, 220, 30);
        text2.setFont(new Font("Osward", Font.PLAIN, 13));
        add(text2);

        service_req = new JLabel("Services Required :");
        service_req.setBounds(380, 447, 220, 30);
        service_req.setFont(new Font("Osward", Font.BOLD, 20));
        add(service_req);

        // **************************************** Radio Buttons
        // ******************************

        savings_acc = new JRadioButton("Savings Account");
        savings_acc.setBounds(380, 170, 180, 30);
        savings_acc.setFont(new Font("Osward", Font.BOLD, 15));
        savings_acc.setFocusable(false);
        add(savings_acc);

        curr_acc = new JRadioButton("Current Account");
        curr_acc.setBounds(380, 210, 150, 30);
        curr_acc.setFont(new Font("Osward", Font.BOLD, 15));
        curr_acc.setFocusable(false);
        add(curr_acc);

        fixed_deposit_acc = new JRadioButton("Fixed Deposit Account");
        fixed_deposit_acc.setBounds(700, 170, 250, 30);
        fixed_deposit_acc.setFont(new Font("Osward", Font.BOLD, 15));
        fixed_deposit_acc.setFocusable(false);
        add(fixed_deposit_acc);

        Recurring_dep_acc = new JRadioButton("Recurring Deposit Account");
        Recurring_dep_acc.setBounds(700, 210, 250, 30);
        Recurring_dep_acc.setFont(new Font("Osward", Font.BOLD, 15));
        Recurring_dep_acc.setFocusable(false);
        add(Recurring_dep_acc);

        ButtonGroup accs = new ButtonGroup();
        accs.add(savings_acc);
        accs.add(curr_acc);
        accs.add(fixed_deposit_acc);
        accs.add(Recurring_dep_acc);

        // ************************************* Buttons *****************************

        back = new JButton("BACK");
        back.setBounds(448, 710, 100, 30);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEtchedBorder());
        back.addActionListener(this);
        add(back);
        
        Submit = new JButton("Submit");
        Submit.setBounds(595, 710, 100, 30);
        Submit.setBorder(BorderFactory.createEtchedBorder());
        Submit.setFocusable(false);
        Submit.addActionListener(this);
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(740, 710, 100, 30);
        Cancel.setBorder(BorderFactory.createEtchedBorder());
        Cancel.setFocusable(false);
        Cancel.addActionListener(this);
        add(Cancel);

        // ********************************** Check Box *******************************

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(380, 480, 200, 30);
        c1.setFont(new Font("Osward", Font.BOLD, 15));
        c1.setFocusable(false);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(680, 480, 200, 30);
        c2.setFont(new Font("Osward", Font.BOLD, 15));
        c2.setFocusable(false);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(380, 510, 200, 30);
        c3.setFont(new Font("Osward", Font.BOLD, 15));
        c3.setFocusable(false);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(680, 510, 200, 30);
        c4.setFont(new Font("Osward", Font.BOLD, 15));
        c4.setFocusable(false);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(380, 540, 200, 30);
        c5.setFont(new Font("Osward", Font.BOLD, 15));
        c5.setFocusable(false);
        add(c5);

        c6 = new JCheckBox("E-Statements");
        c6.setBounds(680, 540, 200, 30);
        c6.setFont(new Font("Osward", Font.BOLD, 15));
        c6.setFocusable(false);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBounds(300, 650, 700, 30);
        c7.setFont(new Font("Osward", Font.BOLD, 15));
        c7.setFocusable(false);
        add(c7);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == Submit) {

            String Account_Type = null;
            if (savings_acc.isSelected()) {
                Account_Type = "Savings Account";
            } else if (curr_acc.isSelected()) {
                Account_Type = "Current Account";
            } else if (fixed_deposit_acc.isSelected()) {
                Account_Type = "Fixed Deposit Account";
            } else if (Recurring_dep_acc.isSelected()) {
                Account_Type = "Recurring Deposit Account";
            } else {
                Account_Type = "";
            }

            Random r = new Random();
            String Account_Number = "" + (5040936000000000L + r.nextLong(900000000L));
            String PIN = "" + (1000 + r.nextInt(9000));

            String Services_Required = "";
            if (c1.isSelected()) {
                Services_Required = Services_Required + " ATM CARD";
            }
            if (c2.isSelected()) {
                Services_Required = Services_Required + " Internet Banking";
            }
            if (c3.isSelected()) {
                Services_Required = Services_Required + " Mobile Banking";
            }
            if (c4.isSelected()) {
                Services_Required = Services_Required + " Email & SMS Alerts";
            }
            if (c5.isSelected()) {
                Services_Required = Services_Required + " Cheque Book";
            }
            if (c6.isSelected()) {
                Services_Required = Services_Required + " E-Statement";
            }

            try {
                if (Account_Type.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is not Selected");
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Check the declaration box");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signup3 values('" + formNo + "' , '" + Account_Type + "' , '"
                            + Account_Number + "' , '"
                            + PIN + "' , '" + Services_Required + "');";

                    String query2 = "insert into login values('" + formNo + "' , '" + Account_Number + "' , '"
                            + PIN + "');";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,
                            "Sign UP Successfull" + "\n" + "Card Number: " + Account_Number + "\n" + "PIN: " + PIN);

                    setVisible(false);
                    new login().setVisible(true);

                }

            } catch (Exception e1) {
                System.out.println(e1);
            }

        } else if (a.getSource() == Cancel) {
            try {
                Conn conn = new Conn();
                String query1 = "delete from signup where formNo = " + formNo + ";";
                String query2 = "delete from signup_page2 where formNo = " + formNo + ";";

                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query1);

                setVisible(false);
                new login().setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(a.getSource()==back){
            setVisible(false);
            new Signup2(formNo).setVisible(true);;
        }

    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
