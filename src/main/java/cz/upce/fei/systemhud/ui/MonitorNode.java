package cz.upce.fei.systemhud.ui;

import cz.upce.fei.systemhud.model.HudModule;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MonitorNode extends VBox {
    private final HudModule module;
    private final Label valueLabel = new Label();

    public MonitorNode(HudModule module) {
        this.module = module;

        // Customizing the neon-green style for monitoring labels
        valueLabel.setStyle("-fx-text-fill: #c23f25; -fx-font-size: 20px; -fx-font-weight: bold;");
        this.getChildren().add(valueLabel);

        update(); // Initial update on creation
    }

    /** Updates the label text with current hardware data */
    public void update() {
        valueLabel.setText(String.format("%s: %.1f%%", module.getName(), module.getValue()));
    }
}