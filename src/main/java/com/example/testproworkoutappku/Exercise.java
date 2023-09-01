package com.example.testproworkoutappku;

public class Exercise {

    private final String nameOfExercise;
    private final double  calorieOfExercise;
    private final int difficultyOfExercise;


    public Exercise(String nameOfExercise, double calorieOfExercise, int difficultyOfExercise) {
        this.nameOfExercise = nameOfExercise;
        this.calorieOfExercise = calorieOfExercise;
        this.difficultyOfExercise = difficultyOfExercise;

    }

    public double getCalorieOfExercise() {
        return calorieOfExercise;
    }

    public int getDifficultyOfExercise() {
        return difficultyOfExercise;
    }

    public String getNameOfExercise() {
        return nameOfExercise;
    }

    @Override
    public String toString() {
        return  "Název cviku = " + nameOfExercise +
                ", Spálené kalorie = " + calorieOfExercise +
                ", Obtížnost = " + difficultyOfExercise ;
    }
}
