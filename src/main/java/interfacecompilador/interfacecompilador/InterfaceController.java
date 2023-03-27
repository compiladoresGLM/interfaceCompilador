package interfacecompilador.interfacecompilador;

import interfacecompilador.gals.LexicalError;
import interfacecompilador.gals.Lexico;
import interfacecompilador.gals.Token;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.IntStream;

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
    private Label labelLinhas;

    @FXML
    private TextArea linhas;

    private static final FileChooser file = new FileChooser();

    private String pastaParaCompilar;

    public void initialize() {
        linhas.setText(String.valueOf(areaCodigo.getParagraphs().size()));
        labelLinhas.setVisible(false);
        file.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
    }

    public void novoArquivo() {
        labelStatus.setText("");
        areaCodigo.setText("");
        areaMensagem.setText("");
        removerLinhas();
    }

    public void abrirArquivo() throws IOException {
        File selectedFile = file.showOpenDialog(areaCodigo.getScene().getWindow());
        if (selectedFile != null) {
            String stringDoArquivo = Files.readString(selectedFile.toPath(), StandardCharsets.UTF_8);
            areaCodigo.setText(stringDoArquivo);
            labelStatus.setText(selectedFile.getAbsolutePath());
            pastaParaCompilar = selectedFile.getAbsolutePath();
            areaMensagem.setText("");
            adicionarLinhas();

        }
    }

    public void salvarArquivo() throws IOException {
        salvarNovoArquivo();
        editarArquivoJaExistente();
    }

    private void editarArquivoJaExistente() throws IOException {
        if (labelStatus.getText() != null && !labelStatus.getText().isEmpty()) {
            FileWriter writer = new FileWriter(labelStatus.getText(), Charset.availableCharsets().get("UTF-8"), false);
            writer.write(areaCodigo.getText());
            writer.close();
        }
    }

    private void salvarNovoArquivo() throws IOException {
        if (labelStatus.getText() == null || labelStatus.getText().isEmpty()) {
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
        adicionarLinhas();
    }

    public void recortar() {
        areaCodigo.cut();
        removerLinhas();
    }

    public void compilar() throws FileNotFoundException {
        areaMensagem.setText("Compilação de programas ainda não foi implementada");

        String arquivoAtual = labelStatus.getText();

        if (arquivoAtual.equals("")) {
            areaMensagem.setText("Um arquivo deve ser selecionado para a compilação");
            return;
        }

        Reader reader = new FileReader(arquivoAtual);

        Lexico lexico = new Lexico();
        lexico.setInput(reader);
        try {
            Token t = null;
            while ((t = lexico.nextToken()) != null) {
                System.out.println(t.getLexeme());

                // só escreve o lexema, necessário escrever t.getId, t.getPosition()

                // t.getId () - retorna o identificador da classe. Olhar Constants.java e adaptar, pois
                // deve ser apresentada a classe por extenso
                // t.getPosition () - retorna a posição inicial do lexema no editor, necessário adaptar
                // para mostrar a linha

                // esse código apresenta os tokens enquanto não ocorrer erro
                // no entanto, os tokens devem ser apresentados SÓ se não ocorrer erro, necessário adaptar
                // para atender o que foi solicitado  
            }
        } catch (LexicalError e) { // tratamento de erros
            System.out.println(e.getMessage() + " em " + e.getPosition());

            // e.getMessage() - retorna a mensagem de erro de SCANNER_ERRO (olhar ScannerConstants.java
            // e adaptar conforme o enunciado da parte 2)
            // e.getPosition() - retorna a posição inicial do erro, tem que adaptar para mostrar a
            // linha  
        }

    }

    public void mostrarEquipe() {
        areaMensagem.setText("Equipe formada por: Luana Caroline Schmidt, Mateus Maas e Guilherme Milani");
    }

    private void adicionarLinhas() {
        int linhasExistentes = getQuantidadeLinhas();
        int tamUltimaLinhaAnterior = getTamanhoUltimaLinha();
        IntStream.range(0, areaCodigo.getParagraphs().size()).forEach(x -> {
            int linhaAtual = x + 1;
            if (linhaAtual > linhasExistentes) {
                linhas.setText(linhas.getText().concat("\n" + linhaAtual));
            }
        });
        redefinirLarguraLista(tamUltimaLinhaAnterior);
    }

    private void removerLinhas() {
        int linhasExistentes = getQuantidadeLinhas();
        int tamUltimaLinhaAnterior = getTamanhoUltimaLinha();
        IntStream.range(1, linhasExistentes).forEach(x -> {
            int linhaAtual = x + 1;
            if (linhaAtual > areaCodigo.getParagraphs().size()) {
                linhas.setText(linhas.getText().replaceFirst("\n" + linhaAtual, ""));
            }
        });
        redefinirLarguraLista(tamUltimaLinhaAnterior);
    }

    private int getTamanhoUltimaLinha() {
        String[] todasLinhas = linhas.getText().split("\n");
        return todasLinhas[todasLinhas.length - 1].length();
    }

    private int getQuantidadeLinhas() {
        return linhas.getText().split("\n").length;
    }

    private void redefinirLarguraLista(int tamUltimaLinhaAnterior) {
        int tamUltimaLinha = getTamanhoUltimaLinha();
        if (tamUltimaLinhaAnterior != tamUltimaLinha) {
            double newScale = (tamUltimaLinha == 2 ? 0.6 : (tamUltimaLinha == 1 ? 1 : 0.5));
            linhas.setMinWidth(20 * tamUltimaLinha * newScale);
            linhas.setMaxWidth(20 * tamUltimaLinha * newScale);
        }
    }

    public void alterarContadorDeLinhaAoDigitar(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)
                || (keyEvent.getCode().equals(KeyCode.V) && keyEvent.isControlDown())) {
            adicionarLinhas();
        }
        if (keyEvent.getCode().equals(KeyCode.BACK_SPACE) || keyEvent.getCode().equals(KeyCode.DELETE)
                || (keyEvent.getCode().equals(KeyCode.X) && keyEvent.isControlDown())) {
            if (areaCodigo.getParagraphs().size() != getQuantidadeLinhas()) {
                removerLinhas();
            }
        }
    }

    public void chamarAcoesTela(KeyEvent keyEvent) throws IOException {
        if (keyEvent.isControlDown()) {
            if (keyEvent.getCode().equals(KeyCode.S)) {
                salvarArquivo();
            }

            if (keyEvent.getCode().equals(KeyCode.N)) {
                novoArquivo();
            }

            if (keyEvent.getCode().equals(KeyCode.O)) {
                abrirArquivo();
            }
        } else {
            if (keyEvent.getCode().equals(KeyCode.F7)) {
                compilar();
            }
            if (keyEvent.getCode().equals(KeyCode.F1)) {
                mostrarEquipe();
            }
        }
    }


}