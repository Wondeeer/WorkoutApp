package com.example.testproworkoutappku;

import com.google.gson.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class  ExerciseDatabase {
    private final List<Exercise> exercises = new ArrayList<>();


    public ObservableList<Exercise> getObservableList(List<Exercise> exercises){
        ObservableList<Exercise> list = FXCollections.observableArrayList();
        list.addAll(exercises);
        return list;
    }


    public int numberOfExercises(){
        return exercises.size();
    }

    public String allExercises(){
        return exercises.toString();
    }

    public List<Exercise> getExercisesFromDatabase(){
        return exercises;
    }


    //---------------------------------Function for load data from JSON----------------------------------
    public void loadExercisesData(){
       Gson gson = new Gson();
        //List<Exercise> exercisee = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("jsonFile/Exercises.json"));
            JsonArray exercisesJsonArray = gson.fromJson(br, JsonArray.class);

            for (int i = 0; i < exercisesJsonArray.size(); i++) {
                JsonObject exerciseObj = exercisesJsonArray.get(i).getAsJsonObject();

                String nameOfExercise = exerciseObj.get("nameOfExercise").getAsString();
                double calorieOfExercise = exerciseObj.get("calorieOfExercise").getAsDouble();
                int difficultyOfExercise = exerciseObj.get("difficultyOfExercise").getAsInt();

                Exercise exercise = new Exercise(nameOfExercise, calorieOfExercise, difficultyOfExercise);
               // exercisee.add(exercise);
                this.exercises.add(exercise);
            }
            br.close();
            //this.exercises = exercisee;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
