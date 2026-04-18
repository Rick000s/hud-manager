package cz.upce.fei.systemhud.logic;

import cz.upce.fei.systemhud.model.HudModule;
import cz.upce.fei.systemhud.service.CpuProvider;
import cz.upce.fei.systemhud.service.RamProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HudManager {
    private final List<HudModule> allModules = new ArrayList<>();

    public HudManager() {
        // Registering hardware monitoring modules
        allModules.add(new CpuProvider());
        allModules.add(new RamProvider());
    }

    /** Returns only modules that are marked as enabled */
    public List<HudModule> getEnabledModules() {
        return allModules.stream()
                .filter(HudModule::isEnabled)
                .collect(Collectors.toList());
    }

    public List<HudModule> getAllModules() {
        return allModules;
    }
}