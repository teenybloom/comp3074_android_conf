package com.example.a101019479.conference_app_mockup.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.a101019479.conference_app_mockup.R;
import com.example.a101019479.conference_app_mockup.dao.PresenterDao;
import com.example.a101019479.conference_app_mockup.dao.impl.PresenterSQLiteDao;
import com.example.a101019479.conference_app_mockup.dao.impl.PresenterSQLiteOpenHelper;
import com.example.a101019479.conference_app_mockup.model.Presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PresentersActivity extends AppMenuCompatActivity {

    private PresenterDao presenterDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenters);
        presenterDao = new PresenterSQLiteDao(this);
        populateDummyData();


        List<Presenter> presenterList = presenterDao.getAllPresenters();
        List<String> presenterNames = new ArrayList<>();
        for(Presenter presenter: presenterList){
            presenterNames.add(presenter.getFirstName() + " " + presenter.getLastName());
        }

        Collections.sort(presenterNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, presenterNames);
        ListView listView = (ListView) findViewById(R.id.lvPresenters);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectionItem = (String)parent.getItemAtPosition(position);

                //Add to Preferences
                SharedPreferences mySettings = getSharedPreferences("Settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySettings.edit();
                editor.putString("presenterSelected", selectionItem);
                editor.apply();

                Intent intent = new Intent(view.getContext(), DetailViewActivity.class);
                startActivity(intent);


            }
        });

    }

    private void populateDummyData() {
        List<Presenter> presenters = presenterDao.getAllPresenters();
        if (presenters.isEmpty()) {
            presenterDao.addPresenter(new Presenter(
                    "Hilther",
                    "Gothham",
                    "George Brown University",
                    "h.gotham@gbu.com",
                    "I am a University student seeking new forms of presenting."));
            presenterDao.addPresenter(new Presenter(
                    "Kat",
                    "Meow",
                    "Soft Fluff Inc.",
                    "k.meow@softfluff.com",
                    "Interested in cats, I present stats and research regarding feline creatures."));
            presenterDao.addPresenter(new Presenter(
                    "Zis",
                    "Zat",
                    "This and That Co.",
                    "zis.zat@thisandthat.com",
                    "I do presentations on any topic possible. I find the world to be a facinating place"));
            presenterDao.addPresenter( new Presenter(
                    "Bunny",
                    "Puff",
                    "Big Armour Brand",
                    "bunny@bigarmourbrand.com",
                    "I am strong, and the messages my presentations are stronger"));
            presenterDao. addPresenter(new Presenter(
                    "Mash",
                    "Dyle",
                    "George Brown University",
                    "mdyle.thebeast@gbu.com",
                    "I rap my presentations, brings audience to d'destinations"));
        }
    }
}
