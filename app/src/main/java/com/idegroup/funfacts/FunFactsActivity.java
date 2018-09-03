package com.idegroup.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*
* In Android Activity represent the screen that user can interact with
* */
public class FunFactsActivity extends AppCompatActivity {

    /* Declare our View variables:
    * Prior to this course I always think that all field in Android should start with m such as mFactTextView but in
    * this session it omit that means it follows the general programming format..*/
    private TextView factTextView;
    private Button showFactButton;

    /*in order to change the background color dynamically we need to define the background of the activity:*/

    private RelativeLayout relativeLayout;/*<- this is where the background of this activity is defined*/

    /*insert newly random fact by instantiating FactBook object to this activity:*/

    private FactBook factBook = new FactBook();/*<- this is the best place to instatiate FactBook object!
    NOTE: FactBook() means we use default constructor*/

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

        relativeLayout = findViewById(R.id.factRelativeLayout);/*<- refer to factActivityPage for activity group view*/

        /*Now we will make our button do something:*/
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                factTextView.setText(factBook.getFact());/*<- getFact from the factBook object to be shown*/

                /*Now changing to new color when we press the button:*/

                relativeLayout.setBackgroundColor(Color.RED);/*<- more of the usage of Color class in the Documentation*/
            }
        };
        showFactButton.setOnClickListener(listener);
    }
}
