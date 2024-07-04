package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    String pinnumber;
    JTextField amount;

    Deposit(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(725, 725, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 725, 725);
        add(image);

        // text---------------------------------------------------------------
        JLabel text = new JLabel("Enter the Amount you want to Deposit");
        text.setBounds(140, 205, 600, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(text);

        // amount-----------------------------------------------------
        amount = new JTextField();
        amount.setBackground(Color.WHITE);
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("Raleway", Font.BOLD, 14));
        amount.setBounds(160, 280, 225, 25);
        image.add(amount);

        // deposit-----------------------------------------------------
        deposit = new JButton("Deposit");
        deposit.setBounds(325, 390, 90, 24);
        deposit.setFont(new Font("Raleway", Font.BOLD, 13));
        deposit.addActionListener(this);
        image.add(deposit);

        // back-----------------------------------------------------
        back = new JButton("Back");
        back.setBounds(325, 419, 90, 24);
        back.setFont(new Font("Raleway", Font.BOLD, 13));
        back.addActionListener(this);
        image.add(back);

        setSize(725, 725);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();

            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            } else {
                try {
                    Conn conn = new Conn();
                    //convertng date into a format that can be inserted into the database.
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Deposit','" + number + "')";
                    conn.s.execute(query);

                    JOptionPane.showMessageDialog(null, "Rs " + number + " deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();// any one of them System.out.println(e);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
