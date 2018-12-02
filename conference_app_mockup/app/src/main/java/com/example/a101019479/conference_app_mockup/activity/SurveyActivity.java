package com.example.a101019479.conference_app_mockup.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a101019479.conference_app_mockup.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;


public class SurveyActivity extends AppMenuCompatActivity {

    private TextView greetings;
    private EditText q1Answer;
    private EditText q2Answer;
    private EditText q3Answer;
    private Button submit;
    public static final String FILE_NAME = "survey.txt";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        //Greet User
        greetings = (TextView)findViewById(R.id.tvGreetings);
        SharedPreferences mySettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        CharSequence greetingMessage = "Hello " + mySettings.getString("firstName", "") + "!" +
                "\n Please complete the following survey:";
        greetings.setText(greetingMessage);


        submit = (Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get UserAnswers
                q1Answer = (EditText) findViewById(R.id.etQuestion1);
                q2Answer = (EditText) findViewById(R.id.etQuestion2);
                q3Answer = (EditText) findViewById(R.id.etQuestion3);
                String q1 = q1Answer.getText().toString();
                String q2 = q2Answer.getText().toString();
                String q3 = q3Answer.getText().toString();


                //Get TimeStamp
                Date date = new Date();
                long time = date.getTime();
                Timestamp timestamp = new Timestamp(time);


                //Combine timestamp and string
                String surveyResult = "\n"+ timestamp + "\t[" + q1 + "][" + q2 + "][" +  q3 + "]" ;


                //Write to survey.txt
                FileOutputStream fileOutputStream = null;
                File file = new File(FILE_NAME);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;



                try {
                    fileOutputStream = openFileOutput(FILE_NAME, MODE_APPEND);
                    fileOutputStream.write(surveyResult.getBytes());
                    Toast toast = Toast.makeText(context, "SurveyActivity results saved", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast exception = Toast.makeText(context, "Exception: " + e.getMessage(), Toast.LENGTH_SHORT);
                    exception.show();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent(SurveyActivity.this, LoginSuccess.class);
                startActivity(intent);

            }
        });
    }





}
