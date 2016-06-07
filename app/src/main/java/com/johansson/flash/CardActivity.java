package com.johansson.flash;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CardActivity extends AppCompatActivity {

    private final static String ARG_SHUFFLE = "shuffle";
    private final static String ARG_DROP_CARDS = "dropCards";
    private final static String ARG_SIDE = "side";

    public enum FirstSide {FRONT, BACK, RANDOM};

    private boolean shuffle = true;
    private boolean dropCards = false;
    private FirstSide side = FirstSide.FRONT;

    private ViewPager pager;
    private CardPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager = (ViewPager) findViewById(R.id.card_view_pager);
        //TODO: Manipulate card array (shuffle, reverse, etc)
        adapter = new CardPagerAdapter(getSupportFragmentManager(), TestData.cards);
        pager.setAdapter(adapter);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


}
