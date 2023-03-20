package interfacecompilador.interfacecompilador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class InterfaceController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea areaMensagem;

    @FXML
    private TextArea areaCodigo;

    @FXML
    private Label labelStatus;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private static final FileChooser ufc = new FileChooser();

    private String pathToCompile;

    public void novoArquivo() {
        labelStatus.setText("");
        areaCodigo.setText("");
        areaMensagem.setText("");
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
        areaMensagem.setText("Compilação de programas ainda não foi implementada");
    }

    public void mostrarEquipe() {
        areaMensagem.setText("Equipe formada por: Luana Caroline Schmidt, Mateus Maas e Guilherme Milani");
    }
    public void abrirArquivo() throws IOException {
        File selectedFile = ufc.showOpenDialog(areaCodigo.getScene().getWindow());
        if (selectedFile != null) {
            String s = Files.readString(selectedFile.toPath(), StandardCharsets.UTF_8);
            areaCodigo.setText(s);
            labelStatus.setText(selectedFile.getAbsolutePath());
            pathToCompile = selectedFile.getAbsolutePath();
            areaMensagem.setText("");
        }
    }










}