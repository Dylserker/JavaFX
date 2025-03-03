package Exo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Exo10 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabPane = new TabPane();

        Tab tabAccueil = new Tab("Accueil");
        AnchorPane accueilPane = new AnchorPane();
        Label accueilLabel = new Label("Bienvenue sur l'Accueil !");
        accueilLabel.setLayoutX(100);
        accueilLabel.setLayoutY(100);
        Button accueilButton = new Button("Cliquez ici pour plus d'infos");
        accueilButton.setLayoutX(100);
        accueilButton.setLayoutY(150);
        accueilButton.setOnAction(e -> onAccueilClick());
        accueilPane.getChildren().addAll(accueilLabel, accueilButton);
        tabAccueil.setContent(accueilPane);

        Tab tabProfil = new Tab("Profil");
        AnchorPane profilPane = new AnchorPane();
        Label profilLabel = new Label("Nom: John Doe");
        profilLabel.setLayoutX(100);
        profilLabel.setLayoutY(100);
        Label profilAge = new Label("Âge: 30");
        profilAge.setLayoutX(100);
        profilAge.setLayoutY(150);
        Button profilButton = new Button("Mettre à jour Profil");
        profilButton.setLayoutX(100);
        profilButton.setLayoutY(200);
        profilButton.setOnAction(e -> onProfilClick());
        profilPane.getChildren().addAll(profilLabel, profilAge, profilButton);
        tabProfil.setContent(profilPane);

        Tab tabParametres = new Tab("Paramètres");
        AnchorPane parametresPane = new AnchorPane();
        Label paramLabel1 = new Label("Paramètre 1");
        paramLabel1.setLayoutX(100);
        paramLabel1.setLayoutY(100);
        Label paramLabel2 = new Label("Paramètre 2");
        paramLabel2.setLayoutX(100);
        paramLabel2.setLayoutY(150);
        Button paramButton = new Button("Modifier Paramètres");
        paramButton.setLayoutX(100);
        paramButton.setLayoutY(200);
        paramButton.setOnAction(e -> onParametresClick());
        parametresPane.getChildren().addAll(paramLabel1, paramLabel2, paramButton);
        tabParametres.setContent(parametresPane);

        tabPane.getTabs().addAll(tabAccueil, tabProfil, tabParametres);

        Scene scene = new Scene(tabPane, 400, 400);
        primaryStage.setTitle("Interface avec Onglets");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onAccueilClick() {
        showAlert("Accueil", "Vous avez cliqué sur Accueil !");
    }

    private void onProfilClick() {
        showAlert("Profil", "Vous avez mis à jour votre Profil !");
    }

    private void onParametresClick() {
        showAlert("Paramètres", "Vous avez modifié les paramètres !");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
