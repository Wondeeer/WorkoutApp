package com.example.workoutapp;


import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private Label labelLoginFail;
    @FXML
    private Button buttonLogin;
    @FXML
    private Label labelDatabaseFail;
    @FXML
    private PasswordField passwordField;


    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    //-------------Here is database name, root is username and password-------------
                    "**********************************************************");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next())
                if (rs.getString(2).equals(username) && rs.getString(3).equals(password)) {
                    System.out.println("Přihlášení úspěšné");

                    // ----------------------Load new Scene-------------------------
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(WorkOutApplication.class.getResource("/FXML/PrimaryWindow.fxml"));
                        Parent root1 = fxmlLoader.load();
                        PrimaryController controller = fxmlLoader.getController();
                        Stage stage = new Stage();
                        controller.setStage(stage);
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(new Scene(root1));
                        stage.show();

                        // --------Closing the deposit window--------
                        Stage loginStage = (Stage) usernameField.getScene().getWindow();
                        loginStage.close();
                        con.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    labelLoginFail.setVisible(true);
                    PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
                    visiblePause.setOnFinished(
                            event -> labelLoginFail.setVisible(false)
                    );
                    visiblePause.play();
                }
        } catch (Exception e) {
            labelDatabaseFail.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(3));
            visiblePause.setOnFinished(
                    event -> labelDatabaseFail.setVisible(false)
            );
            visiblePause.play();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonLogin.setDefaultButton(true);
    }
}








