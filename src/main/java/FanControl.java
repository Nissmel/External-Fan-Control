import javax.swing.*;
import java.util.Timer;

public class FanControl {


    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new RunSystemCheck(), 0, 5000);

        FanControllerComponent fc = new FanControllerComponent();
        JFrame fr = new JFrame();

        fr = fc.FanControl();


    }

}