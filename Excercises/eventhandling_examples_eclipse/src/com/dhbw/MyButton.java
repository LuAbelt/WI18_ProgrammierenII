package com.dhbw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {
    public MyButton(){
        super();
        addActionListener(this);
    }

    public MyButton(String text){
        this();
        setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setText("Handled by myself!");
    }
}
