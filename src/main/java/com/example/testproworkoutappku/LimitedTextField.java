package com.example.testproworkoutappku;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class LimitedTextField {

    public LimitedTextField(TextField tf, String regex){
        tf.setTextFormatter(new TextFormatter<>(c -> c.getControlNewText().matches(regex) ? c : null));
        tf.getText();
    }
}