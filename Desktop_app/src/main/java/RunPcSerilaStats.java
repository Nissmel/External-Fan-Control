import java.util.Timer;


public class RunPcSerilaStats {
    public static void main(String[] args) {
        LoadProperties properties = new LoadProperties();
        EnvironmentSetup environmentSetup = new EnvironmentSetup();
        environmentSetup.setEnvironmentBasedOnProperties(properties);

        Timer timer = new Timer();
        timer.schedule(new RunSystemCheck(), 0, properties.getDataReadDelayMs());
    }
}
