package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    // Extends JFrame is important to remove the error from the setSize, setLocation, setVisible

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String accountType, cardnumber, pinnumber, facility;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null); // Setting layout to null

        setSize(1000, 1000);
        setLocation(100, 0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account type:");
        type.setFont(new Font("Raleway", Font.BOLD, 16));
        type.setBounds(100, 125, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 160, 250, 20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(400, 160, 250, 20);
        add(r2);

        r3 = new JRadioButton("Recurring Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 190, 250, 20);
        add(r3);

        r4 = new JRadioButton("Fixed Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(400, 190, 250, 20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        // Card
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 16));
        card.setBounds(100, 240, 300, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 16));
        number.setBounds(400, 245, 400, 30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number:");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 10));
        cardDetail.setBounds(100, 260, 400, 30);
        add(cardDetail);

        // PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(100, 300, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        pnumber.setBounds(400, 305, 200, 30);
        add(pnumber);

        JLabel pinDetail = new JLabel("Your 4 Digit PIN");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 10));
        pinDetail.setBounds(100, 320, 400, 30);
        add(pinDetail);

        // Services and checkbox
        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 16));
        services.setBounds(100, 360, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 12));
        c1.setBounds(100, 400, 200, 30);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 12));
        c2.setBounds(300, 400, 200, 30);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 12));
        c3.setBounds(100, 430, 200, 30);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS ALERT");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 12));
        c4.setBounds(300, 430, 200, 30);
        add(c4);

        c5 = new JCheckBox("CHECK BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 12));
        c5.setBounds(100, 460, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 12));
        c6.setBounds(300, 460, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 540, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 12));
        submit.setBounds(200, 600, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 12));
        cancel.setBounds(400, 600, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Current Account";
            } else if (r3.isSelected()) {
                accountType = "Recurring Deposit Account";
            } else if (r4.isSelected()) {
                accountType = "Fixed Deposit Account";
            }

            // Generating 16-digit card number and 4-digit PIN
            Random random = new Random();
            cardnumber = "" + Math.abs(random.nextLong() % 90000000L + 5040932600000000L);
            pinnumber = "" + Math.abs(random.nextLong() % 9000L + 1000L);

            facility = "";
            if (c1.isSelected()) {
                facility += " ATM CARD";
            }
            if (c2.isSelected()) {
                facility += " INTERNET BANKING";
            }
            if (c3.isSelected()) {
                facility += " MOBILE BANKING";
            }
            if (c4.isSelected()) {
                facility += " EMAIL & SMS ALERT";
            }
            if (c5.isSelected()) {
                facility += " CHECK BOOK";
            }
            if (c6.isSelected()) {
                facility += " E-STATEMENT";
            }

            try {
                if (accountType == null) {
                    JOptionPane.showMessageDialog(null, "Account type is required.");
                    return;
                }

                // Ensure that the declaration checkbox is checked
                if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please declare that the above entered details are correct.");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "insert into signupThree values ('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                String query2 = "insert into login values ('" + cardnumber + "','" + pinnumber + "')";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Account created successfully.\nCard Number: " + cardnumber + "\nPIN: " + pinnumber);

                setVisible(false);
                new Deposit(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
