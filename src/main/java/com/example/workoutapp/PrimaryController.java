package com.example.workoutapp;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class PrimaryController implements Initializable {

    int i = 0;
    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;
    LimitedTextField limitedTextField;
    Function func = new Function();

    @FXML
    private ToolBar toolBar;
    @FXML
    private CheckBox checkBoxDifficulty, checkBoxExercise,checkBoxCalories;
    @FXML
    private TextField textFieldDifficulty, textFieldExercise, textFieldCalories, textfieldWeightBmi, textfieldHeightBmi;
    @FXML
    private TableColumn<Exercise,String> tableExercise;
    @FXML
    private TableColumn<Exercise,Double> tableCalories;
    @FXML
    private TableColumn<Exercise,Integer> tableDifficulty;
    @FXML
    private TableView<Exercise> tableView;
    @FXML
    private AnchorPane anchorpaneBmi;
    @FXML
    private Label labelResultBmi, labelBmiCase;



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
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
       // toolBar.setVisible(false);
    }


    @FXML
    void onExit(){
       stage.close();
    }

    @FXML
    void onFunction(){

    }

    @FXML
    void menuitemBmi(){
        anchorpaneBmi.setVisible(true);
    }

    @FXML
    void onActionButtonBmi(){
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        labelResultBmi.setText("Vaše BMI je: " + df.format(func.BMI(Double.parseDouble(textfieldWeightBmi.getText()), Double.parseDouble(textfieldHeightBmi.getText()))));
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        func.setLabel(labelBmiCase);
    }
}
