package com.example.a101019479.conference_app_mockup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;


public class LoginSuccess extends AppCompatActivity {
    private Button allSchedule;
    private Button mySchedule;
    private Button speakers;
    private Button attendees;
    private Button locations;
    private Button sponsors;
    private Button twitter;
    private Button logOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        allSchedule = (Button)findViewById(R.id.btnAllSchedule);
        mySchedule = (Button)findViewById(R.id.btnMySchedule);
        speakers = (Button)findViewById(R.id.btnSpeakers);
        attendees = (Button)findViewById(R.id.btnAttendees);
        locations = (Button)findViewById(R.id.btnLocations);
        sponsors = (Button)findViewById(R.id.btnSponsors);
        twitter = (Button)findViewById(R.id.btnTwitter);
        logOut = (Button)findViewById(R.id.btnLogOut);

        toLogOut();
        toAllSchedule();
        toMySchedule();
        toSpeakers();
        toAttendees();
        toLocations();
        toSponsors();
        toTwitter();

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
                Intent intent = new Intent(view.getContext(), AllSchedule.class);
                startActivity(intent);
            }
        });
    }
    private void toMySchedule(){
        mySchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MySchedule.class);
                startActivity(intent);
            }
        });
    }
    private void toSpeakers(){
        speakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Speakers.class);
                startActivity(intent);
            }
        });
    }
    private void toAttendees(){
        attendees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Attendees.class);
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
    private void toSponsors(){
        sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Sponsors.class);
                startActivity(intent);
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
}
