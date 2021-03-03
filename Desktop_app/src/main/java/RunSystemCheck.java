import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;

import java.util.TimerTask;

public class RunSystemCheck extends TimerTask {
    public void run() {
        Components components = JSensors.get.components();

        FetchSystemStats systemData = new FetchSystemStats();
        systemData.getSystemData(components);
        System.out.println(systemData.toString());

        SendToSerial sendToSerial = new SendToSerial();
        sendToSerial.openConnectionAndSendMessageToSerial(sendToSerial.createMessageFromFetchSystemStats(systemData));
    }
}

