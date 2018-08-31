package com.idegroup.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
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
        setContentView(R.layout.activity_fun_facts);
    }
}
