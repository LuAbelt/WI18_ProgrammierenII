package com.dhbw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoFrame extends JFrame {
    public DemoFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,800);

        MyButton myButton = new MyButton("Button handled by itself");

        JButton anonymousButton = new JButton("Button handled by anonymous class!");
        anonymousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anonymousButton.setText("Handled by anonymous class");
            }
        });

        JButton lambdaButton = new JButton("Button handled by Lambda expression");
        lambdaButton.addActionListener( e -> lambdaButton.setText("Handled by Lambda expression!"));
        
        JButton externalButton = new JButton("Button handled by external listener class");
        externalButton.addActionListener(new MyActionListener(externalButton));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,1));
        buttonPanel.add(myButton);
        buttonPanel.add(anonymousButton);
        buttonPanel.add(lambdaButton);
        buttonPanel.add(externalButton);
        
        add(buttonPanel);
        setVisible(true);
    }
}
