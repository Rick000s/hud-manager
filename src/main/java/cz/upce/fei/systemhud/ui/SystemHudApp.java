package cz.upce.fei.systemhud.ui;

import cz.upce.fei.systemhud.logic.HudManager;
import cz.upce.fei.systemhud.model.HudModule;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class SystemHudApp extends Application {
    private final HudManager hudManager = new HudManager();
    private final List<MonitorNode> monitorNodes = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        // Semi-transparent dark background with rounded corners
        root.setStyle("-fx-background-color: rgba(30, 30, 30, 0.8); -fx-padding: 20; -fx-background-radius: 15;");

        // Building the UI based on enabled modules from Manager
        for (HudModule module : hudManager.getEnabledModules()) {
            MonitorNode node = new MonitorNode(module);
            monitorNodes.add(node);
            root.getChildren().add(node);
        }

        // Setting up a 1-second refresh cycle
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            monitorNodes.forEach(MonitorNode::update);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Application window properties (transparent, always on top)
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setAlwaysOnTop(true);

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.show();
    }
}