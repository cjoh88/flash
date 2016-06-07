package com.johansson.flash.mainlist;

/**
 * Created by chris on 2016-06-01.
 */
public class MainListSet implements MainListItem{

    private String title;
    private String subtitle;
    private boolean favorite;

    public MainListSet(String title, String subtitle, boolean favorite) {
        this.title = title;
        this.subtitle = subtitle;
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void toggleFavorite() {
        favorite = !favorite;
    }

    @Override
    public int getItemType() {
        return SET_ITEM;
    }
}
