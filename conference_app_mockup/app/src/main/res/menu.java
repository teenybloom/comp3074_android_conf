package com.example.a101019479.conference_app_mockup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.a101019479.conference_app_mockup.activity.PresentersActivity;
import com.example.a101019479.conference_app_mockup.activity.RegisterActivity;
import com.example.a101019479.conference_app_mockup.activity.SurveyActivity;

public class menu extends AppCompatActivity {


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
                startActivity(new Intent(this, SurveyActivity.class));
                return true;
            case R.id.mMySchedule:
                startActivity(new Intent(this, MySchedule.class));
                return true;
            case R.id.mSpeakers:
                startActivity(new Intent(this, PresentersActivity.class));
                return true;
            case R.id.mAttendees:
                startActivity(new Intent(this, Attendees.class));
                return true;
            case R.id.mLocations:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=george+brown+campus")));
                return true;
            case R.id.mSponsors:
                startActivity(new Intent(this, Sponsors.class));
                return true;
            case R.id.mTwitter:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/GBCollege?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor")));
                return true;
            case R.id.mLogOut:
                startActivity(new Intent(this, RegisterActivity.class));
                return true;
            default:
                super.onOptionsItemSelected(item);

        }
        return false;
    }
}




