package Exo;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo6 extends Application {

    public static class Person {
        private final StringProperty nom;
        private final StringProperty prenom;
        private final IntegerProperty age;

        public Person(String nom, String prenom, int age) {
            this.nom = new SimpleStringProperty(nom);
            this.prenom = new SimpleStringProperty(prenom);
            this.age = new SimpleIntegerProperty(age);
        }

        public String getNom() {
            return nom.get();
        }

        public void setNom(String nom) {
            this.nom.set(nom);
        }

        public StringProperty nomProperty() {
            return nom;
        }

        public String getPrenom() {
            return prenom.get();
        }

        public void setPrenom(String prenom) {
            this.prenom.set(prenom);
        }

        public StringProperty prenomProperty() {
            return prenom;
        }

        public int getAge() {
            return age.get();
        }

        public void setAge(int age) {
            this.age.set(age);
        }

        public IntegerProperty ageProperty() {
            return age;
        }
    }

    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> colNom;
    @FXML private TableColumn<Person, String> colPrenom;
    @FXML private TableColumn<Person, Integer> colAge;
    @FXML private TextField textFieldNom;
    @FXML private TextField textFieldPrenom;
    @FXML private TextField textFieldAge;

    private ObservableList<Person> personList;

    @Override
    public void start(Stage primaryStage) {
        tableView = new TableView<>();
        colNom = new TableColumn<>("Nom");
        colPrenom = new TableColumn<>("Prénom");
        colAge = new TableColumn<>("Âge");

        colNom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        colPrenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        colAge.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());

        personList = FXCollections.observableArrayList();
        tableView.setItems(personList);

        textFieldNom = new TextField();
        textFieldPrenom = new TextField();
        textFieldAge = new TextField();

        textFieldNom.setPromptText("Nom");
        textFieldPrenom.setPromptText("Prénom");
        textFieldAge.setPromptText("Âge");

        Button btnAjouter = new Button("Ajouter");
        Button btnSupprimer = new Button("Supprimer");

        btnAjouter.setOnAction(event -> ajouterPersonne());

        btnSupprimer.setOnAction(event -> supprimerPersonne());

        VBox vbox = new VBox(10, tableView, textFieldNom, textFieldPrenom, textFieldAge, btnAjouter, btnSupprimer);
        vbox.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Gestion des Personnes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void ajouterPersonne() {

        String nom = textFieldNom.getText();
        String prenom = textFieldPrenom.getText();
        int age = Integer.parseInt(textFieldAge.getText());

        Person person = new Person(nom, prenom, age);
        personList.add(person);

        textFieldNom.clear();
        textFieldPrenom.clear();
        textFieldAge.clear();
    }

    @FXML
    private void supprimerPersonne() {
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            personList.remove(selectedPerson);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
