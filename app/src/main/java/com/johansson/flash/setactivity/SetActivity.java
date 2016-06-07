package com.johansson.flash.setactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.johansson.flash.R;
import com.johansson.flash.data.card.Card;
import com.johansson.flash.setactivity.cardactivity.CardActivity;

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
        Bundle b = new Bundle();
        //TODO: Read values
        b.putBoolean(CardActivity.ARG_SHUFFLE, true);
        b.putBoolean(CardActivity.ARG_DROP_CARDS, false);
        b.putInt(CardActivity.ARG_SET_ID, 0);
        b.putInt(CardActivity.ARG_SIDE, CardActivity.FRONT);
        startActivity(intent);
    }
}
