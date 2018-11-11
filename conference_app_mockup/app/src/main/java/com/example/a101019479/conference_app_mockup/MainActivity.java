package com.example.a101019479.conference_app_mockup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("TEST","onCreate");

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvForgotPassword);
        Login = (Button)findViewById(R.id.btnLogin);


        //Login button calls validate() to validate login credentials
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });


    }



    private void validate(String userEmail, String userPassword){
        boolean condition = true;
        if(condition){
            Intent intent = new Intent(MainActivity.this, LoginSuccess.class);
            startActivity(intent);
        }
    }
}
