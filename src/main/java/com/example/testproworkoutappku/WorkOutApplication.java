package com.example.testproworkoutappku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


public class WorkOutApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/login.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}






//package com.example.testproworkoutappku;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//import java.io.IOException;
//
//public class WorkOutApplication extends Application {
//
//
//
//    @Override
//    public void start(Stage stage) throws IOException {
//
//
//
//        FXMLLoader fxmlLoader = new FXMLLoader(WorkOutApplication.class.getResource("/FXML/PrimaryWindow.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//
//
//        HelloController controller = fxmlLoader.getController();
//        controller.setStage(stage);
//
//        stage.setScene(scene);
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.show();
//
//   }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
