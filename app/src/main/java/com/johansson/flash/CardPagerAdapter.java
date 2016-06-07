package com.johansson.flash;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.johansson.flash.cardadapter.Card;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-06.
 */
public class CardPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Card> cards;
    private FragmentManager fm;

    public CardPagerAdapter(FragmentManager fm, ArrayList<Card> cards) {
        super(fm);
        this.fm = fm;
        this.cards = cards;
    }

    @Override
    public Fragment getItem(int position) {
        CardFragment item;
        //if(showFront) {
            item = CardFragment.newInstance(position);
        //}
        //else {
            //item = CardFragment.newInstance(getCount()-position-1);
        //}
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
