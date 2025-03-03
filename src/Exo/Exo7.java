package Exo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;

public class Exo7 extends Application {
    @FXML private ListView<String> listView;
    @FXML private ImageView imageView;
    @FXML private Pane dropPane;

    private ObservableList<String> imagePaths;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/JavaFX.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Visionneuse d'Images");
        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
    }

    @FXML
    public void initialize() {
        imagePaths = FXCollections.observableArrayList(
                "file:Images/GokuSSBU.png",
                "file:Images/GokuSSG.jpg",
                "file:Images/GokuUiTec.jpg"
        );
        listView.setItems(imagePaths);
    }

    @FXML
    private void onImageSelected(MouseEvent event) {
        String selectedImage = listView.getSelectionModel().getSelectedItem();
        if (selectedImage != null) {
            imageView.setImage(new Image(selectedImage));
        }
    }

    @FXML
    private void onDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void onDragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasFiles()) {
            File file = db.getFiles().get(0);
            String filePath = "file:" + file.getAbsolutePath();
            imagePaths.add(filePath);
            imageView.setImage(new Image(filePath));
        }
        event.setDropCompleted(true);
        event.consume();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
