package com.example.a101019479.conference_app_mockup.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.a101019479.conference_app_mockup.R;
import com.example.a101019479.conference_app_mockup.dao.PresenterDao;
import com.example.a101019479.conference_app_mockup.dao.impl.PresenterSQLiteDao;
import com.example.a101019479.conference_app_mockup.model.Presenter;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private TextView greetings;
    private TextView bigText;
    private EditText firstName;
    private TextView info;
    private Button enter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("TEST","onCreate");

        bigText = (TextView)findViewById(R.id.textView);
        firstName = (EditText)findViewById(R.id.etFirstName);
        info = (TextView)findViewById(R.id.tvInfo);
        enter = (Button)findViewById(R.id.btnEnter);


        //Greet User
        SharedPreferences mySettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        CharSequence greetingMessage = "Welcome " + mySettings.getString("firstName", "") + "!";
        bigText.setText(greetingMessage);


        //Login button calls validate() to validate login credentials
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(firstName.getText().toString());
            }
        });


    }



    private void validate(String firstName){
        boolean condition = firstName.matches("");
        if(condition){
            info.setText("Field for First Name cannot be empty!");
        } else {
            //Add to Preferences
            SharedPreferences mySettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mySettings.edit();
            editor.putString("firstName", firstName);
            editor.apply();

            //Toast welcome message
            Context context = getApplicationContext();
            CharSequence text = "Welcome " + mySettings.getString("firstName", "") + "!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            //Change bigText to greet user firstName
            bigText.setText(text);

            //Start new activity
            Intent intent = new Intent(RegisterActivity.this, LoginSuccess.class);
            startActivity(intent);

        }
    }

}
