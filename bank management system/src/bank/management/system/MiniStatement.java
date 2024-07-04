package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pinnumber;
    int bal = 0;

    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");

        setLayout(null);
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);

        // Bank name label
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 0, 100, 50);
        add(bank);

        // Mini statement
        JLabel mini = new JLabel();
        mini.setBounds(20, 80, 360, 400);
        add(mini);

        // Card
        JLabel card = new JLabel();
        card.setBounds(20, 50, 300, 20);
        add(card);

        // Balance
        JLabel balance = new JLabel();
        balance.setBounds(20, 500, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '" + pinnumber + "'");
            if (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "xxxxxxxx" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");

            StringBuilder miniText = new StringBuilder("<html>");
            while (rs.next()) {
                miniText.append(rs.getString("date"))
                        .append(" &nbsp; &nbsp; &nbsp; &nbsp; ")
                        .append(rs.getString("type"))
                        .append(" &nbsp; &nbsp; &nbsp; &nbsp; Rs. ")
                        .append(rs.getString("amount"))
                        .append("<br>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            miniText.append("</html>");
            mini.setText(miniText.toString());

            balance.setText("Your Current account balance is Rs " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement action here
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
