import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;

import java.util.List;

public class DispalySystemData {

    public void displayDataToConsole(Components components) {
        List<Cpu> cpus = components.cpus;
        List<Gpu> gpus = components.gpus;

        if (cpus != null) {
            for (final Cpu cpu : cpus) {
                System.out.println("CPU component: " + cpu.name);
                if (cpu.sensors != null) {
                    List<Temperature> cpuTemps = cpu.sensors.temperatures;
                    System.out.println(cpuTemps.get(cpuTemps.size() - 1).name + ": " + (cpuTemps.get(cpuTemps.size() - 1).value));

//                    for (final Temperature temp : cpuTemps) {
//                        System.out.println(temp.name + ": " + temp.value + " C");
//                    }

                    List<Load> cpuLoads = cpu.sensors.loads;
                    System.out.println(cpuLoads.get(cpuLoads.size() - 2).name + ": " + (cpuLoads.get(cpuLoads.size() - 2).value) / 100000 + "%");
                    System.out.println(cpuLoads.get(cpuLoads.size() - 1).name + ": " + (cpuLoads.get(cpuLoads.size() - 1).value) / 100000 + "%" + "\n");

//                    for (final Load load : cpuLoads) {
//                        System.out.println(load.name + ": " + load.value);
//                    }
                }
            }
        }

        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                System.out.println("GPU component: " + gpu.name);
                if (gpu.sensors != null) {
                    List<Temperature> gpuTemps = gpu.sensors.temperatures;
                    System.out.println(gpuTemps.get(gpuTemps.size() - 1).name + ": " + (gpuTemps.get(gpuTemps.size() - 1).value));

//                    for (final Temperature temp : gpuTemps) {
//                        System.out.println(temp.name + ": " + temp.value + " C");
//                    }

                    List<Load> gpuLoads = gpu.sensors.loads;
                    System.out.println(gpuLoads.get(gpuLoads.size() - 1).name + ": " + (gpuLoads.get(gpuLoads.size() - 1).value) / 100000 + "%");
                    System.out.println(gpuLoads.get(gpuLoads.size() - 4).name + ": " + (gpuLoads.get(gpuLoads.size() - 4).value) / 100000 + "%" + "\n");

//                    for (final Load load : gpuLoads) {
//                        System.out.println(load.name + ": " + load.value);
//                    }
                }
            }
        }
    }
}
