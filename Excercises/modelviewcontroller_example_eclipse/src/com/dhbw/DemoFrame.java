package com.dhbw;

import javax.swing.*;
import java.awt.*;

public class DemoFrame extends JFrame {
    public DemoFrame(){
        //Prepare data:
        Student test = new Student(1,"Lukas","Abelt");
        StudentViewPanel view = new StudentViewPanel(test);

        //Add GUI elements
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1,0));
        setSize(600,300);
        content.add(new StudentControllerPanel(test, view));
        content.add(view);
        add(content);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
