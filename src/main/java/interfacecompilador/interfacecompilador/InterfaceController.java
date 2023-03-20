package interfacecompilador.interfacecompilador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class InterfaceController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea areaMensagem;

    @FXML
    private TextArea areaCodigo;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void novoArquivo() {
    }

    public void abrirArquivo() {
    }

    public void salvarArquivo() {
    }

    public void copiar() {
        areaCodigo.copy();
    }

    public void colar() {
        areaCodigo.paste();
    }

    public void recortar() {
        areaCodigo.cut();
    }

    public void compilar() {
//        "compilacao ainda"
    }

    public void mostrarEquipe() {
    }











}