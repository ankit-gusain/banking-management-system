package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JButton Withdraw, back;
    String pinnumber;
    JTextField amount;

    Withdrawl(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(725, 725, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 725, 725);
        add(image);

        // text---------------------------------------------------------------
        JLabel text = new JLabel("Enter the Amount you want to Withdraw");
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

        // Withdraw-----------------------------------------------------
        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(315, 390, 100, 24);
        Withdraw.setFont(new Font("Raleway", Font.BOLD, 13));
        Withdraw.addActionListener(this);
        image.add(Withdraw);

        // back-----------------------------------------------------
        back = new JButton("Back");
        back.setBounds(315, 419, 100, 24);
        back.setFont(new Font("Raleway", Font.BOLD, 13));
        back.addActionListener(this);
        image.add(back);

        setSize(725, 725);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Withdraw) {
            String number = amount.getText();

            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                try {
                    Conn conn = new Conn();
                    //convertng date into a format that can be inserted into the database.
                    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdraw','" + number + "')";
                    conn.s.execute(query);

                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawl Successfully");
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
        new Withdrawl("");
    }
}
