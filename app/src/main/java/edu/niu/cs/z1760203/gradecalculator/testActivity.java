/*****************************************************************************

 CSCI 522 - Graduate Student Project- Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 05/09/2016

 Purpose   : This activity provides the user with several fields where the user
             can enter his/her test marks obtained during the semester. And also,
             there are two buttons (the Assignments and  Go Back Button) to traverse
             from this activity.

 ******************************************************************************/

package edu.niu.cs.z1760203.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class testActivity extends Activity {

    // Initializing variables to hold screen objects
    private EditText testET1,
                     testET2,
                     testET3;
    String course;
   // private TextView helloTV;
    double[] arrTest = new double[3];
    double nit,
           testPercent;

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Connecting the initialized variables with the screen objects
        testET1 = (EditText)findViewById(R.id.test1editText);

        //Using filters in order to accept a particular range of values in the EditText
        //here the user cannot enter a value greater than 100 and less than 0.
        testET1.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        testET2 = (EditText)findViewById(R.id.test2editText);
        testET2.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        testET3 = (EditText)findViewById(R.id.test3editText);
        testET3.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        // helloTV = (TextView)findViewById(R.id.helloTextView);
    }//onCreate

    //This method is used to check the editText values to empty,
    //To calculate the test marks percentage,
    //And to start an intent to go to Assignments Activity.
    public void testToAssign(View v) {

        //To check if the editText values are left empty,
        if (testET1.getText().toString().matches("") || testET2.getText().toString().matches("") || testET3.getText().toString().matches("")) {
            Toast.makeText(v.getContext(), "Cannot have empty field", Toast.LENGTH_LONG).show();
            return;
        }

        //Parsing the entered values
        arrTest[0] = Integer.parseInt(testET1.getText().toString());
        arrTest[1] = Integer.parseInt(testET2.getText().toString());
        arrTest[2] = Integer.parseInt(testET3.getText().toString());

        double testSum = 0;

        //Using for loop to calculate the sum of the 3 test scores.
        for (int i = 0; i < arrTest.length; i++) {
            testSum = testSum + arrTest[i];
        }//for ends here

        //Calculating the percentage of the test Scores
            testPercent = ((testSum * 100) / 300);
        //Using decimal format in order to limit the number of digits after decimal point
        DecimalFormat df = new DecimalFormat("0.00");
            //String convertTestPercent = df.format(testPercent);
            //helloTV.setText("The percent is : " + testPercent);

        //calculate average value
            /*
        testAverage = testSum / arrTest.length;

            DecimalFormat df = new DecimalFormat("0.00");
            String convertTestAverage = df.format(testAverage);

        helloTV.setText("The average is : " + convertTestAverage);

*/
        //Using getIntent method in order to retrieve the intent sent from the previous activity
        Intent intent3 = getIntent();
        course = intent3.getStringExtra("course");
            Intent intent = getIntent();

        //Using getDoubleExtra to get the quiz percentage from the previous activity
            nit = intent.getDoubleExtra("quizP", 0);
            //strTV.setText(String.valueOf(nit));

        // Defining intent(testToAssignIntent) to go to the assignmentActivity
        Intent testToAssignIntent = new Intent(testActivity.this, assignmentActivity.class);
        //Using putExtra method to send extra information (test percentage and quiz percentage)along with the intent
        testToAssignIntent.putExtra("TestP", testPercent);
        testToAssignIntent.putExtra("quizP", nit);
        testToAssignIntent.putExtra("course", course);
        startActivity(testToAssignIntent);

        //finish();

    }//testToAssign

    //Using finish method to go back to the previous activity
    public void goBack( View v)
    {
        finish();
    }
}//mainActivity
