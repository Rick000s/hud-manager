module cz.upce.fei.systemhud {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.oshi;
    requires org.slf4j; // OSHI часто потребує логера, про всяк випадок

    // Видаляємо exports/opens для кореневого пакета, якщо він порожній
    // Залишаємо тільки ті, де реально є класи

    exports cz.upce.fei.systemhud.ui;
    opens cz.upce.fei.systemhud.ui to javafx.fxml;

    exports cz.upce.fei.systemhud.model;
    exports cz.upce.fei.systemhud.service;
    exports cz.upce.fei.systemhud.logic;
}