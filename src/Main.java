import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Clique-moi !");
        button.setOnAction(e -> System.out.println("Hello, JavaFX !"));
        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 1200, 800);

        primaryStage.setTitle("JavaFX Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}