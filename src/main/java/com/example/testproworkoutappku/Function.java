package com.example.testproworkoutappku;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Function extends ExerciseDatabase {

    public List<Exercise> exerciseSelection(String nameOfExercise, String stringCalorie, String stringDifficulty) {
       // ObservableList<Exercise> list = FXCollections.observableArrayList();
        int size = 0;
         List<Exercise> result = new ArrayList<>();
        for (Exercise exercise : getExercisesFromDatabase()) {
            if (!nameOfExercise.equals("") && !exercise.getNameOfExercise().equals(nameOfExercise)) {
                continue;
            }
            if (!stringCalorie.equals("")){
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
        }
        else {
            return result;
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






