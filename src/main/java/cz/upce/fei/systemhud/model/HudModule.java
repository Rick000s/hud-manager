package cz.upce.fei.systemhud.model;

public interface HudModule {
    /** Get the display name of the module (e.g., "CPU") */
    String getName();

    /** Get the current performance value (0.0 to 100.0) */
    double getValue();

    /** Check if the module should be rendered on screen */
    boolean isEnabled();

    /** Toggle the visibility of the module */
    void setEnabled(boolean enabled);
}