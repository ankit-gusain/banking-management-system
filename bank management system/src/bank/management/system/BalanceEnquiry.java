package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;
    int balance = 0;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        setSize(725, 725);
        setLocation(300, 0);
        setVisible(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(725, 725, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 725, 725);
        add(image);

        //back button
        back = new JButton("Back");
        back.setBounds(300, 419, 110, 24);
        back.addActionListener(this);
        image.add(back);

        // Database connection and query
        Conn conn = new Conn();
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Display balance
        JLabel text = new JLabel("Your Current Balance is Rs : " + balance);
        text.setBounds(130, 230, 600, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 13));
        image.add(text);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
