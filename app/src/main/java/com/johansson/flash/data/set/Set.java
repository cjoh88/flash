package com.johansson.flash.data.set;

/**
 * Created by chris on 2016-06-07.
 */
public class Set {

    public static final int NO_ID = -1;

    private int id;
    private String title;
    private String subtitle;
    private boolean favorite;


    public Set(int id, String title, String subtitle, boolean favorite) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.favorite = favorite;
    }

    public Set(String title, String subtitle, boolean favorite) {
        this(NO_ID, title, subtitle, favorite);
    }

    public int getId() {
        return id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void toggleFavorite() {
        favorite = !favorite;
    }


}
