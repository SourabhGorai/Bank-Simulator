// package package1;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class test extends JFrame implements ActionListener {
    long random;
    JTextField namefield, fnamefield, emailfield, addressfield, cityfield, statefield, pincodefield;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male, female, others, married, unmarried;

    test() {
        setLayout(null);
        Random rd = new Random();
        random = Math.abs((rd.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 36));
        formno.setBounds(170, 20, 600, 40);
        add(formno);

        JLabel persdet = new JLabel("Page 1 : Personal Details");
        persdet.setFont(new Font("Raleway", Font.BOLD, 22));
        persdet.setBounds(280, 80, 400, 30);
        add(persdet);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 140, 100, 30);
        add(name);

        namefield = new JTextField();
        namefield.setFont(new Font("Raleway", Font.BOLD, 14));
        namefield.setBounds(300, 140, 400, 30);
        add(namefield);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnamefield = new JTextField();
        fnamefield.setFont(new Font("Raleway", Font.BOLD, 14));
        fnamefield.setBounds(300, 190, 400, 30);
        add(fnamefield);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(male);
        gendergrp.add(female);

        JLabel email = new JLabel("E-mail Address : ");
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailfield = new JTextField();
        emailfield.setFont(new Font("Raleway", Font.BOLD, 14));
        emailfield.setBounds(300, 340, 400, 30);
        add(emailfield);

        JLabel marstat = new JLabel("Marital Status : ");
        marstat.setFont(new Font("Raleway", Font.BOLD, 18));
        marstat.setBounds(100, 390, 200, 30);
        add(marstat);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(610, 390, 80, 30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup marstatgrp = new ButtonGroup();
        marstatgrp.add(married);
        marstatgrp.add(unmarried);
        marstatgrp.add(others);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressfield = new JTextField();
        addressfield.setFont(new Font("Raleway", Font.BOLD, 14));
        addressfield.setBounds(300, 440, 400, 30);
        add(addressfield);

        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityfield = new JTextField();
        cityfield.setFont(new Font("Raleway", Font.BOLD, 14));
        cityfield.setBounds(300, 490, 400, 30);
        add(cityfield);

        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 540, 200, 30);
        add(state);

        statefield = new JTextField();
        statefield.setFont(new Font("Raleway", Font.BOLD, 14));
        statefield.setBounds(300, 540, 400, 30);
        add(statefield);

        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodefield = new JTextField();
        pincodefield.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodefield.setBounds(300, 590, 400, 30);
        add(pincodefield);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = namefield.getText();
        String fname = fnamefield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailfield.getText();
        String marstat = null;
        if (married.isSelected()) {
            marstat = "Married";
        } else if (unmarried.isSelected()) {
            marstat = "Unmarried";
        } else if (others.isSelected()) {
            marstat = "Others";
        }
        String address = addressfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pin = pincodefield.getText();

        // try {

        // } catch (Exception err) {
        // System.out.println(err);

        // }

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name is required");
        } else {
            try {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob
                        + "','" + gender + "','" + email + "','" + marstat + "','" + address + "','" + city + "','"
                        + state + "','" + pin + "');";
                c.s.executeUpdate(query);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new test();
    }
}