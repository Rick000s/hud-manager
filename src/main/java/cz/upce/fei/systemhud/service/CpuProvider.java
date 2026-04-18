package cz.upce.fei.systemhud.service;

import cz.upce.fei.systemhud.model.HudModule;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class CpuProvider implements HudModule {
    private final SystemInfo si = new SystemInfo();
    private final CentralProcessor processor = si.getHardware().getProcessor();
    private long[] prevTicks = new long[CentralProcessor.TickType.values().length];
    private boolean enabled = true;

    @Override
    public String getName() { return "CPU"; }

    @Override
    public double getValue() {
        // Calculate CPU load percentage between time intervals
        double load = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;
        prevTicks = processor.getSystemCpuLoadTicks();
        return load;
    }

    @Override
    public boolean isEnabled() { return enabled; }

    @Override
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}