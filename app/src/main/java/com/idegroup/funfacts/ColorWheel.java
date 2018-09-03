package com.idegroup.funfacts;

import android.graphics.Color;

import java.util.Random;

/*This class is intented to Randomly choose a color from the color wheel to be used in activities*/
public class ColorWheel {
    /*Fields: define all available color to choose from:*/

    public String[] colors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    /*Method: randomly select color*/
    public int getColor() {
        /*instantiate new random generator:*/

        Random randomGenerator = new Random();

        /*finding a new random int to represent the index of the color wheel array:*/
        int randomNumber = randomGenerator.nextInt(colors.length);

        /*return the randomly chosen color*/

        return Color.parseColor(colors[randomNumber]);/*<- we use Color class parseColor since we not just converting
        String to conventional integer, ratehr we convert it into color hex code*/
    };
}
