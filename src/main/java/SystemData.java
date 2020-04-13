import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import java.util.List;

public class SystemData {
    String cpuName, gpuName;
    double cpuPackageTemp, cpuLoad, ramLoad;
    double gpuTemp, gpuLoad, gpuRamLoad;

    public void getSystemData(Components components) {
        List<Cpu> cpus = components.cpus;
        List<Gpu> gpus = components.gpus;

        if (cpus != null) {
            for (final Cpu cpu : cpus) {
                cpuName = cpu.name;
                if (cpu.sensors != null) {
                    List<Temperature> cpuTemps = cpu.sensors.temperatures;
                    cpuPackageTemp = cpuTemps.get(cpuTemps.size() - 1).value;

                    List<Load> cpuLoads = cpu.sensors.loads;
                    cpuLoad = (cpuLoads.get(cpuLoads.size() - 2).value) / 100000;
                    ramLoad = (cpuLoads.get(cpuLoads.size() - 1).value) / 100000;
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
}
