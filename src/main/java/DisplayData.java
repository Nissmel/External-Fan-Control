import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayData {
    public JPanel MainPanel;
    private JLabel externalFanControlLabel;
    private JLabel CPUNameLabel;
    private JLabel CPUTempLabel;
    private JLabel CPULoadLabel;
    private JLabel GPUNameLabel;
    private JLabel GPUTempLabel;
    private JLabel GPULoadLabel;



    JFrame displayWindow() {
        JFrame frame = new JFrame();
        frame.setTitle("Fan Control");
        frame.setContentPane(new DisplayData().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        return frame;
    }

    public void displayDataToConsole(CollectSystemData collectSystemData) {
        System.out.println("Cpu name: " + collectSystemData.cpuName);
        System.out.println("Cpu load: " + collectSystemData.cpuLoad + "%");
        System.out.println("Cpu temperature: " + collectSystemData.cpuPackageTemp + "C");
        System.out.println("Ram used: " + collectSystemData.ramLoad + "%\n");

        System.out.println("Gpu name: " + collectSystemData.gpuName);
        System.out.println("Gpu load: " + collectSystemData.gpuLoad + "%");
        System.out.println("Gpu temperature: " + collectSystemData.gpuTemp + "C");
        System.out.println("Gpu memory used: " + collectSystemData.gpuRamLoad + "%\n");
    }

    public void displayDataToWindow(CollectSystemData collectSystemData) {
        CPUNameLabel.setText("CPU name: " + collectSystemData.cpuName);
    }

}
