package com.johansson.flash.mainlist;

import com.johansson.flash.data.set.Set;

/**
 * Created by chris on 2016-06-01.
 */
public class MainListSet implements MainListItem{

    //private String title;
    //private String subtitle;
    //private boolean favorite;

    /*public MainListSet(String title, String subtitle, boolean favorite) {
        this.title = title;
        this.subtitle = subtitle;
        this.favorite = favorite;
    }*/

    private Set set;

    public MainListSet(Set set) {
        this.set = set;
    }

    public String getTitle() {
        return set.getTitle();
    }

    public String getSubtitle() {
        return set.getSubtitle();
    }

    public boolean isFavorite() {
        return set.isFavorite();
    }

    public void toggleFavorite() {
        set.toggleFavorite();
    }

    @Override
    public int getItemType() {
        return SET_ITEM;
    }
}
