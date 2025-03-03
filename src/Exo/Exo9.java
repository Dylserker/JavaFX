package Exo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exo9 extends Application {
    @FXML
    private ProgressBar progressBar;
    private double progress = 0.0;

    @Override
    public void start(Stage primaryStage) {
        progressBar = new ProgressBar(0);

        Button chargeButton = new Button("Charger");
        chargeButton.setOnAction(e -> onChargeClick());

        Button downloadButton = new Button("Télécharger");
        downloadButton.setOnAction(e -> onDownloadClick());

        VBox root = new VBox(10, progressBar, chargeButton, downloadButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        primaryStage.setTitle("Progress Bar");
        primaryStage.setScene(new Scene(root, 350, 200));
        primaryStage.show();
    }

    @FXML
    private void onChargeClick() {
        if (progress < 1.0) {
            progress += 0.1;
            progressBar.setProgress(progress);
        }
    }

    @FXML
    private void onDownloadClick() {
        progress = 0.0;
        progressBar.setProgress(progress);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), event -> {
                    if (progress < 1.0) {
                        progress += 0.05;
                        progressBar.setProgress(progress);
                    }
                })
        );
        timeline.setCycleCount(20);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
