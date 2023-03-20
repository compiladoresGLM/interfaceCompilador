package interfacecompilador.interfacecompilador;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
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

    private static final FileChooser file = new FileChooser();

    private String pastaParaCompilar;

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

    public void abrirArquivo() throws IOException {
            File selectedFile = file.showOpenDialog(areaCodigo.getScene().getWindow());
            if (selectedFile != null) {
                String stringDoArquivo = Files.readString(selectedFile.toPath(), StandardCharsets.UTF_8);
                areaCodigo.setText(stringDoArquivo);
                labelStatus.setText(selectedFile.getAbsolutePath());
                pastaParaCompilar = selectedFile.getAbsolutePath();
                areaMensagem.setText("");
            }
    }

    public void salvarArquivo() throws IOException {
            file.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            if (labelStatus.getText() != null && !labelStatus.getText().isEmpty()) {
                FileWriter writer = new FileWriter(labelStatus.getText(), Charset.availableCharsets().get("UTF-8"), false);
                writer.write(areaCodigo.getText());
                writer.close();
            } else {
                File arquivo = file.showSaveDialog(areaCodigo.getScene().getWindow());
                if (arquivo == null) {
                    return;
                }
                arquivo.createNewFile();
                labelStatus.setText(arquivo.getAbsolutePath());
                pastaParaCompilar = arquivo.getAbsolutePath();
            }
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

}