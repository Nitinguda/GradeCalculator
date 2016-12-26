/*****************************************************************************

 CSCI 522 - Graduate Student Project- Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 05/09/2016

 Purpose   : This activity provides the user with several fields where the user
             can enter his/her quiz marks obtained during the semester. And also,
             there are two buttons (the Tests and  Go Back Button) to traverse
             from this activity.

 ******************************************************************************/

package edu.niu.cs.z1760203.gradecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class quizActivity extends Activity {

    // Initializing variables to hold screen objects
    private EditText[] quizzyET = new EditText[12]; //Using an array of editTexts to get the input from user.
    private ImageButton examBtn;
    String course;
    double quizArr[] = new double[12];
    Double quizSum,
           quizPercent,
           sumTemp,
           first,
           second;
    int arr_size = quizArr.length;

    //double first, second, arr_size = quizArr.length;

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Return the intent that started this activity.
        Intent intent = getIntent();

        //using getExtra to get the extra Information along with the intent
        course = intent.getExtras().getString("course");

        // Connecting the initialized variables with the screen objects
        examBtn = (ImageButton)findViewById(R.id.examButton);
        quizzyET[0] = (EditText)findViewById(R.id.quiz1editText);

        //Using filters in order to accept a particular range of values in the EditText
        //here the user cannot enter a value greater than 10 and less than 0.
        quizzyET[0].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[1] = (EditText)findViewById(R.id.quiz2editText);
        quizzyET[1].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[2] = (EditText)findViewById(R.id.quiz3editText);
        quizzyET[2].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[3] = (EditText)findViewById(R.id.quiz4editText);
        quizzyET[3].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[4] = (EditText)findViewById(R.id.quiz5editText);
        quizzyET[4].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[5] = (EditText)findViewById(R.id.quiz6editText);
        quizzyET[5].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[6] = (EditText)findViewById(R.id.quiz7editText);
        quizzyET[6].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[7] = (EditText)findViewById(R.id.quiz8editText);
        quizzyET[7].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[8] = (EditText)findViewById(R.id.quiz9editText);
        quizzyET[8].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[9] = (EditText)findViewById(R.id.quiz10editText);
        quizzyET[9].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[10] = (EditText)findViewById(R.id.quiz11editText);
        quizzyET[10].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        quizzyET[11] = (EditText)findViewById(R.id.quiz12editText);
        quizzyET[11].setFilters(new InputFilter[]{ new InputFilterMinMax("0", "10")});
        //smallTV = (TextView)findViewById(R.id.smallTextView);
        //small2TV = (TextView)findViewById(R.id.small2TextView);


    }//onCreate

    //This method is used to check the editText values to empty,
    //To calculate the quiz marks(minus two lowest quizzes) percentage,
    //And to start an intent to go to Tests Activity.
       public void quizToTest(View v) {

           //Checking if a field is left empty by the user
            if (quizzyET[0].getText().toString().matches("") ||
                    quizzyET[0].getText().toString().matches("") ||
                    quizzyET[1].getText().toString().matches("") ||
                    quizzyET[2].getText().toString().matches("") ||
                    quizzyET[3].getText().toString().matches("") ||
                    quizzyET[4].getText().toString().matches("") ||
                    quizzyET[5].getText().toString().matches("") ||
                    quizzyET[6].getText().toString().matches("") ||
                    quizzyET[7].getText().toString().matches("") ||
                    quizzyET[8].getText().toString().matches("") ||
                    quizzyET[9].getText().toString().matches("") ||
                    quizzyET[10].getText().toString().matches("") ||
                    quizzyET[11].getText().toString().matches("")) {

                //Setting a toast message to notify the user that a field is left empty
                Toast.makeText(v.getContext(), "Cannot have empty field", Toast.LENGTH_LONG).show();
                return;
            }//end of matches-if

           //Using a for loop in order to loop through the array of integers and parse them
        for(int k=0; k < quizzyET.length ; k++)
        {
            quizArr[k] = Double.parseDouble(quizzyET[k].getText().toString());
        }//end of parsing for

            /**************************************************/
           //static void print2Smallest(double arr[]) {

           //In order to subtract the two lowest quiz scores
        /* There should be atleast two elements */
               if (arr_size < 2)
               {
                   System.out.println(" Invalid Input ");
                   return;
               }//if ends here

               first = second = Double.MAX_VALUE;
               for (int i = 0; i < arr_size; i++)
               {
            /* If current element is smaller than first
              then update both first and second */
                   if (quizArr[i] <= first)
                   {
                       second = first;
                       first = quizArr[i];
                   }//if ends here

            /* If arr[i] is in between first and second
               then update second  */
                   else if (quizArr[i] <= second && quizArr[i] != first)
                       second = quizArr[i];
               }//else if ends here

           String stringdouble= String.valueOf(first);
           String string2double= String.valueOf(second);
               if (second == Double.MAX_VALUE){
                   System.out.println("There is no second" +
                           "smallest element");
               }//if ends here

               else{

           }
        double quizSum = 0;
           //Using for loop to calculate the sum of quiz scores
        for (int i = 0; i < quizArr.length; i++) {
            quizSum = quizSum + quizArr[i];
        }//for loop ends here

           //Subtracting the two lowest quiz scores from the total
           sumTemp = quizSum - (first + second);

           //Calculating the quiz Percentage
            quizPercent = ((sumTemp * 100) / 100);

           //Using decimal format in order to limit the number of digits after decimal point
            DecimalFormat df = new DecimalFormat("0.00");
            //String convertQuizPercent = df.format(quizPercent);

           // Defining intent(quizToTestIntent) to go to the testActivity
           Intent quizToTestIntent = new Intent(quizActivity.this, testActivity.class);
           quizToTestIntent.putExtra("quizP", quizPercent);//Using putExtra method to send extra information along with the intent
           quizToTestIntent.putExtra("course", course);
           startActivity(quizToTestIntent);

        //finish();

        }//quizToTest

    //Using finish method to go back to the previous activity
    public void goBack( View v)
    {
        finish();
    }//goBack ends here

}//mainActivity
