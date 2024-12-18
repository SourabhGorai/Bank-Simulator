import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox religionBox, categoryBox, IncomeBox, eqBox, occBox;
    JTextField pan_Field, aadhar_Field;
    JRadioButton senior_yes, senior_no, existAcc_yes, existAcc_no;
    JButton back, next;
    String formNo;

    Signup2(String formNo) {
        setVisible(true);
        setTitle("Sign Up Page 2");
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        // setDefaultCloseOperation(EXIT_ON_CL OSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setSize(600, 800);
        // setLocation(350, 0);
        this.formNo = formNo;

        // **************************************** JLabel
        // ***********************************************

        JLabel heading = new JLabel("Page 2 : Additional Details ");
        heading.setBounds(470, 40, 400, 35);
        heading.setFont(new Font("Osward", Font.BOLD, 30));
        add(heading);

        JLabel religion = new JLabel("Religion :");
        religion.setBounds(280, 130, 150, 30);
        religion.setFont(new Font("Osward", Font.BOLD, 20));
        add(religion);

        JLabel category = new JLabel("Category :");
        category.setBounds(280, 180, 150, 30);
        category.setFont(new Font("Osward", Font.BOLD, 20));
        add(category);

        JLabel income = new JLabel("Income :");
        income.setBounds(280, 230, 150, 30);
        income.setFont(new Font("Osward", Font.BOLD, 20));
        add(income);

        JLabel e = new JLabel("Educational");
        e.setBounds(280, 280, 150, 30);
        e.setFont(new Font("Osward", Font.BOLD, 20));
        add(e);

        JLabel q = new JLabel("Qualification :");
        q.setBounds(280, 305, 150, 30);
        q.setFont(new Font("Osward", Font.BOLD, 20));
        add(q);

        JLabel occ = new JLabel("Occupation :");
        occ.setBounds(280, 355, 150, 30);
        occ.setFont(new Font("Osward", Font.BOLD, 20));
        add(occ);

        JLabel pan_no = new JLabel("PAN Number :");
        pan_no.setBounds(280, 405, 150, 30);
        pan_no.setFont(new Font("Osward", Font.BOLD, 20));
        add(pan_no);

        JLabel aadhar = new JLabel("Aadhar Number :");
        aadhar.setBounds(280, 455, 200, 30);
        aadhar.setFont(new Font("Osward", Font.BOLD, 20));
        add(aadhar);

        JLabel senior_cit = new JLabel("Senior Citizen :");
        senior_cit.setBounds(280, 505, 150, 30);
        senior_cit.setFont(new Font("Osward", Font.BOLD, 20));
        add(senior_cit);

        JLabel exis_acc = new JLabel("Existing Account :");
        exis_acc.setBounds(280, 555, 200, 30);
        exis_acc.setFont(new Font("Osward", Font.BOLD, 20));
        add(exis_acc);

        // ***************************************** DropDown
        // **********************************************

        String valreligion[] = { "Hindu", "Christian", "Sikh", "Adivasi", "Others" };
        religionBox = new JComboBox(valreligion);
        religionBox.setBounds(520, 130, 450, 30);
        religionBox.setFont(new Font("Raleway", Font.PLAIN, 15));
        religionBox.setSelectedItem(null);
        religionBox.setBorder(BorderFactory.createEtchedBorder());
        add(religionBox);

        String valcategory[] = { "General", "OBC", "SC", "ST", "Others" };
        categoryBox = new JComboBox(valcategory);
        categoryBox.setBounds(520, 180, 450, 30);
        categoryBox.setFont(new Font("Raleway", Font.PLAIN, 15));
        categoryBox.setSelectedItem(null);
        categoryBox.setBorder(BorderFactory.createEtchedBorder());
        add(categoryBox);

        String valIncome[] = { "Null", "<1,50,000", "<2,50,000", "5,00,000", "upto 10,00,000" };
        IncomeBox = new JComboBox(valIncome);
        IncomeBox.setBounds(520, 230, 450, 30);
        IncomeBox.setFont(new Font("Raleway", Font.PLAIN, 15));
        IncomeBox.setBorder(BorderFactory.createEtchedBorder());
        IncomeBox.setSelectedItem(null);
        add(IncomeBox);

        String valeducation[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others" };
        eqBox = new JComboBox(valeducation);
        eqBox.setBounds(520, 290, 450, 30);
        eqBox.setFont(new Font("Raleway", Font.PLAIN, 15));
        eqBox.setSelectedItem(null);
        eqBox.setBorder(BorderFactory.createEtchedBorder());
        add(eqBox);

        String valoccu[] = { "Student", "Salaried", "Self-Emploied", "Business", "Retired", "Others" };
        occBox = new JComboBox(valoccu);
        occBox.setBounds(520, 355, 450, 30);
        occBox.setFont(new Font("Raleway", Font.PLAIN, 15));
        occBox.setSelectedItem(null);
        occBox.setBorder(BorderFactory.createEtchedBorder());
        add(occBox);

        // ***************************************** JTextField
        // **********************************************

        pan_Field = new JTextField();
        pan_Field.setBounds(520, 405, 450, 27);
        pan_Field.setBorder(BorderFactory.createEtchedBorder());
        pan_Field.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(pan_Field);

        aadhar_Field = new JTextField();
        aadhar_Field.setBounds(520, 455, 450, 27);
        aadhar_Field.setBorder(BorderFactory.createEtchedBorder());
        aadhar_Field.setFont(new Font("Raleway", Font.PLAIN, 17));
        add(aadhar_Field);

        // ***************************************** JRadioButotn
        // ******************************************

        senior_yes = new JRadioButton("Yes");
        senior_yes.setBounds(520, 510, 100, 27);
        senior_yes.setFont(new Font("Osward", Font.BOLD, 17));
        add(senior_yes);

        senior_no = new JRadioButton("No");
        senior_no.setBounds(720, 510, 100, 27);
        senior_no.setFont(new Font("Osward", Font.BOLD, 17));
        add(senior_no);

        ButtonGroup grp1 = new ButtonGroup();
        grp1.add(senior_yes);
        grp1.add(senior_no);

        existAcc_yes = new JRadioButton("Yes");
        existAcc_yes.setBounds(520, 560, 100, 27);
        existAcc_yes.setFont(new Font("Osward", Font.BOLD, 17));
        add(existAcc_yes);

        existAcc_no = new JRadioButton("No");
        existAcc_no.setBounds(720, 560, 100, 27);
        existAcc_no.setFont(new Font("Osward", Font.BOLD, 17));
        add(existAcc_no);

        ButtonGroup grp2 = new ButtonGroup();
        grp2.add(existAcc_yes);
        grp2.add(existAcc_no);

        // ************************************** JButton
        // *********************************

        next = new JButton("Next");
        next.setBounds(890, 640, 80, 30);
        next.setBorder(BorderFactory.createEmptyBorder());
        next.setFocusable(false);
        next.addActionListener(this);
        add(next);

        back = new JButton("BACK");
        back.setBounds(770, 640, 80, 30);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        add(back);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            setVisible(false);
            new Signup1().setVisible(true);
        } else {
            // String formNo = ""+random;
            String Religion = (String) religionBox.getSelectedItem();
            String Category = (String) categoryBox.getSelectedItem();
            String Income = (String) IncomeBox.getSelectedItem();
            String Eq = (String) eqBox.getSelectedItem();
            String Occupation = (String) occBox.getSelectedItem();
            String PAN_No = pan_Field.getText();
            String Aadhar_no = aadhar_Field.getText();

            String sc = null, ea = null;
            if (senior_yes.isSelected()) {
                sc = "Yes";
            } else if (senior_no.isSelected()) {
                sc = "No";
            } else {
                sc = "";
            }
            if (existAcc_yes.isSelected()) {
                ea = "Yes";
            } else if (existAcc_no.isSelected()) {
                ea = "No";
            } else {
                ea = "";
            }

            try {
                if (Religion.equals("")) {
                    JOptionPane.showMessageDialog(null, "Religion is not selected");
                }
                else if (Category.equals("")) {
                    JOptionPane.showMessageDialog(null, "Category is not selected");
                }
                else if (Income.equals("")) {
                    JOptionPane.showMessageDialog(null, "Income is not selected");
                }
                else if (Eq.equals("")) {
                    JOptionPane.showMessageDialog(null, "Educational Qualification is not selected");
                }
                else if (Occupation.equals("")) {
                    JOptionPane.showMessageDialog(null, "Occupation is not selected");
                }
                else if (PAN_No.equals("")) {
                    JOptionPane.showMessageDialog(null, "PAN number is Required");
                }
                else if (Aadhar_no.equals("")) {
                    JOptionPane.showMessageDialog(null, "Aadhar number Required");
                }
                else if (sc.equals("")) {
                    JOptionPane.showMessageDialog(null, "Citizen Category is Required");
                }
                else if (ea.equals("")) {
                    JOptionPane.showMessageDialog(null, "Existing Account Information is Required");
                }

                // if(!Religion.equals("") && !Category.equals("") && !Income.equals("") && !Eq.equals("") && !Occupation.equals("") && !PAN_No.equals("") && !Aadhar_no.equals("") && !sc.equals("") &&! ea.equals("")) 
                else{
                    Conn c = new Conn();
                    String query = "insert into signup_page2 values ( '" + formNo + "','" + Religion + "','" + Category
                            + "','" + Income + "','" + Eq + "','" + Occupation + "','" + PAN_No + "','" + Aadhar_no
                            + "','"
                            + sc + "','" + ea + "');";

                    c.s.executeUpdate(query);

                    setVisible(false);
                    new Signup3(formNo).setVisible(true);
                }

            } catch (Exception e1) {
                System.out.println(e1);
            }
        }

    }

    public static void main(String[] args) {
        new Signup2(null);
    }
}
