public class DisplaySystemData {

    public void displayDataToConsole(SystemData systemData) {
        System.out.println("Cpu name: " + systemData.cpuName);
        System.out.println("Cpu load: " + systemData.cpuLoad);
        System.out.println("Cpu temperature: " + systemData.cpuPackageTemp);
        System.out.println("Ram used: " + systemData.ramLoad + "\n");

        System.out.println("Gpu name: " + systemData.gpuName);
        System.out.println("Gpu load: " + systemData.gpuLoad);
        System.out.println("Gpu temperature: " + systemData.gpuTemp);
        System.out.println("Gpu memory used: " + systemData.gpuRamLoad + "\n");
    }
}
