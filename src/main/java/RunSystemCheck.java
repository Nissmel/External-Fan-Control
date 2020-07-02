import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;

import java.util.TimerTask;

public class RunSystemCheck extends TimerTask {
    public void run() {
        Components components = JSensors.get.components();

        SystemData systemData = new SystemData();
        systemData.getSystemData(components);

        DisplaySystemData displaySystemData = new DisplaySystemData();
        displaySystemData.displayDataToConsole(systemData);
    }
}

