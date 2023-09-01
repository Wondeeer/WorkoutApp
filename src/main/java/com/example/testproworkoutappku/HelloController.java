package com.example.testproworkoutappku;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    int loadData;
    int i = 0;
    private Stage stage;

    private double xOffset = 0;
    private double yOffset = 0;

    private final Function func = new Function();

    @FXML
    private ToolBar toolBar;
    @FXML
    private CheckBox checkBoxDifficulty, checkBoxExercise,checkBoxCalories;
    @FXML
    private TextField textFieldDifficulty, textFieldExercise, textFieldCalories;

    @FXML
    private TableColumn<Exercise,String> tableExercise;
    @FXML
    private TableColumn<Exercise,Double> tableCalories;

    @FXML
    private TableColumn<Exercise,Integer> tableDifficulty;
    @FXML
    private TableView<Exercise> tableView;
    private LimitedTextField limitedTextField;




    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void onExercise() {
        tableView.setItems(func.getObservableList(func.getExercisesFromDatabase()));
        tableExercise.setCellValueFactory(new PropertyValueFactory<Exercise,String>("nameOfExercise"));
        tableCalories.setCellValueFactory(new PropertyValueFactory<Exercise,Double>("calorieOfExercise"));
        tableDifficulty.setCellValueFactory(new PropertyValueFactory<Exercise,Integer>("difficultyOfExercise"));
    }

    @FXML
    void onSearchButton(){
        if (!checkBoxDifficulty.isSelected()){
            textFieldDifficulty.setText("");
        }
        if (!checkBoxExercise.isSelected()){
            textFieldExercise.setText("");
        }
        if (!checkBoxCalories.isSelected()){
            textFieldCalories.setText("");
        }
//        func.exerciseSelection(textFieldExercise.getText(),textFieldCalories.getText(),textFieldDifficulty.getText());
        tableView.setItems(func.getObservableList(func.exerciseSelection(textFieldExercise.getText(),textFieldCalories.getText(),textFieldDifficulty.getText())));
        tableExercise.setCellValueFactory(new PropertyValueFactory<Exercise,String>("nameOfExercise"));
        tableCalories.setCellValueFactory(new PropertyValueFactory<Exercise,Double>("calorieOfExercise"));
        tableDifficulty.setCellValueFactory(new PropertyValueFactory<Exercise,Integer>("difficultyOfExercise"));


    }

    @FXML
    void onCheckBoxDifficulty (){
        textFieldDifficulty.setVisible(checkBoxDifficulty.isSelected());

       }
    @FXML
    void onCheckBoxExercise(){
        textFieldExercise.setVisible(checkBoxExercise.isSelected());
    }
    @FXML
    void onCheckBoxCalories(){
        textFieldCalories.setVisible(checkBoxCalories.isSelected());
    }
   @FXML
   void onKeyTypedTFDifficulty() {
       limitedTextField = new LimitedTextField(textFieldDifficulty,"[0-9]{0,1}");
   }
   @FXML
   void onKeyTypedTFExercise() {
       limitedTextField = new LimitedTextField(textFieldExercise,"\\D{0,10}");
   }
    @FXML
    void onKeyTypedTFCalories() {
       limitedTextField = new LimitedTextField(textFieldCalories,"[0-9]{0,5}");
    }


    @FXML
    void onMouseDragged(MouseEvent event){
        Stage stage = (Stage) toolBar.getScene().getWindow();
        stage.setY(event.getScreenY() - yOffset);
        stage.setX(event.getScreenX() - xOffset);
    }
    @FXML
    void onMousePressed(MouseEvent event){
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    @FXML
    void fullScreen(){
        stage.setMaximized((i % 2) == 0);
        i++;
    }
    @FXML
    void minimalizeScreen(){
        stage.setIconified(true);
    }

    @FXML
    void fullScreenButton(){
        stage.setFullScreen(true);
    }


    @FXML
    void onExit(){
       stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        func.loadExercisesData();

    }
}
