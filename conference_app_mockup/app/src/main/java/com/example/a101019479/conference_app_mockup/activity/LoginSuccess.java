package com.example.a101019479.conference_app_mockup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

import com.example.a101019479.conference_app_mockup.R;


public class LoginSuccess extends AppMenuCompatActivity {
    private Button allSchedule;
    private Button speakers;
    private Button locations;
    private Button twitter;
    private Button logOut;
    private Button sensor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        allSchedule = (Button)findViewById(R.id.btnSurvey);
        speakers = (Button)findViewById(R.id.btnSpeakers);
        locations = (Button)findViewById(R.id.btnLocations);
        twitter = (Button)findViewById(R.id.btnTwitter);
        logOut = (Button)findViewById(R.id.btnLogOut);
        sensor = (Button)findViewById(R.id.btnSensor);


        toLogOut();
        toAllSchedule();
        toSpeakers();
        toLocations();
        toTwitter();
        toSensor();


    }

    private void toLogOut(){
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void toAllSchedule(){
        allSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SurveyActivity.class);
                startActivity(intent);
            }
        });
    }
    private void toSpeakers(){
        speakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PresentersActivity.class);
                startActivity(intent);
            }
        });
    }
    private void toLocations(){
        locations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=george+brown+campus"));
                startActivity(webIntent);
            }
        });

    }
    private void toTwitter(){
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/GBCollege?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"));
                startActivity(webIntent);
            }
        });

    }
    private void toSensor(){
        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent webIntent = new Intent(view.getContext(), SensorActivity.class);
                startActivity(webIntent);
            }
        });

    }
}
