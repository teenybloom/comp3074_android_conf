package com.example.a101019479.conference_app_mockup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;


public class AppMenuCompatActivity extends AppCompatActivity {

    private final Uri TWITTER_URI;
    private final Uri GEO_URI;

    public AppMenuCompatActivity() {
        TWITTER_URI = Uri.parse("https://twitter.com/GBCollege?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor");
        GEO_URI = Uri.parse("geo:0,0?q=george+brown+campus");
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAllSchedule:
                startActivity(new Intent(this, AllSchedule.class));
                return true;
            case R.id.mMySchedule:
                startActivity(new Intent(this, MySchedule.class));
                return true;
            case R.id.mSpeakers:
                startActivity(new Intent(this, Speakers.class));
                return true;
            case R.id.mAttendees:
                startActivity(new Intent(this, Attendees.class));
                return true;
            case R.id.mLocations:
                startActivity(new Intent(Intent.ACTION_VIEW, GEO_URI));
                return true;
            case R.id.mSponsors:
                startActivity(new Intent(this, Sponsors.class));
                return true;
            case R.id.mTwitter:
                startActivity(new Intent(Intent.ACTION_VIEW, TWITTER_URI));
                return true;
            case R.id.mLogOut:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                super.onOptionsItemSelected(item);

        }
        return false;
    }
}




