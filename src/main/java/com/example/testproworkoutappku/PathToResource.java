package com.example.testproworkoutappku;

import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;

import java.util.Objects;

public class PathToResource {


    private final Font espresso = Font.loadFont(getClass().getResourceAsStream("/fonts/Espresso.ttf"), 20);
    private static final Image appIcon = new Image(Objects.requireNonNull(WorkOutApplication.class.getResourceAsStream("/images/weight.png")));
    private static final Image bcIm = new Image(Objects.requireNonNull(WorkOutApplication.class.getResourceAsStream("/images/Pozadi.png")));
    private static final BackgroundImage bcImage = new BackgroundImage(bcIm,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);


    public static Image getAppIcon() {
        return appIcon;
    }


    public static BackgroundImage getBcImage(){
        return bcImage;
    }

    public Font getEspresso(){
        return espresso;
    }


}
