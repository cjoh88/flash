package com.johansson.flash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

public class SetActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_favorite_default_24dp));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                ((FloatingActionButton)view).setImageDrawable(ContextCompat.getDrawable(SetActivity.this,R.drawable.ic_favorite_default_24dp));
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Title");
        getSupportActionBar().setSubtitle("Subtitle");
        /*if(findViewById(R.id.fragmentSetPreferences) != null) {
            if(savedInstanceState != null) {
                return;
            }
            //StartFragment startFragment = new StartFragment();
            //getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, startFragment).commit();


            SetPreferenceFragment setPreferenceFragment = new SetPreferenceFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.fragmentSetPreferences, setPreferenceFragment).commit();

        }*/

    }

    public void buttonStart(View view) {
        Intent intent = new Intent(this, CardActivity.class);
        startActivity(intent);
    }
}
