package com.johansson.flash.setactivity.cardactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.johansson.flash.data.card.Card;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-06.
 */
public class CardPagerAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fm;
    private ArrayList<Card> cards;

    public CardPagerAdapter(FragmentManager fm, ArrayList<Card> cards) {
        super(fm);
        this.fm = fm;
        this.cards = cards;
    }

    @Override
    public Fragment getItem(int position) {
        //TODO: Create cards here in CardPagerAdapter
        CardFragment item = CardFragment.newInstance(position, false);    //TODO: replace boolean flipped argument with correct value
        return item;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        //TODO: Return number of cards in the set
        //return 0;
        return cards.size();
    }

}
