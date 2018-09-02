package com.idegroup.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/*
* In Android Activity represent the screen that user can interact with
* */
public class FunFactsActivity extends AppCompatActivity {

    /* Declare our View variables:
    * Prior to this course I always think that all field in Android should start with m such as mFactTextView but in
    * this session it omit that means it follows the general programming format..*/
    private TextView factTextView;
    private Button showFactButton;

    /*
        The on create method is called when our activity first time created
    * Since our app only has this one activity this onCreate method will be called when our app is first started
    * Notice that this method also has one parameter a Bundle called savedInstanceState.
    * We wont be using this variable in our app so let's ignore it for now.
    *
    * Inside onCreate the most important thing is the call to setContentView. This method tells the activity which
    * layout file is use for the screen. The R.layout.activity_fun_facts parameter is an id which points to the activity
    * _fun_facts XML file in the layout directory which we modified earlier.
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);/*<- R here means generated class by Android called Resources!!
        it's located: /home/idegroup/IdeProject/FunFacts/app/build/generated/source/r/debug/com/idegroup/funfacts/R.java*/

        /*Assign the views from the Layout File to corresponding variable:
        * NOTE: assign views only after the setContentView!!!
        *
        * */

        factTextView = findViewById(R.id.factTextView);/*<- this R can find the int id which requested by findViewByID*/
        showFactButton = findViewById(R.id.showFactButton);/*<- pelase remember we set the id of our button as this!*/

        /*Now we will make our button do something:*/
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Adding all available facts:*/
                String[] facts = {
                        "Ants stretch when they wake up in the morning.",
                        "Ostriches can run faster than horses.",
                        "Olympic gold medals are actually made mostly of silver.",
                        "You are born with 300 bones; by the time you are an adult you will have 206.",
                        "It takes about 8 minutes for light from the Sun to reach Earth.",
                        "Some bamboo plants can grow almost a meter in just one day.",
                        "The state of Florida is bigger than England.",
                        "Some penguins can leap 2-3 meters out of the water.",
                        "On average, it takes 66 days to form a new habit.",
                        "Mammoths still walked the earth when the Great Pyramid was being built.",
                        "Treehouse is not actually in a tree."};

                /* The button was clicked thus update the TextView with a new fact!*/

                /*We need to set randomness using random number generator:*/

                Random randomGenerator = new Random();/*<- this is the random number generator*/

                int randomNumber = randomGenerator.nextInt(facts.length);/*<- store random generated int in respect
                dynamically with the length of the facts array!*/

                String fact = facts[randomNumber];/*<- we set the fact to be displayed by addressing the index in facts*/


                factTextView.setText(fact);/*<- update the factTextView in xml with new fact above!*/
            }
        };
        showFactButton.setOnClickListener(listener);
    }
}
