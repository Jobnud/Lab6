module com.example.lab71 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens pl.lublin.wsei.java.cwiczenia to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia;
}