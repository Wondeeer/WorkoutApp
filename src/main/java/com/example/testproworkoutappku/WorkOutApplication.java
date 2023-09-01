package com.example.testproworkoutappku;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WorkOutApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(WorkOutApplication.class.getResource("/FXML/jea.fxml"));
        Scene scene = new Scene(fxmlLoader.load());


        HelloController controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}


// funkci add na pridani cviku primo v appce
// funkci ktera ukaze pouze cviky podle vyberu