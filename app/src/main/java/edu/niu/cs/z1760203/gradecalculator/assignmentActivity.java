/*****************************************************************************

 CSCI 522 - Graduate Student Project- Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 05/09/2016

 Purpose   : This activity provides the user with several fields where the user
             can enter his/her assignment marks obtained during the semester. And also,
             there are two buttons (the Calculate grade and  Go to courses Button) to traverse
             from this activity.

 ******************************************************************************/

package edu.niu.cs.z1760203.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class assignmentActivity extends Activity {

    // Initializing variables to hold screen objects
    private EditText[] assignET = new EditText[10];//Using an array of editTexts to get the input from user.
    private ImageButton assignBtn,calcBtn;
    private TextView testTV,test11TV, test9, test10;
    String course="";
    int temp;

    double assignArr[] = new double[10];
    Double assignmentAverage, nit2, nit3, testQuizAvg, aFinal, assignPercent, bFinal, cFinal;
    Double assignmentSum = 0.0;

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        // Connecting the initialized variables with the screen objects
        assignET[0] = (EditText)findViewById(R.id.assign1editText);
        //Using filters in order to accept a particular range of values in the EditText
        //here the user cannot enter a value greater than 100 and less than 0.
        assignET[0].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[1] = (EditText)findViewById(R.id.assign2editText);
        assignET[1].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[2] = (EditText)findViewById(R.id.assign3editText);
        assignET[2].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[3] = (EditText)findViewById(R.id.assign4editText);
        assignET[3].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[4] = (EditText)findViewById(R.id.assign5editText);
        assignET[4].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[5] = (EditText)findViewById(R.id.assign6editText);
        assignET[5].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[6] = (EditText)findViewById(R.id.assign7editText);
        assignET[6].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[7] = (EditText)findViewById(R.id.assign8editText);
        assignET[7].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[8] = (EditText)findViewById(R.id.assign9editText);
        assignET[8].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        assignET[9] = (EditText)findViewById(R.id.assign10editText);
        assignET[9].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});

        testTV = (TextView)findViewById(R.id.test2TextView);
        test11TV = (TextView)findViewById(R.id.textView11);
        test9 = (TextView)findViewById(R.id.textView37);
        test10 = (TextView)findViewById(R.id.textView38);
        /*dTV1 =  (TextView)findViewById(R.id.dummytextView1);
        dTV2 =  (TextView)findViewById(R.id.dummytextView2);
        dTV3 =  (TextView)findViewById(R.id.dummytextView3);*/
        calcBtn = (ImageButton)findViewById(R.id.calcButton);

        //Using getIntent method in order to retrieve the intent sent from the previous activity
        Intent intent3 = getIntent();
        course = intent3.getStringExtra("course");

        testTV.setVisibility(View.GONE);

        //Using the setVisibility method to hide two editTexts as CSCI 241 course
        //has only 8 assignments
        if (course.equals("241")){
            assignET[8].setVisibility(View.GONE);
            test9.setText("");
            assignET[9].setVisibility(View.GONE);
            test10.setText("");
        }//visibility if

        //setting onClickListener to calculate button to handle the action
        calcBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            //Using the setVisibility method to hide the calculate button
            //and show the Final grade
            calcBtn.setVisibility(View.GONE);
            test11TV.setText("");
            testTV.setVisibility(View.VISIBLE);

            if (course.equals("240")){
                //Checking if a field is left empty by the user for CSCI 240 course
                if (assignET[0].getText().toString().matches("") ||
                assignET[0].getText().toString().matches("") ||
                assignET[1].getText().toString().matches("") ||
                assignET[2].getText().toString().matches("") ||
                assignET[3].getText().toString().matches("") ||
                assignET[4].getText().toString().matches("") ||
                assignET[5].getText().toString().matches("") ||
                assignET[6].getText().toString().matches("") ||
                assignET[7].getText().toString().matches("") ||
                assignET[8].getText().toString().matches("") ||
                assignET[9].getText().toString().matches("")) {
            Toast.makeText(v.getContext(), "Cannot have empty field", Toast.LENGTH_LONG).show();
            return;
        }//inner If ends here
            }//outer if ends here
            else {
                //Checking if a field is left empty by the user for CSCI 241 course
                if (assignET[0].getText().toString().matches("") ||
                        assignET[0].getText().toString().matches("") ||
                        assignET[1].getText().toString().matches("") ||
                        assignET[2].getText().toString().matches("") ||
                        assignET[3].getText().toString().matches("") ||
                        assignET[4].getText().toString().matches("") ||
                        assignET[5].getText().toString().matches("") ||
                        assignET[6].getText().toString().matches("") ||
                        assignET[7].getText().toString().matches("")){
                    Toast.makeText(v.getContext(), "Cannot have empty field", Toast.LENGTH_LONG).show();
                    return;
                }//Inner if ends here
            }//else ends here

            //using if-else condition to parse the integers for CSCI 240 and CSCI 241
            if (course.equals("240"))
            {

                //Using a for loop in order to loop through the array of integers  for CSCI 240 Assignments and parse them
                for (int k = 0; k < assignET.length; k++)
                {
                    assignArr[k] = Double.parseDouble(assignET[k].getText().toString());
                }//parse for ends here

                //Using for loop to calculate the sum of Assignment scores for CSCI 240
                for (int i = 0; i < assignArr.length; i++)
                {
                    assignmentSum = assignmentSum + assignArr[i];
                }//sum for loop ends here
            }//if ends here
            else
            {
                //To loop through the array of integers  for CSCI 240 Assignments and parse them
                //as CSCI 241 has only 10 assignments
                for (int k = 0; k < assignET.length - 2; k++)
                {
                    assignArr[k] = Double.parseDouble(assignET[k].getText().toString());
                }//parse for ends here
                //To calculate the sum of Assignment scores for CSCI 240
                for (int i = 0; i < assignArr.length - 2; i++)
                {
                    assignmentSum = assignmentSum + assignArr[i];
                }//sum for ends here
            }//else ends here

            //temp = ((assignArr.length) * 10);

            //Calculating the assignment Percentage
            assignPercent = ((assignmentSum) / (assignArr.length));
            DecimalFormat df = new DecimalFormat("0.00");
            //String convertAssignPercent = df.format(assignPercent);

            //Using getIntent method in order to retrieve the intent sent from the previous activity
            Intent intent1 = getIntent();

            //Using getDoubleExtra to get the test percentage from the previous activity
            nit2 = intent1.getDoubleExtra("TestP", 0);
            Intent intent2 = getIntent();

            //Using getDoubleExtra to get the quiz percentage
            nit3 = intent2.getDoubleExtra("quizP", 0);
            testQuizAvg = ((nit2 + nit3)/2);


            if(course!="") {
                //Calculating the weightage of tests, quizzes and assignments for CSCI 240
                //The test and quiz scores account to 70% of the total grade
                //The Assignment scores account to 30% of the total grade
                if (course.equals("240")) {
                    aFinal = ((testQuizAvg * 70) / 100);
                    bFinal = ((assignPercent * 30) / 100);
                }//ifcourse

                //Calculating the weightage of tests, quizzes and assignments for CSCI 241
                //The test and quiz scores account to 60% of the total grade
                //The Assignment scores account to 40% of the total grade
                else {
                    aFinal = ((testQuizAvg * 60) / 100);
                    bFinal = ((assignPercent * 40) / 100);
                }//course else

                //Calculating the final grade
                cFinal = aFinal + bFinal;
            }

        //Assigning letter grades based on the final score
        if(cFinal >= 90){
            testTV.setText("Your Final grade : A");
        }
        else if (cFinal >= 80){
            testTV.setText("Your Final grade : B");
        }
        else if (cFinal >= 70){
            testTV.setText("Your Final grade : C");
        }
        else if (cFinal >= 60){
            testTV.setText("Your Final grade : D");
        }
        else {
            testTV.setText("Your Final grade : F");
        }

        }//onClick ends here
    });//onClickListener ends here
    //}//calculateGrade

    }//onCreate ends here

        //finish();

    // Defining intent(backIntent) to go to the QuizActivity
    public void goBack( View v)
        {
            Intent backIntent = new Intent(assignmentActivity.this, MainActivity.class);
            startActivity(backIntent);
        }

}//MainActivity
