package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    String formno; // Correctly declaring the formno variable
    JTextField panField, aadharField;
    JButton next;
    JRadioButton syes, eyes, sno, eno;
    JComboBox religionField, catagoryField, incomeField, educationalField, occupationField;

    SignupTwo(String formno) {

        this.formno = formno; // Initializing formno
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        setSize(1000, 1000);
        setLocationRelativeTo(null); // Centering the JFrame on the screen
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Personal details heading------------------------------
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(300, 75, 600, 30);
        add(additionalDetails);

        // religion---------------------------------------------------
        // JComboBox for the drop down---------------------------------
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 16));
        religion.setBounds(150, 150, 100, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionField = new JComboBox(valReligion);
        religionField.setBounds(400, 150, 300, 30);
        religionField.setBackground(Color.WHITE);
        add(religionField);

        // catagory and catagoryField--------------------------------------------
        JLabel catagory = new JLabel("Catagory:");
        catagory.setFont(new Font("Raleway", Font.BOLD, 16));
        catagory.setBounds(150, 190, 200, 30);
        add(catagory);

        String valCatagory[] = {"General", "SC", "ST", "Other"};
        catagoryField = new JComboBox(valCatagory);
        catagoryField.setBounds(400, 190, 300, 30);
        catagoryField.setBackground(Color.WHITE);
        add(catagoryField);

        // income and incomeField-------------------------------------------
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 16));
        income.setBounds(150, 230, 200, 30);
        add(income);

        String valIncome[] = {"-Nill-", "<1,50,000", "<3,00,000", "<5,00,000", "<10,00,000", "<20,00,000", ">20,00,000"};
        incomeField = new JComboBox(valIncome);
        incomeField.setBounds(400, 230, 300, 30);
        incomeField.setBackground(Color.WHITE);
        add(incomeField);

        // educational---------------------------------------------
        JLabel eduQualification = new JLabel("Educational Qualification:");
        eduQualification.setFont(new Font("Raleway", Font.BOLD, 16));
        eduQualification.setBounds(150, 270, 200, 30);
        add(eduQualification);

        String valEduQualification[] = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctrate", "Other"};
        educationalField = new JComboBox(valEduQualification);
        educationalField.setBounds(400, 270, 300, 30);
        educationalField.setBackground(Color.WHITE);
        add(educationalField);

        // occupation status-----------------------------------------------
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 16));
        occupation.setBounds(150, 310, 200, 30);
        add(occupation);

        String valOccupation[] = {"Salaried", "Self-employed", "Business", "Student", "Defence", "Other"};
        occupationField = new JComboBox(valOccupation);
        occupationField.setBounds(400, 310, 300, 30);
        occupationField.setBackground(Color.WHITE);
        add(occupationField);

        // pan-----------------------------------------------
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 16));
        pan.setBounds(150, 350, 100, 30);
        add(pan);

        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.BOLD, 16));
        panField.setBounds(400, 350, 300, 30);
        add(panField);

        // aadhar------------------------------------------------
        JLabel aadhar = new JLabel("Aadhar:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 16));
        aadhar.setBounds(150, 390, 100, 30);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharField.setBounds(400, 390, 300, 30);
        add(aadharField);

        // senior citizen--------------------------------------------------
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 16));
        seniorCitizen.setBounds(150, 430, 200, 30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Raleway", Font.BOLD, 16));
        syes.setBounds(400, 430, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setFont(new Font("Raleway", Font.BOLD, 16));
        sno.setBounds(600, 430, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        // existing account------------------------------------------------
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        existingAccount.setBounds(150, 470, 200, 30);
        add(existingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway", Font.BOLD, 16));
        eyes.setBounds(400, 470, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway", Font.BOLD, 16));
        eno.setBounds(600, 470, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(eyes);
        existingAccountGroup.add(eno);

        // next page--------------------------------------------------
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 575, 100, 30);
        next.addActionListener(this);
        add(next);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religionField.getSelectedItem();
        String scatagory = (String) catagoryField.getSelectedItem();
        String sincome = (String) incomeField.getSelectedItem();
        String seduication = (String) educationalField.getSelectedItem();
        String soccupation = (String) occupationField.getSelectedItem();

        String sSeniorCitizen = null;
        if (syes.isSelected()) {
            sSeniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            sSeniorCitizen = "No";
        }

        String sExistingAccount = null;
        if (eyes.isSelected()) {
            sExistingAccount = "Yes";
        } else if (eno.isSelected()) {
            sExistingAccount = "No";
        }
        String saadhar = aadharField.getText();
        String span = panField.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values ('" + formno + "','" + sreligion + "','" + scatagory + "','" + sincome + "','" + seduication + "','" + soccupation + "','" + sSeniorCitizen + "','" + sExistingAccount + "','" + saadhar + "','" + span + "')";
            c.s.executeUpdate(query);

            //SignupThree obect
            setVisible(false);
            new SignupThree(formno).setVisible(true);

            // new SignupThree(formno).setVisible(true);
            setVisible(false); // Hide the current form

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("Form Number Here"); // Pass a form number when creating an instance
    }
}
