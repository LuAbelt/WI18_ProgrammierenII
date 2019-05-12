package com.dhbw;

import javax.swing.*;
import java.awt.*;

public class StudentViewPanel extends JPanel {
    private Student model;
    private JLabel idLabel, firstNameLabel, lastNameLabel;

    public StudentViewPanel(Student data){
        idLabel = new JLabel();
        firstNameLabel = new JLabel();
        lastNameLabel = new JLabel();
        model=data;
        updateView();

        setLayout(new GridLayout(0,1));

        add(idLabel);
        add(firstNameLabel);
        add(lastNameLabel);
        add(new JPanel());
    }

    public void updateView(){
        idLabel.setText("ID: "+model.getId());
        firstNameLabel.setText("First Name: " + model.getFirstName());
        lastNameLabel.setText("Last Name: " +model.getLastName());
    }
}
