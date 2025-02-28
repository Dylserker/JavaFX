package Exo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setPromptText("Tape quelque chose...");

        Label label = new Label("Texte saisi : ");

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            label.setText("Texte saisi : " + newValue);
        });

        VBox root = new VBox(10, textField, label);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(root, 1200, 800);

        primaryStage.setTitle("Mise à jour en temps réel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

