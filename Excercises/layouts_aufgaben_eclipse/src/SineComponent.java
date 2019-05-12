import javax.swing.*;
import java.awt.*;

public class SineComponent extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        double maxAmplitude = getHeight()*0.25;
        double scale = 100;
        for(int i=0;i<getWidth();i+=5){
            double currentSine = getHeight()/2 - Math.sin(i/scale)*maxAmplitude;
            double nextSine = getHeight()/2 - Math.sin((i+5)/scale)*maxAmplitude;
            g.drawLine(i,(int)currentSine,i+5,(int)nextSine);
        }
    }
}
