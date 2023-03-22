package interfacecompilador.interfacecompilador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class InterfaceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InterfaceApplication.class.getResource("interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.minHeightProperty().set(600);
        stage.minWidthProperty().set(900);
        stage.setTitle("Compilador");
        stage.setScene(scene);
        scene.getRoot().applyCss();
        setScroll(scene);
        stage.show();
    }

    private void setScroll(Scene scene) {
        TextArea areaCodigo = (TextArea) scene.lookup("#areaCodigo");
        areaCodigo.setStyle("-fx-font-family: monospace");
        TextArea areaMensagem = (TextArea) scene.lookup("#areaMensagem");
        areaMensagem.setStyle("-fx-font-family: monospace");
        TextArea linhas = (TextArea) scene.lookup("#linhas");
        linhas.setStyle("-fx-font-family: monospace");
        ScrollBar n1 = (ScrollBar) areaCodigo.lookup(".scroll-bar");
        if (n1 != null) {
            ScrollBar n2 = (ScrollBar) linhas.lookup(".scroll-bar");
            if (n2 != null) {
                n1.valueProperty().bindBidirectional(n2.valueProperty());
            }
        }
        setScrollPanePolicy(areaCodigo, ScrollPane.ScrollBarPolicy.ALWAYS);
        setScrollPanePolicy(areaMensagem, ScrollPane.ScrollBarPolicy.ALWAYS);
        setScrollPanePolicy(linhas, ScrollPane.ScrollBarPolicy.NEVER);
    }

    private void setScrollPanePolicy(Node node, ScrollPane.ScrollBarPolicy policy) {
        ScrollPane scrollPaneCodigo = (ScrollPane) node.lookup(".scroll-pane");
        scrollPaneCodigo.setVbarPolicy(policy);
        scrollPaneCodigo.setHbarPolicy(policy);
    }

    public static void main(String[] args) {
        launch();
    }
}