package Exo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo3 extends Application {
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

        VBox root = new VBox(10, label, btnPlus, btnMoins);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(root, 200, 150);
        primaryStage.setTitle("Compteur JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
