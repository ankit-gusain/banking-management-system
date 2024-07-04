package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;  // import jar of j-calender

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, pincodeTextField, stateTextField;
    JButton back, next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {
        setSize(1000, 1000);
        setLocationRelativeTo(null); // Centering the JFrame on the screen
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading----------------------------------------------
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NUMBER " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 30));
        formno.setBounds(200, 25, 600, 40);
        add(formno);

        // Personal details heading------------------------------
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(300, 75, 600, 30);
        add(personalDetails);

        // name---------------------------------------------------
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        name.setBounds(150, 150, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        nameTextField.setBounds(400, 150, 300, 30);
        add(nameTextField);

        //father's name--------------------------------------------
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 16));
        fname.setBounds(150, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        fnameTextField.setBounds(400, 190, 300, 30);
        add(fnameTextField);

        // date of birth-------------------------------------------
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 16));
        dob.setBounds(150, 230, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(400, 230, 300, 30);
        add(dateChooser);

        //gender---------------------------------------------
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        gender.setBounds(150, 270, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(400, 270, 80, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(550, 270, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);

        // buttonGroup class is used for acheiving either male or female 
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        //email-------------------------------------------------------
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        email.setBounds(150, 310, 100, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        emailTextField.setBounds(400, 310, 300, 30);
        add(emailTextField);

        //marital status-----------------------------------------------
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 16));
        marital.setBounds(150, 350, 200, 30);
        add(marital);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 350, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        married = new JRadioButton("Married");
        married.setBounds(520, 350, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        other = new JRadioButton("Other");
        other.setBounds(630, 350, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        //address-----------------------------------------------
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        address.setBounds(150, 390, 100, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        addressTextField.setBounds(400, 390, 300, 30);
        add(addressTextField);

        //city------------------------------------------------
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        city.setBounds(150, 430, 100, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        cityTextField.setBounds(400, 430, 300, 30);
        add(cityTextField);

        //state--------------------------------------------------
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 16));
        state.setBounds(150, 470, 100, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        stateTextField.setBounds(400, 470, 300, 30);
        add(stateTextField);

        //pincode------------------------------------------------
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 16));
        pincode.setBounds(150, 510, 100, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        pincodeTextField.setBounds(400, 510, 300, 30);
        add(pincodeTextField);

        //next page--------------------------------------------------
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 575, 100, 30);
        next.addActionListener(this);
        add(next);

        //BACK--------------------------------------------------
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(550, 575, 100, 30);
        back.addActionListener(this);
        add(back);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // wkt random is long but when we add ""+ the no turns to string
        String name = nameTextField.getText();  //getText se value ko nikal skte hai or settext se set kr skte hai
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //imp
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();

        if (ae.getSource() == back) {
            setVisible(false);
            new Login().setVisible(true);
        }

        String marital = null;

        if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (married.isSelected()) {
            marital = "Married";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
                return;
            }

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Father's Name is required");
                return;
            }

            if (dob.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Date of Birth is required");
                return;
            }

            if (gender == null) {
                JOptionPane.showMessageDialog(null, "Gender is required");
                return;
            }

            if (email.isEmpty() || !email.contains("@")) {
                JOptionPane.showMessageDialog(null, "Valid Email is required");
                return;
            }

            if (marital == null) {
                JOptionPane.showMessageDialog(null, "Marital Status is required");
                return;
            }

            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Address is required");
                return;
            }

            if (city.isEmpty()) {
                JOptionPane.showMessageDialog(null, "City is required");
                return;
            }

            if (state.isEmpty()) {
                JOptionPane.showMessageDialog(null, "State is required");
                return;
            }

            if (pincode.isEmpty() || !pincode.matches("\\d{6}")) {
                JOptionPane.showMessageDialog(null, "Valid Pincode is required");
                return;
            }

            Conn c = new Conn();
            String query = "insert into signup values ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignupTwo(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();

    }

}
