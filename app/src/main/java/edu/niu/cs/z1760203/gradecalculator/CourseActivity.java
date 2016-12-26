/*****************************************************************************

 CSCI 522 - Graduate Student Project- Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 05/09/2016

 Purpose   : This activity provides the user with 4 Buttons(i.e
             Quizzes, Tests, Assignments and the go back button)
             using which the user can traverse to the corresponding
             activity.

 ******************************************************************************/

package edu.niu.cs.z1760203.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class CourseActivity extends Activity {


    // Initializing variables to hold screen objects
    private ImageButton quizBtn,
                        assignBtn,
                        examBtn;
    private TextView courseTV;
    String course;

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        // Connecting the initialized variables with the screen objects
        quizBtn = (ImageButton) findViewById(R.id.quizButton);
        assignBtn = (ImageButton) findViewById(R.id.assignButton);
        examBtn = (ImageButton) findViewById(R.id.examButton);
        courseTV = (TextView)findViewById(R.id.courseTextView);

        // Return the intent that started this activity.
        Intent intent3 = getIntent();
        course = intent3.getStringExtra("course");

        //checking whether to set the textView to CSCI 240 or CSCi 241
        //depending on the user's selection
        if (course.equals("240")){
            courseTV.setText("CSCI 240");
        }//course if

        else {
            courseTV.setText("CSCI 241");
        }//course else

        //setting onClickListener to quizzes button to handle the action
        quizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Defining intent(quizIntent) to go to the QuizActivity
                Intent quizIntent = new Intent(CourseActivity.this, quizActivity.class);
                quizIntent.putExtra("course", course);//Using putExtra method to send extra informatio along with the intent
                startActivity(quizIntent);
            }
        });//end of quiz onClickListener

    }//onCreate

    //Using finish method to go back to the home page
    public void goBack( View v)
    {
        finish();
    }


}//mainActivity ends here
