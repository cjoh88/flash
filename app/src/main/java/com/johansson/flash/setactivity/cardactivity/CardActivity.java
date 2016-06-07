package com.johansson.flash.setactivity.cardactivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.johansson.flash.R;
import com.johansson.flash.TestData;
import com.johansson.flash.data.DatabaseHandler;
import com.johansson.flash.data.card.Card;

import java.util.ArrayList;

public class CardActivity extends AppCompatActivity {

    public final static String ARG_SHUFFLE = "shuffle";
    public final static String ARG_DROP_CARDS = "dropCards";
    public final static String ARG_SIDE = "side";
    public final static String ARG_SET_ID = "setId";

    public final static int FRONT = 0;
    public final static int BACK = 1;
    public final static int RANDOM = 2;

    private boolean shuffle = true;
    private boolean dropCards = false;
    private int side = FRONT;
    private int setId = 0;

    private ViewPager pager;
    private CardPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            setId = bundle.getInt(ARG_SET_ID);
            shuffle = bundle.getBoolean(ARG_SHUFFLE);
            dropCards = bundle.getBoolean(ARG_DROP_CARDS);
            side = bundle.getInt(ARG_SIDE);
        }

        //TODO: Manipulate card array (shuffle, reverse, etc)
        DatabaseHandler db = new DatabaseHandler();
        ArrayList<Card> cards = db.getCardsFromSet(setId);

        pager = (ViewPager) findViewById(R.id.card_view_pager);
        adapter = new CardPagerAdapter(getSupportFragmentManager(), cards);
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
