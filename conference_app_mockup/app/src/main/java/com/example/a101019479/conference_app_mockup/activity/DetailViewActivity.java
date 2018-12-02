package com.example.a101019479.conference_app_mockup.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a101019479.conference_app_mockup.R;
import com.example.a101019479.conference_app_mockup.dao.PresenterDao;
import com.example.a101019479.conference_app_mockup.dao.impl.PresenterSQLiteDao;
import com.example.a101019479.conference_app_mockup.model.Presenter;

import java.util.ArrayList;
import java.util.List;

public class DetailViewActivity extends AppMenuCompatActivity {

    private TextView tvName;
    private TextView tvAffiliation;
    private TextView tvEmail;
    private TextView tvBio;
    private PresenterDao presenterDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        tvName = (TextView)findViewById(R.id.tvName);
        tvAffiliation = (TextView)findViewById(R.id.tvAffiliation);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvBio = (TextView)findViewById(R.id.tvBio);

        //Get selected presenter
        SharedPreferences mySettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        String fullName = mySettings.getString("presenterSelected", "");
        tvName.setText(fullName);

        //Get first and last name
        String firstName = fullName.split(" ")[0];
        String lastName = fullName.split(" ")[1];

        //Find Presenter, display presenter details
        presenterDao = new PresenterSQLiteDao(this);
        List<Presenter> presenterList = presenterDao.getAllPresenters();
        for(Presenter presenter: presenterList){
            if (presenter.getFirstName().equals(firstName)|| presenter.getLastName().equals(lastName)){
                tvAffiliation.setText("AFFILIATION: " + presenter.getAffiliation());
                tvEmail.setText("EMAIL: " + presenter.getEmail());
                tvBio.setText("BIO: " + presenter.getBio());
            }
        }


    }
}
