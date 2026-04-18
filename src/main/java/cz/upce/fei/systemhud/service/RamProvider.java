package cz.upce.fei.systemhud.service;

import cz.upce.fei.systemhud.model.HudModule;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

public class RamProvider implements HudModule {
    private final GlobalMemory memory = new SystemInfo().getHardware().getMemory();
    private boolean enabled = true;

    @Override
    public String getName() { return "RAM"; }

    @Override
    public double getValue() {
        // Calculate RAM usage: ((Total - Available) / Total) * 100
        long total = memory.getTotal();
        long available = memory.getAvailable();
        return ((double) (total - available) / total) * 100;
    }

    @Override
    public boolean isEnabled() { return enabled; }

    @Override
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}