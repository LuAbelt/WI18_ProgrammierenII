package com.dhbw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentControllerPanel extends JPanel implements ActionListener {
    private Student model;
    private StudentViewPanel view;

    public StudentControllerPanel(Student model, StudentViewPanel view){
        this.model = model;
        this.view = view;

        setLayout(new GridLayout(0,1));

        JTextField idField = new JTextField();
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JButton submitButton = new JButton("Update Data");

        //On button click: Update our data and notify our view
        submitButton.addActionListener( e-> {
            this.model.setId(Integer.parseInt(idField.getText()));
            this.model.setFirstName(firstNameField.getText());
            this.model.setLastName(lastNameField.getText());
            this.view.updateView();
        });

        add(idField);
        add(firstNameField);
        add(lastNameField);
        add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
