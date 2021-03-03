import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    Properties prop = new Properties();

    LoadProperties() {
        this.readPropertiesFile();
    }

    private void readPropertiesFile() {
        try (InputStream input = new FileInputStream("Desktop_app/src/main/resources/config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getPortToConnect() {
        return prop.getProperty("comPort");
    }

    public String getCutGpuName() {
        return prop.getProperty("cutGpuName");
    }

    public String getCutCpuName() {
        return prop.getProperty("cutCpuName");
    }

    public int getDataReadDelayMs() {
        return Integer.parseInt(prop.getProperty("dataReadDelayMs"));
    }

    public int getBaudRate() {
        return Integer.parseInt(prop.getProperty("baudRate"));
    }

    public int getAudibleLevel() {
        return Integer.parseInt(prop.getProperty("audibleLevel"));
    }

}

