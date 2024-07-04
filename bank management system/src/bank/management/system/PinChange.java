package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(725, 725, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 725, 725);

        add(image);

        setSize(725, 725);
        setLocation(300, 0);
        setVisible(true);

        //text-----------------------------------------------------------------
        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(215, 230, 600, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(text);

        //new pin-----------------------------------------------------------------
        JLabel pinText = new JLabel("New PIN: ");
        pinText.setBounds(130, 275, 100, 20);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 14));
        pin.setBounds(300, 275, 110, 20);
        image.add(pin);

        //RE ENTER PIN-----------------------------------------------------------------
        JLabel repinText = new JLabel("Re-Enter New PIN: ");
        repinText.setBounds(130, 305, 200, 20);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(repinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 14));
        repin.setBounds(300, 305, 110, 20);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(300, 392, 110, 24);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(300, 419, 110, 24);
        back.addActionListener(this);
        image.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        } else if (ae.getSource() == change) {
            try {
                String npin = new String(pin.getPassword());
                String rpin = new String(repin.getPassword());
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN Does not Match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the new PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter the new PIN");
                    return;
                }

                // Database update
                Conn conn = new Conn();
                // Update PIN in multiple tables
                String query1 = "update bank set pinnumber = '" + npin + "' where pinnumber = '" + pinnumber + "'";
                String query2 = "update login set pinnumber = '" + npin + "' where pinnumber = '" + pinnumber + "'";
                String query3 = "update signupthree set pinnumber = '" + npin + "' where pinnumber = '" + pinnumber + "'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                setVisible(false);
                new Transaction(npin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
