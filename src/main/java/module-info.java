module interfacecompilador.interfacecompilador {
    requires javafx.controls;
    requires javafx.fxml;


    opens interfacecompilador to javafx.fxml;
    exports interfacecompilador;
}