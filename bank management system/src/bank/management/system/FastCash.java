package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        setSize(725, 725);
        setLocation(300, 0);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(725, 725, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 725, 725);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(175, 225, 600, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(text);

        rs100 = new JButton("Rs: 100");
        rs100.setBounds(130, 337, 110, 24);
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs: 500");
        rs500.setBounds(280, 337, 130, 24);
        rs500.addActionListener(this);
        image.add(rs500);

        rs1000 = new JButton("Rs: 1000");
        rs1000.setBounds(130, 363, 110, 24);
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs2000 = new JButton("Rs: 2000");
        rs2000.setBounds(130, 389, 110, 24);
        rs2000.addActionListener(this);
        image.add(rs2000);

        rs5000 = new JButton("Rs: 5000");
        rs5000.setBounds(280, 363, 130, 24);
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("Rs: 10000");
        rs10000.setBounds(280, 389, 130, 24);
        rs10000.addActionListener(this);
        image.add(rs10000);

        back = new JButton("Back");
        back.setBounds(130, 415, 110, 24);
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("Exit");
        exit.setBounds(280, 415, 130, 24);
        exit.addActionListener(this);
        image.add(exit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(4);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='" + pinnumber + "'");
                int balance = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);

                String query = "insert into bank values('" + pinnumber + "', '" + formattedDate + "', 'Withdrawal', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
