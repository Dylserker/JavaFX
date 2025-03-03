package Exo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Exo8 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button openModalButton = new Button("Ouvrir la fenêtre");

        openModalButton.setOnAction(e -> showModal(primaryStage));

        StackPane root = new StackPane(openModalButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Fenêtre principale");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showModal(Stage parentStage) {
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.WINDOW_MODAL);
        modalStage.initOwner(parentStage);
        modalStage.setTitle("Fenêtre modale");

        Label messageLabel = new Label("Ceci est une fenêtre modale");
        Button closeButton = new Button("Fermer");
        closeButton.setOnAction(e -> modalStage.close());

        VBox modalLayout = new VBox(10, messageLabel, closeButton);
        modalLayout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene modalScene = new Scene(modalLayout, 250, 150);
        modalStage.setScene(modalScene);

        modalStage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

