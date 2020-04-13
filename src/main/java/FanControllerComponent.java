import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FanControllerComponent extends JComponent {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 400;

    private BufferedImage image;

    public FanControllerComponent() {
        String pathName = "C:\\Users\\Nissmel\\IdeaProjects\\ExternalFanControll\\src\\main\\java\\test.jpg";
        try {
            image = ImageIO.read(new File(pathName));
        } catch (IOException ex) {
            System.out.println("No " + pathName + " found!");
        }
    }

    public void paintComponent(Graphics g) {
        if (image == null) return;
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);

    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


}
