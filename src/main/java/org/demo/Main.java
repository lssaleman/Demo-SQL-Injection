package org.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Benutzername");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Passwort");

        VBox root = getVBox(usernameField, passwordField);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 500, 700);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    private static VBox getVBox(TextField usernameField, PasswordField passwordField) {
        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Bitte alle Felder ausfüllen!");
            } else {
                Persistence persistence = new Persistence();
                ArrayList<UserDTO> dtos = persistence.getUserData(username, password);
                if (dtos == null || dtos.isEmpty()) {
                    messageLabel.setText("Ungültige Anmeldedaten");
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
                    messageLabel.setText(stringBuilder.toString());
                }
            }
        });

        return new VBox(10, usernameField, passwordField, loginButton, messageLabel);
    }

    public static void main(String[] args) {
        launch();
    }
}