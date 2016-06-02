package com.johansson.flash.list;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.johansson.flash.FavoriteClickListener;
import com.johansson.flash.R;

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
        return MainListItem.SET_ITEM;
    }
}