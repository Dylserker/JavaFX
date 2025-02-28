package Exo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo5 extends Application {

    @FXML
    private ComboBox<String> comboBoxVilles;
    @FXML
    private Label labelSelection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        comboBoxVilles = new ComboBox<>();
        labelSelection = new Label("Sélectionnez une ville");

        comboBoxVilles.getItems().addAll("Paris", "Lyon", "Marseille", "Bordeaux", "Toulouse");

        comboBoxVilles.setOnAction(event -> {
            String villeSelectionnee = comboBoxVilles.getValue();
            labelSelection.setText("Ville sélectionnée : " + villeSelectionnee);
        });

        VBox root = new VBox(10, comboBoxVilles, labelSelection);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Sélection de Ville");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}