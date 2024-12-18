import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transactions extends JFrame implements ActionListener {

    JLabel Text;
    JButton Dep, Fst_Csh, Pin_Ch, Csh_withdrawl, mini_stat, Blnc_enq, exit;
    String CardNumber, PINnum;

    transactions(String CardNumber, String PINnum) {

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

        Text = new JLabel("Please Select Your Transaction");
        Text.setBounds(270, 250, 300, 30);
        Text.setForeground(Color.WHITE);
        Text.setFont(new Font("System", Font.BOLD, 15));
        img.add(Text);

        // ******************************************** JButton
        // **************************************

        // JButton Dep, Fst_Csh, Pin_Ch, Csh_withdrawl, mini_stat, Blnc_enq, exit;

        Dep = new JButton("Deposit");
        Dep.setBounds(220, 368, 150, 30);
        Dep.setFocusable(false);
        Dep.setFont(new Font("Raleway", Font.BOLD, 12));
        Dep.setBorder(BorderFactory.createEtchedBorder());
        Dep.addActionListener(this);
        img.add(Dep);

        Fst_Csh = new JButton("Fast Cash");
        Fst_Csh.setBounds(220, 400, 150, 30);
        Fst_Csh.setFocusable(false);
        Fst_Csh.setFont(new Font("Raleway", Font.BOLD, 12));
        Fst_Csh.setBorder(BorderFactory.createEtchedBorder());
        Fst_Csh.addActionListener(this);
        img.add(Fst_Csh);

        Pin_Ch = new JButton("PIN Change");
        Pin_Ch.setBounds(220, 432, 150, 30);
        Pin_Ch.setFocusable(false);
        Pin_Ch.setFont(new Font("Raleway", Font.BOLD, 12));
        Pin_Ch.setBorder(BorderFactory.createEtchedBorder());
        Pin_Ch.addActionListener(this);
        img.add(Pin_Ch);

        Csh_withdrawl = new JButton("Cash Withdrawal");
        Csh_withdrawl.setBounds(405, 368, 150, 30);
        Csh_withdrawl.setFocusable(false);
        Csh_withdrawl.setFont(new Font("Raleway", Font.BOLD, 12));
        Csh_withdrawl.setBorder(BorderFactory.createEtchedBorder());
        Csh_withdrawl.addActionListener(this);
        img.add(Csh_withdrawl);

        mini_stat = new JButton("Mini Statement");
        mini_stat.setBounds(405, 401, 150, 30);
        mini_stat.setFocusable(false);
        mini_stat.setFont(new Font("Raleway", Font.BOLD, 12));
        mini_stat.setBorder(BorderFactory.createEtchedBorder());
        mini_stat.addActionListener(this);
        img.add(mini_stat);

        Blnc_enq = new JButton("Balance Enquiry");
        Blnc_enq.setBounds(405, 435, 150, 30);
        Blnc_enq.setFocusable(false);
        Blnc_enq.setFont(new Font("Raleway", Font.BOLD, 12));
        Blnc_enq.setBorder(BorderFactory.createEtchedBorder());
        Blnc_enq.addActionListener(this);
        img.add(Blnc_enq);

        exit = new JButton("EXIT");
        exit.setBounds(405, 468, 150, 30);
        exit.setFocusable(false);
        exit.setFont(new Font("Raleway", Font.BOLD, 12));
        exit.setBorder(BorderFactory.createEtchedBorder());
        exit.addActionListener(this);
        img.add(exit);

        // *********************************************************************************************
        setUndecorated(true);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == Dep) {
            setVisible(false);
            new Deposit(PINnum, CardNumber).setVisible(true);
        } else if (ae.getSource() == Fst_Csh) {
            setVisible(false);
            new Fast_Cash(CardNumber, PINnum).setVisible(true);
        } else if (ae.getSource() == Pin_Ch) {
            setVisible(false);
            new CHange_PIN(CardNumber, PINnum).setVisible(true);
            ;
        } else if (ae.getSource() == Blnc_enq) {
            setVisible(false);
            new BalanceEnquiry(CardNumber, PINnum).setVisible(true);
        } else if (ae.getSource() == Csh_withdrawl){
            setVisible(false);
            new withdraw(CardNumber, PINnum).setVisible(true);
        } else if (ae.getSource()==mini_stat){
            new miniStatement(CardNumber, PINnum).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new transactions("", "");
    }
}
