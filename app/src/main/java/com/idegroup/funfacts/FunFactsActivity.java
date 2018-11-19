package com.idegroup.funfacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*
* In Android Activity represent the screen that user can interact with
* */
public class FunFactsActivity extends AppCompatActivity {

    /*Adding TAG to make it easier to log any information from this class:*/

    public static final String TAG = FunFactsActivity.class.getSimpleName();/*<- static always availabe but final cannot
     be changed!
     NOTE: we using class get simple name to get just the name but no package name inserted*/
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";

    /* Declare our View variables:
    * Prior to this course I always think that all field in Android should start with m such as mFactTextView but in
    * this session it omit that means it follows the general programming format..*/
    private TextView factTextView;
    private Button showFactButton;

    /*in order to change the background color dynamically we need to define the background of the activity:*/

    private RelativeLayout relativeLayout;/*<- this is where the background of this activity is defined*/

    /*insert newly random mFact by instantiating FactBook object to this activity:*/

    private FactBook factBook = new FactBook();/*<- this is the best place to instatiate FactBook object!
    NOTE: FactBook() means we use default constructor*/

    /*instantiate colorWheel object to gain randomly selected color code:*/

    private ColorWheel colorWheel = new ColorWheel();
    private String mFact;
    private int mColor;

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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

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

                mFact = factBook.getFact();

                factTextView.setText(mFact);/*<- getFact from the factBook object to be shown*/

                /*Now changing to new color when we press the button:*/

                int mColor = colorWheel.getColor();
                relativeLayout.setBackgroundColor(mColor);/*<- read the Documentation*/

                /*Set the text color in the button the same as the background:*/

                showFactButton.setTextColor(mColor);

                /*NOTE: this is not done yet we also need to modify the xml file to ensure the started button also has
                * the same background color of the start up page which is a green*/
            }
        };
        showFactButton.setOnClickListener(listener);

        /*Let's make new toast: NOTE : this only works inside the onCreate method when I try to put it inside the
        * activity class but outside of any method it does not work! Read more on Toast Android Developer Doc*/

        //Toast.makeText(this, "Yay!", Toast.LENGTH_SHORT).show();/*<- this keyword refer to current object*/

        /*logging the activity:*/

        Log.d(TAG, "We're logging from the onCreate method");/*<- tag is our means to identify
        where this logging process take place. Although we are free to give any name but it is a good practice to
        specify the class where this logging is take place in order to sort it out in the future. This is done using
        the static final TAG constant defined after the class declaration!*/
    }

}
