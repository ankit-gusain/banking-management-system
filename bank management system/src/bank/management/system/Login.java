package bank.management.system;

import javax.swing.*;       // why x as it is imported from the extended packages of the java
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextFeild, cardPasswordField;

    Login() {   //why declaring in constructor :: as soon as you init the object contains the data
        setSize(1000, 1000); // to make the frame(l,b)
        setVisible(true);   //to make the frame visible on the screen by def false
        setLocation(200, 0); // loc to the frame over the desktop

        setTitle("Automated Teller Machine"); // set title

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label); // placing component over the frame passing the obect in the add()

        //text
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 30));
        add(text);

        //card no
        JLabel cardno = new JLabel("Card No: ");
        cardno.setBounds(200, 150, 200, 30);
        cardno.setFont(new Font("Osward", Font.BOLD, 30));
        add(cardno);

        cardTextFeild = new JTextField();
        cardTextFeild.setBounds(400, 150, 200, 30);
        add(cardTextFeild);

        //pin
        JLabel pin = new JLabel("Pin: ");
        pin.setBounds(200, 200, 100, 30);
        pin.setFont(new Font("Osward", Font.BOLD, 30));
        add(pin);

        cardPasswordField = new JPasswordField();
        cardPasswordField.setBounds(400, 200, 200, 30);
        add(cardPasswordField);

        //buttons--------------------
        //login button 
        login = new JButton("Login");
        login.setBounds(400, 250, 75, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //clear button
        clear = new JButton("clear");
        clear.setBounds(500, 250, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SignUp");
        signup.setBounds(400, 300, 200, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumbernotfromsqltable = cardTextFeild.getText();
            String pinnumbernotfromsqltable = cardPasswordField.getText();
            String query = "select * from login where cardnumber = '" + cardnumbernotfromsqltable + "' and pinnumber ='" + pinnumbernotfromsqltable + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query); // kuki select ek ddl command hai hance execute query use krenge resukt set sql package ke andaf hoti hai  
                if (rs.next()) {//yanni succesful login hua hai 
                    setVisible(false);//closing login form 
                    new Transaction(pinnumbernotfromsqltable).setVisible(true);//or transaction page show kro ;

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or PIN");
 
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            this.setVisible(false); //to hide the frame 
            new SignupOne().setVisible(true); // make the signup form visible

        } else if (ae.getSource() == clear) {
            cardTextFeild.setText("");

            cardPasswordField.setText("");

        }
    }

    public static void main(String[] args) {
        new Login();

    }
}
