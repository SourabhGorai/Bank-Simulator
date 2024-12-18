import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class miniStatement extends JFrame {

    miniStatement(String CardNumber, String PINnum) {

        setTitle("Mini Statement");
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // *********************************************************** JLabel

        JLabel heading = new JLabel("Indian Bank");
        heading.setBounds(160, 20, 100, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 13));
        heading.setBackground(Color.BLACK);
        add(heading);

        JLabel cardNo = new JLabel(
                "Card Number: " + CardNumber.substring(0, 4) + "-XXXX-XXXX-XXXX-" + CardNumber.substring(12));
        cardNo.setBounds(20, 90, 300, 40);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 13));
        cardNo.setBackground(Color.BLACK);
        add(cardNo);

        JTextArea mini = new JTextArea();
        mini.setBounds(20, 200, 600, 200);
        mini.setFont(new Font("Raleway", Font.BOLD, 10));
        add(mini);

        JLabel amt_txt = new JLabel();
        amt_txt.setBounds(20,450,250,30);
        amt_txt.setFont(new Font("Raleway",Font.BOLD,10));
        add(amt_txt);

        // ************************************************************ Query

        String query1 = "SELECT * FROM transactions WHERE Card_Number = '" + CardNumber + "';";
        String query2 = "SELECT * FROM total_amt WHERE Card_Number = '" + CardNumber + "';";

        try {

            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(query1);
            while (rs.next()) {
                mini.setText(
                        mini.getText() + rs.getString("date") + "   " + rs.getString("time") + "   "
                        + rs.getString("type") + "   " + rs.getString("amount") + "\n");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery(query2);
            while(rs.next()){
                amt_txt.setText("Your Current Account Balance is Rs "+rs.getString("Total_Amount"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // ***********************************************************

        // setBackground(Color.WHITE);
        pack();
        setBounds(200, 100, 400, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new miniStatement("", "");
    }
}
