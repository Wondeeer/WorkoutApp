package com.example.workoutapp;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Function extends ExerciseDatabase {

    private Label labelBmiCase;


    public Function() {
        loadExercisesData();
    }

    public void setLabel(Label label) {
        this.labelBmiCase = label;
    }

    public List<Exercise> exerciseSelection(String nameOfExercise, String stringCalorie, String stringDifficulty) {
        // ObservableList<Exercise> list = FXCollections.observableArrayList();
        int size = 0;
        List<Exercise> result = new ArrayList<>();
        for (Exercise exercise : getExercisesFromDatabase()) {
            if (!nameOfExercise.equals("") && !exercise.getNameOfExercise().equals(nameOfExercise)) {
                continue;
            }
            if (!stringCalorie.equals("")) {
                double calorie = Double.parseDouble(stringCalorie);
                if (exercise.getCalorieOfExercise() != (calorie)) {
                    continue;
                }
            }
            if (!stringDifficulty.equals("")) {
                int difficulty = Integer.parseInt(stringDifficulty);
                if (exercise.getDifficultyOfExercise() != (difficulty)) {
                    continue;
                }
            }

            result.add(exercise);
            size++;
        }
        if (size == 0) {
            return Collections.emptyList();
        } else {
            return result;
        }
    }

    public double BMI(double weight, double height) {
        double result;
        if (weight == 0 || height == 0)
            return -1;
        else {
            height /= 100;
            height *= height;
            result = weight / height;
            BmiCase(result);
            return result;
        }
    }


    public void BmiCase(double bmi){
        if (bmi < 18.5){
            labelBmiCase.setTextFill(Color.BLUEVIOLET);
            labelBmiCase.setText("Podváha");
        } else if (bmi > 18.5 && bmi < 25) {
            labelBmiCase.setTextFill(Color.GREEN);
            labelBmiCase.setText("Optimální váha");
        }else if (bmi > 25.1 && bmi < 30) {
            labelBmiCase.setTextFill(Color.YELLOW);
            labelBmiCase.setText("Nadváha");
        }else if (bmi > 30.1 && bmi < 40) {
            labelBmiCase.setTextFill(Color.ORANGE);
            labelBmiCase.setText("Obezita");
        }else if (bmi > 40) {
            labelBmiCase.setTextFill(Color.RED);
            labelBmiCase.setText("Morbidní obezita");
        }
    }
}







//    public ObservableList exerciseSelection(String nameOfExercise, String stringCalorie, String stringDifficulty) {
//        ObservableList<Exercise> list = FXCollections.observableArrayList();
//        // List<Exercise> result = new ArrayList<>();
//        for (Exercise exercise : getExercisesFromDatabase()) {
//            if (!nameOfExercise.equals("") && !exercise.getNameOfExercise().equals(nameOfExercise)) {
//                continue;
//            }
//            if (!stringCalorie.equals("")){
//                double calorie = Double.parseDouble(stringCalorie);
//                if (exercise.getCalorieOfExercise() != (calorie)) {
//                    continue;
//                }
//            }
//            if (!stringDifficulty.equals("")) {
//                int difficulty = Integer.parseInt(stringDifficulty);
//                if (exercise.getDifficultyOfExercise() != (difficulty)) {
//                    continue;
//                }
//            }
//
//            list.add(exercise);
//        }
//        return list;
//        }






