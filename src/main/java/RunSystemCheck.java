import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;

import javax.swing.*;
import java.util.TimerTask;

public class RunSystemCheck extends TimerTask {
    public void run() {
        Components components = JSensors.get.components();

        CollectSystemData collectSystemData = new CollectSystemData(components);

        DisplayData wdd = new DisplayData();
        wdd.displayDataToConsole(collectSystemData);
        wdd.displayDataToWindow(collectSystemData);
    }
}

