package org.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    int fieldHeight = 30;
    @Override
    public void start(Stage stage) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Benutzername");
        usernameField.setStyle("-fx-font-size: 20px;");
        usernameField.setPrefHeight(fieldHeight);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Passwort");
        passwordField.setStyle("-fx-font-size: 20px;");
        passwordField.setPrefHeight(fieldHeight);

        VBox root = getVBox(usernameField, passwordField);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 1000, 700);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    private static VBox getVBox(TextField usernameField, PasswordField passwordField) {
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 20px;");
        loginButton.setPrefHeight(30);
        loginButton.setPrefWidth(200);
        TextArea messageArea = new TextArea();
        messageArea.setStyle("-fx-font-size: 22px;");
        messageArea.setWrapText(true);
        messageArea.setEditable(false);

        messageArea.setPrefHeight(500);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                messageArea.setText("Bitte alle Felder ausfüllen!");
            } else {
                Persistence persistence = new Persistence();
                ArrayList<UserDTO> dtos = persistence.getUserData(username, password);
                if (dtos == null || dtos.isEmpty()) {
                    messageArea.setText("Ungültige Anmeldedaten");
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (UserDTO dto : dtos) {
                        stringBuilder.append("Nachname: ").append(dto.getNachname()).append("\n")
                                .append("Vorname: ").append(dto.getVorname()).append("\n")
                                .append("BIC: ").append(dto.getBic()).append("\n")
                                .append("IBAN: ").append(dto.getIban()).append("\n")
                                .append("PIN: ").append(dto.getPin()).append("\n")
                                .append("---------------------------------\n");
                    }
                    messageArea.setText(stringBuilder.toString());
                }
            }
        });
        loginButton.setDefaultButton(true);

        return new VBox(10, usernameField, passwordField, loginButton, messageArea);
    }

    public static void main(String[] args) {
        launch();
    }
}