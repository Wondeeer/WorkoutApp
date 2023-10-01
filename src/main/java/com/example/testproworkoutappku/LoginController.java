package com.example.testproworkoutappku;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    //-------------Here is database name, root is username and password-------------
                    "jdbc:mysql://*************", "******", "*****************");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next())
                if (rs.getString(2).equals(username) && rs.getString(3).equals(password)) {
                    System.out.println("Přihlášení úspěšné");

                    // ----------------------Load new Scene-------------------------
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(WorkOutApplication.class.getResource("/FXML/PrimaryWindow.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());

                        HelloController controller = fxmlLoader.getController();
                        controller.setStage(stage);


                        Stage stage = new Stage();
                        stage.setTitle("Domů");
                        stage.setScene(scene);
                        stage.show();

                        // --------Closing the deposit window--------
                        Stage loginStage = (Stage) usernameField.getScene().getWindow();
                        loginStage.close();
                        con.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Chybné uživatelské jméno nebo heslo");
                }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}







