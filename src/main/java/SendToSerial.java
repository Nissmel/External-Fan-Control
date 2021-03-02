import com.fazecast.jSerialComm.SerialPort;

public class SendToSerial {
    private SerialPort[] comPorts = SerialPort.getCommPorts();
    private LoadProperties properties = new LoadProperties();

    private boolean connectedToArduino = false;
    private int portNumber = 0;

    public void openConnectionAndsendStringToSerial(FetchSystemStats systemData) {
        checkPortToBeConnected();
        byte[] bytesToBeWriten = createString(systemData).getBytes();

        if (connectedToArduino) {
            comPorts[portNumber].openPort(1000);
            applyConnectionParameters();
            comPorts[portNumber].writeBytes(bytesToBeWriten, bytesToBeWriten.length);
        }
        closeComPort();
    }

    private String createString(FetchSystemStats systemData) {
        return systemData.getCpuName().replace(properties.getCutCPUname(), "") +
                "\n  Temp: " + systemData.getCpuPackageTemp() + "C" +
                "\n  Load: " + String.valueOf(systemData.getCpuLoad()).substring(0, 4) + "%" +
                "\n  RAM : " + String.valueOf(systemData.getRamLoad()).substring(0, 4) + "%" +
                "\n" + systemData.getGpuName().replace(properties.getCutGPUname(), "") +
                "\n  Temp: " + systemData.getGpuTemp() +
                "\n  Load: " + ((systemData.getGpuLoad() < 1) ? "00.0" : systemData.getGpuLoad()) + "%" +
                "\n  VRam: " + String.valueOf(systemData.getGpuRamLoad()).substring(0, 4) + "%";
    }

    private void applyConnectionParameters() {
        if (comPorts[portNumber] != null) {
            comPorts[portNumber].setComPortParameters(properties.getBaudRate(), 8, 1, SerialPort.NO_PARITY);
            comPorts[portNumber].setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        }
    }

    private void checkPortToBeConnected() {
        int incrementationPort = 0;

        for (SerialPort port : comPorts) {
            if (port.getSystemPortName().equalsIgnoreCase(properties.getPortToConnect())) {
                connectedToArduino = true;
                portNumber = incrementationPort;
            } else
                connectedToArduino = false;
            incrementationPort++;
        }
    }

    private void closeComPort() {
        if (comPorts.length > 0 && comPorts[portNumber].isOpen() && comPorts[portNumber] != null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            comPorts[portNumber].closePort();
        }
    }
}
