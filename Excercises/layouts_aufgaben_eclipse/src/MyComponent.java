import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300,500);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawLine(0,0,getWidth(),getHeight());
        g.setColor(Color.RED);
        g.drawRect(getWidth()/4,getHeight()/4,getWidth(),getHeight());
    }
}
