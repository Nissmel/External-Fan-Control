
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;

import javax.swing.*;
import java.awt.*;


public class FanControl {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new FanControlerFrame();
            frame.setTitle("Fan Controller");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        while (true) {
            Components components = JSensors.get.components();

            SystemData systemData = new SystemData();
            systemData.getSystemData(components);

            DisplaySystemData displaySystemData = new DisplaySystemData();
            displaySystemData.displayDataToConsole(systemData);

        }
    }

}