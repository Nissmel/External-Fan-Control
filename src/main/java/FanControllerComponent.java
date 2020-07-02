import javax.swing.*;
import java.awt.*;

public class FanControllerComponent {

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 400;

    JFrame FanControl() {
        JFrame frame = new JFrame();

        final int WIDTH = 1280, HEIGHT = 720;

        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(null);


        frame.setBounds(100, 100, WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MyBREEDS Viewer");
        frame.setResizable(false);
        frame.setVisible(true);

        return frame;
    }
}



