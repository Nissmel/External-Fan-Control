import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import java.util.List;


public class FetchSystemStats {

    private String cpuName, gpuName;

    private double cpuPackageTemp, cpuLoad, ramLoad;
    private double gpuTemp, gpuLoad, gpuRamLoad;

    public void getSystemData(Components components) {
        List<Cpu> cpus = components.cpus;
        List<Gpu> gpus = components.gpus;

        if (cpus != null) {
            for (final Cpu cpu : cpus) {
                cpuName = cpu.name;
                if (cpu.sensors != null) {
                    List<Temperature> cpuTemps = cpu.sensors.temperatures;
                    cpuPackageTemp = cpuTemps.get(cpuTemps.size() - 1).value;

                    List<Load> systemLoads = cpu.sensors.loads;
                    cpuLoad = (systemLoads.get(systemLoads.size() - 2).value) / 100000;
                    ramLoad = (systemLoads.get(systemLoads.size() - 1).value) / 100000;
                }
            }
        }

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                gpuName = gpu.name;
                if (gpu.sensors != null) {
                    List<Temperature> gpuTemps = gpu.sensors.temperatures;
                    gpuTemp = gpuTemps.get(gpuTemps.size() - 1).value;

                    List<Load> gpuLoads = gpu.sensors.loads;
                    gpuRamLoad = (gpuLoads.get(gpuLoads.size() - 1).value) / 100000;
                    gpuLoad = (gpuLoads.get(gpuLoads.size() - 4).value) / 100000;

                }
            }
        }
    }

    @Override
    public String toString() {

        return "Cpu name: " + cpuName +
                "\nCpu load: " + String.valueOf(cpuLoad).substring(0, 4) + "%" +
                "\nCpu temperature: " + String.valueOf(cpuPackageTemp).substring(0, 4) + "°C" +
                "\nRam used: " + String.valueOf(ramLoad).substring(0, 4) +
                "\nGpu name: " + gpuName +
                "\nGpu load: " + ((gpuLoad < 1) ? "0.0" : gpuLoad) + "%" +
                "\nGpu temperature: " + String.valueOf(gpuTemp).substring(0, 4) + "°C" +
                "\nGpu memory used: " + String.valueOf(gpuRamLoad).substring(0, 4) + "%\n";
    }

    public String getCpuName() {
        return cpuName;
    }

    public String getGpuName() {
        return gpuName;
    }

    public double getCpuPackageTemp() {
        return cpuPackageTemp;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }

    public double getRamLoad() {
        return ramLoad;
    }

    public double getGpuTemp() {
        return gpuTemp;
    }

    public double getGpuLoad() {
        return gpuLoad;
    }

    public double getGpuRamLoad() {
        return gpuRamLoad;
    }
}
