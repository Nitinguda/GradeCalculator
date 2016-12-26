/*****************************************************************************

 CSCI 522 - Graduate Student Project- Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 05/09/2016

 Purpose   : This application enables the user to calculate the grade
             for various classes in the Computer Science department. The user
             can select one of the courses available in the home page. And then,
             the user needs to enter his/her quiz, tests and assignment scores obtained
             during the semester to check their final grade.

 ******************************************************************************/

package edu.niu.cs.z1760203.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    // Initializing variables to hold screen objects
    private ImageButton csci240IB;

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting the initialized variables with the screen objects
        csci240IB = (ImageButton)findViewById(R.id.csci240);

    }//onCreate

    // Defining intent(contentIntent) to go to the CourseActivity for CSCI 240
    public void showSections240( View v)
    {
        String course = "240";
        Intent contentIntent = new Intent(MainActivity.this, CourseActivity.class);
        contentIntent.putExtra("course", course);
        startActivity(contentIntent);
    }//showSections240 ends here

    // Defining intent(contentIntent) to go to the CourseActivity for CSCI 241
    public void showSections241( View v)
    {
        String course = "241";
        Intent contentIntent = new Intent(MainActivity.this, CourseActivity.class);
        contentIntent.putExtra("course", course);
        startActivity(contentIntent);
    }//showSections241 ends here


}//mainActivity