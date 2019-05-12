import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new SineComponent());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void createNestedLayoutFrame(){
        JFrame frame = new JFrame();
        frame.setSize(700,700);

        frame.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
        frame.add(new JButton("LINE_START"), BorderLayout.LINE_START);
        frame.add(new JButton("PAGE_END"), BorderLayout.PAGE_END);
        frame.add(new JButton("LINE_END"), BorderLayout.LINE_END);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        for(int i=1;i<=4;i++){
            JButton bt = new JButton("Button "+i);
            bt.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(bt);
        }

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void createBorderLayoutFrame(){
        JFrame frame = new JFrame();
        frame.setSize(400,400);

        JButton button_ps = new JButton("Page start");
        JButton button_pe = new JButton("Page end");
        JButton button_ls = new JButton("Line start");
        JButton button_le = new JButton("Line end");
        JButton button_ce = new JButton("Center");
        button_ce.setPreferredSize(new Dimension(200,200));
        button_le.setPreferredSize(new Dimension(100,200));
        button_ls.setPreferredSize(new Dimension(100,200));
        button_ps.setPreferredSize(new Dimension(400,100));
        button_pe.setPreferredSize(new Dimension(400,100));

        frame.add(button_ps, BorderLayout.PAGE_START);
        frame.add(button_pe, BorderLayout.PAGE_END);
        frame.add(button_ls, BorderLayout.LINE_START);
        frame.add(button_le, BorderLayout.LINE_END);
        frame.add(button_ce, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void createBoxLayout(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        frame.setSize(400, 600);

        JButton button1 = new JButton("Button 1");
        button1.setMaximumSize(new Dimension(150,100));
        button1.setAlignmentX(Component.LEFT_ALIGNMENT);
        //button1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton button2 = new JButton("Button 2");
        button2.setMaximumSize(new Dimension(200,100));
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton button3 = new JButton("Button 3");
        button3.setMaximumSize(new Dimension(150,300));
        button3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        //button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void createFlowLayoutFrame(){
        JFrame frame = new JFrame("FlowLayout");
        JPanel panel = new JPanel();
        frame.setSize(500,300);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));
        panel.add(new JButton("Long-Named Button (Button 4)"));
        panel.add(new JButton("Button 5"));
        panel.add(new JButton("Button 6"));
        panel.add(new JButton("Button 7"));
        panel.add(new JButton("ABC"));

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void createGridLayoutFrame(){
        JFrame frame = new JFrame("GridLayout");
        frame.setSize(500,500);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        for(int i=1;i<6;i++){
            panel.add(new JButton("Button "+i));
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
