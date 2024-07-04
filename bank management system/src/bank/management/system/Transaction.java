package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, fastCash, cashWithdrawl, miniStatement, pinChange, balanceEnquiry, exit;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;

        setSize(725, 725);
        setLocation(300, 0);
        setVisible(true);//SABSE END MEIN LIKHO

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(725, 725, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 725, 725);

        add(image);

        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(175, 225, 600, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(text);//to add the text over image agar add()use krenge to bas frame par add hoga image ke uper nhiv

        //DEPOSIT---------------------------------------------------------------
        deposit = new JButton("Deposit");
        deposit.setBounds(130, 337, 110, 24);
        deposit.addActionListener(this);
        image.add(deposit);

        //CASHWITHDRAWL---------------------------------------------------------
        cashWithdrawl = new JButton("Cash Withdrawl");
        cashWithdrawl.setBounds(280, 337, 130, 24);
        cashWithdrawl.addActionListener(this);

        image.add(cashWithdrawl);

        //fastcash---------------------------------------------------------
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(130, 363, 110, 24);
        fastCash.addActionListener(this);
        image.add(fastCash);

        //ministatement----------------------------------------------------
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(280, 363, 130, 24);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        //pinChange----------------------------------------------------
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(130, 389, 110, 24);
        pinChange.addActionListener(this);
        image.add(pinChange);

        //balanceEnquiry----------------------------------------------------
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(280, 389, 130, 24);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        //exit----------------------------------------------------
        exit = new JButton("Exit");
        exit.setBounds(280, 415, 130, 24);
        exit.addActionListener(this);
        image.add(exit);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {

            setVisible(false);
            new Deposit(pinnumber).setVisible(true);

        } else if (ae.getSource() == cashWithdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);

        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);

        } else if (ae.getSource() == pinChange) {
            new PinChange(pinnumber).setVisible(true);

        } else if (ae.getSource() == balanceEnquiry) {
            new BalanceEnquiry(pinnumber).setVisible(true);

        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinnumber).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Transaction("");

    }

}
