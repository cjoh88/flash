package com.johansson.flash.mainlist;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-02.
 */
public class MainListFavorites implements MainListItem {

    private ArrayList<MainListSet> items;

    public MainListFavorites() {

    }

    public void addFavorite(MainListSet item) {
        items.add(item);
    }

    public void removeFavorite(MainListSet item) {
        items.remove(item);
    }

    @Override
    public int getItemType() {
        return MainListItem.SET_FAVORITES;
    }
}
