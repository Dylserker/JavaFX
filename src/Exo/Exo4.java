package Exo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo4 extends Application {
    private int compteur = 0;

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Compteur : " + compteur);

        Button btnPlus = new Button("+");
        btnPlus.setOnAction(e -> {
            compteur++;
            label.setText("Compteur : " + compteur);
        });

        Button btnMoins = new Button("-");
        btnMoins.setOnAction(e -> {
            compteur--;
            label.setText("Compteur : " + compteur);
        });

        Button btnRouge = new Button("Rouge");
        Button btnVert = new Button("Vert");
        Button btnBleu = new Button("Bleu");

        btnRouge.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        btnVert.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        btnBleu.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        btnRouge.setOnAction(e -> label.getScene().getRoot().setStyle("-fx-background-color: red;"));
        btnVert.setOnAction(e -> label.getScene().getRoot().setStyle("-fx-background-color: green;"));
        btnBleu.setOnAction(e -> label.getScene().getRoot().setStyle("-fx-background-color: blue;"));

        VBox root = new VBox(10, label, btnPlus, btnMoins, btnRouge, btnVert, btnBleu);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center; -fx-background-color: white;");

        Scene scene = new Scene(root, 250, 250);
        primaryStage.setTitle("Compteur JavaFX avec Couleurs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}