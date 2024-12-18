import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Locale.Category;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

class Signup1 extends JFrame implements ActionListener {

    int random;
    JTextField name_field, Fathers_name_field, email_field, add_field, city_field, state_field, pin_field;
    JButton back, next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    String FN;

    Signup1() {
        setTitle("Signup page 1");
        setResizable(true);

        setLocationRelativeTo(null);
        setLayout(null);

        Random r = new Random();
        random = (1000 + r.nextInt(9000));
        // System.out.println(1000 + r.nextInt(9000));

        // ******************************************** JLabel
        // *****************************************

        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Osward", Font.BOLD, 40));
        formNo.setBounds(350, 20, 600, 50);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Osward", Font.BOLD, 25));
        personalDetails.setBounds(500, 80, 400, 50);
        add(personalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Osward", Font.BOLD, 20));
        name.setBounds(280, 180, 100, 20);
        add(name);

        JLabel Father_name = new JLabel("Father's  Name :");
        Father_name.setFont(new Font("Osward", Font.BOLD, 20));
        Father_name.setBounds(280, 230, 200, 20);
        add(Father_name);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Osward", Font.BOLD, 20));
        dob.setBounds(280, 280, 200, 20);
        add(dob);

        JLabel Gender = new JLabel("Gender :");
        Gender.setFont(new Font("Osward", Font.BOLD, 20));
        Gender.setBounds(280, 330, 200, 20);
        add(Gender);

        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Osward", Font.BOLD, 20));
        email.setBounds(280, 380, 200, 20);
        add(email);

        JLabel ms = new JLabel("Marital Status :");
        ms.setFont(new Font("Osward", Font.BOLD, 20));
        ms.setBounds(280, 430, 200, 20);
        add(ms);

        JLabel Address = new JLabel("Address :");
        Address.setFont(new Font("Osward", Font.BOLD, 20));
        Address.setBounds(280, 480, 200, 20);
        add(Address);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Osward", Font.BOLD, 20));
        city.setBounds(280, 530, 200, 20);
        add(city);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Osward", Font.BOLD, 20));
        state.setBounds(280, 580, 200, 20);
        add(state);

        JLabel pin_code = new JLabel("PIN Code :");
        pin_code.setFont(new Font("Osward", Font.BOLD, 20));
        pin_code.setBounds(280, 630, 200, 20);
        add(pin_code);

        // ******************************************* JRadioButton
        // ************************************

        male = new JRadioButton("Male");
        male.setBounds(550, 330, 200, 27);
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(750, 330, 200, 27);
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        add(female);

        ButtonGroup grp = new ButtonGroup();
        grp.add(male);
        grp.add(female);

        married = new JRadioButton("Married");
        married.setBounds(550, 430, 100, 27);
        married.setFont(new Font("Raleway", Font.BOLD, 15));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(710, 430, 150, 27);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(880, 430, 100, 27);
        other.setFont(new Font("Raleway", Font.BOLD, 15));
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        // ******************************************* JDateChooser
        // ************************************

        dateChooser = new JDateChooser();
        dateChooser.setBounds(550, 280, 400, 27);
        add(dateChooser);

        // ****************************************** JTextField
        // ************************************

        name_field = new JTextField();
        name_field.setFont(new Font("Raleway", Font.PLAIN, 17));
        name_field.setBounds(550, 180, 400, 27);
        name_field.setBorder(BorderFactory.createEtchedBorder());
        add(name_field);

        Fathers_name_field = new JTextField();
        Fathers_name_field.setFont(new Font("Raleway", Font.PLAIN, 17));
        Fathers_name_field.setBounds(550, 230, 400, 27);
        Fathers_name_field.setBorder(BorderFactory.createEtchedBorder());
        add(Fathers_name_field);

        email_field = new JTextField();
        email_field.setFont(new Font("Raleway", Font.PLAIN, 17));
        email_field.setBounds(550, 380, 400, 27);
        email_field.setBorder(BorderFactory.createEtchedBorder());
        add(email_field);

        add_field = new JTextField();
        add_field.setFont(new Font("Raleway", Font.PLAIN, 17));
        add_field.setBounds(550, 480, 400, 27);
        add_field.setBorder(BorderFactory.createEtchedBorder());
        add(add_field);

        city_field = new JTextField();
        city_field.setFont(new Font("Raleway", Font.PLAIN, 17));
        city_field.setBounds(550, 530, 400, 27);
        city_field.setBorder(BorderFactory.createEtchedBorder());
        add(city_field);

        state_field = new JTextField();
        state_field.setFont(new Font("Raleway", Font.PLAIN, 17));
        state_field.setBounds(550, 580, 400, 27);
        state_field.setBorder(BorderFactory.createEtchedBorder());
        add(state_field);

        pin_field = new JTextField();
        pin_field.setFont(new Font("Raleway", Font.PLAIN, 17));
        pin_field.setBounds(550, 630, 400, 27);
        pin_field.setBorder(BorderFactory.createEtchedBorder());
        add(pin_field);

        // ************************************* JButton
        // ************************************

        next = new JButton("Next");
        next.setBounds(870, 680, 80, 30);
        next.setBorder(BorderFactory.createEmptyBorder());
        next.setFocusable(false);
        next.addActionListener(this);
        add(next);

        back = new JButton("BACK");
        back.setBounds(770, 680, 80, 30);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        add(back);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");

        if (e.getSource() != back) {
            String formNo = "" + random;
            FN = formNo;
            String name = name_field.getText();
            String fname = Fathers_name_field.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else {
                gender = "";
            }
            String email = email_field.getText();
            String marital = null;
            if (married.isSelected()) {
                marital = "Married";
            } else if (unmarried.isSelected()) {
                marital = "Unmarried";
            } else if (other.isSelected()) {
                marital = "Other";
            } else {
                marital = "";
            }
            String address = add_field.getText();
            String city = city_field.getText();
            String state = state_field.getText();
            String pin = pin_field.getText();

            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                }

                else if (fname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Father's Name is Required");
                }

                else if (dob.equals("")) {
                    JOptionPane.showMessageDialog(null, "Date of Birth is Required");
                }

                else if (gender.equals("")) {
                    JOptionPane.showMessageDialog(null, "Gender is not selected");
                }

                else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email Address is Required");
                }

                else if (marital.equals("")) {
                    JOptionPane.showMessageDialog(null, "Marital Status is not selected");
                }

                else if (address.equals("")) {
                    JOptionPane.showMessageDialog(null, "Address is Required");
                }

                else if (city.equals("")) {
                    JOptionPane.showMessageDialog(null, "City is Required");
                }

                else if (state.equals("")) {
                    JOptionPane.showMessageDialog(null, "State is Required");
                }

                else if (pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "PIN Code is Required");
                }

                else {
                    Conn c = new Conn();
                    String query = "insert into signup values ( '" + formNo + "','" + name + "','" + fname + "','" + dob
                            + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','"
                            + pin + "','" + state + "');";

                    c.s.executeUpdate(query);

                    setVisible(false);
                    new Signup2(formNo).setVisible(true);
                }

            } catch (Exception e1) {
                System.out.println(e1);
            }
        } else {
            if (e.getSource() == back) {

                try {
                    Conn conn = new Conn();
                    String query1 = "delete from signup where formNo = " + FN + ";";
                    String query2 = "delete from signup_page2 where formNo = " + FN + ";";

                    try {
                        conn.s.executeUpdate(query2);
                    } catch (Exception ee1) {
                        ee1.printStackTrace();
                    }
                    try {
                        conn.s.executeUpdate(query1);
                    } catch (Exception ee2) {
                        ee2.printStackTrace();
                    }

                } catch (Exception e1) {
                    System.out.println(e1);
                }

                setVisible(false);
                new login().setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new Signup1();
    }
}
