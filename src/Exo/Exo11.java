package Exo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Random;

public class Exo11 extends Application {

    private int score = 0;
    private int timeLeft = 30;
    private Timeline timeline;
    @FXML
    private Label scoreLabel;
    @FXML
    private Text timerText;
    @FXML
    private Button targetButton;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/JavaFX.fxml"));
        Pane root = loader.load();

        scoreLabel = (Label) root.lookup("#scoreLabel");
        timerText = (Text) root.lookup("#timerText");
        targetButton = (Button) root.lookup("#targetButton");

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTimer()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Speed Click Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTimer() {
        if (timeLeft > 0) {
            timeLeft--;
            timerText.setText("Time left: " + timeLeft + "s");
        } else {
            endGame();
        }

        targetButton.setLayoutX(random.nextInt(350) + 50);
        targetButton.setLayoutY(random.nextInt(250) + 50);
    }

    public void onTargetButtonClicked() {
        if (timeLeft > 0) {
            score++;
            scoreLabel.setText("Score: " + score);
        }
    }

    private void endGame() {
        timeline.stop();
        targetButton.setDisable(true);
        timerText.setText("Temps écoulé ! Score final: " + score);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
