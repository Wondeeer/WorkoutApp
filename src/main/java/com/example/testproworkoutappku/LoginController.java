package com.example.testproworkoutappku;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage stage;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("a".equals(username) && "a".equals(password)) {
            System.out.println("Přihlášení úspěšné");

            // Načtení nové scény
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(WorkOutApplication.class.getResource("/FXML/jea.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                HelloController controller = fxmlLoader.getController();
                controller.setStage(stage);


                Stage stage = new Stage();
                stage.setTitle("Domů");
                stage.setScene(scene);
                stage.show();

                // Zavření přihlašovacího okna
                Stage loginStage = (Stage) usernameField.getScene().getWindow();
                loginStage.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Chybné uživatelské jméno nebo heslo");
            // Zde můžete zobrazit chybovou zprávu uživateli
        }
    }
}







