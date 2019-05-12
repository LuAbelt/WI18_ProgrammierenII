package com.dhbw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private JButton referenceButton;

    public MyActionListener(JButton btn){
        referenceButton = btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        referenceButton.setText("Handled by external class!");
    }
}
