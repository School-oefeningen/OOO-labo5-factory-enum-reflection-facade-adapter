package domain.launcher;

import domain.model.GeheimschriftFacade;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class App extends Application {
    private GeheimschriftFacade geheimschriftFacade;

    @Override
    public void start(Stage primaryStage) throws Exception {
        geheimschriftFacade = new GeheimschriftFacade();

        primaryStage.setTitle("App voor een string te coderen/decoderen");
        FlowPane root = new FlowPane();
        Scene mainScene = new Scene(root, 800, 500);
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setVgap(5);
        root.setHgap(5);

        Label stringLabel = new Label("Tekst die je gaat coderen/decoderen");
        TextField stringTextfield = new TextField();

        Label verschillendeEncrypties = new Label("Encryptietypes");

        Label intCaesar = new Label("Geeft een cijfer als je voor Caesarencryptie kiest");
        TextField caesarGetalLabel = new TextField();

        ComboBox combobox = new ComboBox(FXCollections.observableArrayList(geheimschriftFacade.getAllEncryptionTypes()));
        Button decodeerBtn = new Button("Decodeer");
        Button codeerBtn = new Button("Codeer");

        Label uitkomstLabel = new Label("Resultaat");
        TextField uikomstResultaat = new TextField();

        root.getChildren().add(stringLabel);
        root.getChildren().add(stringTextfield);
        root.getChildren().add(verschillendeEncrypties);
        root.getChildren().add(combobox);
        root.getChildren().add(codeerBtn);
        root.getChildren().add(decodeerBtn);
        root.getChildren().add(intCaesar);
        root.getChildren().add(caesarGetalLabel);
        root.getChildren().add(uitkomstLabel);
        root.getChildren().add(uikomstResultaat);

        codeerBtn.setOnAction(a -> {
            try {
                String encryptieType = (String) combobox.getValue();
                String input = stringTextfield.getText();
                String caesarGetal = caesarGetalLabel.getText();

                geheimschriftFacade.setGeheimschriftBehaviour(encryptieType, caesarGetal);

                String output = geheimschriftFacade.encryptString(input);
                uikomstResultaat.setText(output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        decodeerBtn.setOnAction(a -> {
            try {
                String encryptieType = (String) combobox.getValue();
                String input = stringTextfield.getText();
                String caesarGetal = caesarGetalLabel.getText();

                geheimschriftFacade.setGeheimschriftBehaviour(encryptieType, caesarGetal);

                String output = geheimschriftFacade.decryptString(input);
                uikomstResultaat.setText(output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
