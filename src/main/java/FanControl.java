
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;


public class FanControl {
    public static void main(String[] args) {
        while (true) {
            Components components = JSensors.get.components();

            DispalySystemData dispalySystemData = new DispalySystemData();
            dispalySystemData.displayDataToConsole(components);
        }
    }

}