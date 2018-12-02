package com.example.a101019479.conference_app_mockup.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.a101019479.conference_app_mockup.R;


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
            case R.id.mSurvey:
                startActivity(new Intent(this, SurveyActivity.class));
                return true;
            case R.id.mSpeakers:
                startActivity(new Intent(this, PresentersActivity.class));
                return true;
            case R.id.mLocations:
                startActivity(new Intent(Intent.ACTION_VIEW, GEO_URI));
                return true;
            case R.id.mTwitter:
                startActivity(new Intent(Intent.ACTION_VIEW, TWITTER_URI));
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




