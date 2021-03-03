import com.fazecast.jSerialComm.SerialPort;

public class SendToSerial {
    private SerialPort[] availableComPorts = SerialPort.getCommPorts();
    private LoadProperties properties = new LoadProperties();

    private boolean connectedToArduino = false;
    private int portNumber = 0;

    public void openConnectionAndSendMessageToSerial(String serialMessage) {
        byte[] bytesToBeWritten = serialMessage.getBytes();

        checkPortToBeConnected();
        if (connectedToArduino) {
            availableComPorts[portNumber].openPort(1000);
            applyConnectionParameters();
            availableComPorts[portNumber].writeBytes(bytesToBeWritten, bytesToBeWritten.length);
        }
        closeComPort();
    }

    public String createMessageFromFetchSystemStats(FetchSystemStats systemData) {
        return systemData.getCpuName().replace(properties.getCutCpuName(), "") +
                "\n  Temp: " + systemData.getCpuPackageTemp() + "C" +
                "\n  Load: " + String.valueOf(systemData.getCpuLoad()).substring(0, 4) + "%" +
                "\n  RAM : " + String.valueOf(systemData.getRamLoad()).substring(0, 4) + "%" +
                "\n" + systemData.getGpuName().replace(properties.getCutGpuName(), "") +
                "\n  Temp: " + systemData.getGpuTemp() +
                "\n  Load: " + ((systemData.getGpuLoad() < 1) ? "00.0" : systemData.getGpuLoad()) + "%" +
                "\n  VRam: " + String.valueOf(systemData.getGpuRamLoad()).substring(0, 4) + "%";
    }

    public String createMessageForEnvironmentSetup() {
        return "";
    }

    private void applyConnectionParameters() {
        if (availableComPorts[portNumber] != null) {
            availableComPorts[portNumber].setComPortParameters(properties.getBaudRate(), 8, 1, SerialPort.NO_PARITY);
            availableComPorts[portNumber].setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        }
    }

    private void checkPortToBeConnected() {
        int incrementationPort = 0;

        for (SerialPort port : availableComPorts) {
            if (port.getSystemPortName().equalsIgnoreCase(properties.getPortToConnect())) {
                connectedToArduino = true;
                portNumber = incrementationPort;
            } else
                connectedToArduino = false;
            incrementationPort++;
        }
    }


    private void closeComPort() {
        if (availableComPorts.length > 0 && availableComPorts[portNumber].isOpen() && availableComPorts[portNumber] != null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            availableComPorts[portNumber].closePort();
        }
    }
}
