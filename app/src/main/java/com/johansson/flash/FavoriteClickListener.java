package com.johansson.flash;


import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.johansson.flash.list.MainListSet;

/**
 * Created by chris on 2016-06-01.
 */
public class FavoriteClickListener implements View.OnClickListener {

    private MainListSet item;

    public FavoriteClickListener(MainListSet item) {
        this.item = item;
    }

    @Override
    public void onClick(View v) {
        item.toggleFavorite();
        ImageView favorite = (ImageView) v;
        if(item.isFavorite()) {
            favorite.setImageResource(R.drawable.ic_favorite_default_24dp);
            Toast.makeText(v.getContext(), "Adding " + item.getTitle() + " to favorites...", Toast.LENGTH_SHORT).show();
        }
        else {
            favorite.setImageResource(R.drawable.ic_favorite_border_default_24dp);
            Toast.makeText(v.getContext(), "Removing " + item.getTitle() + " from favorites...", Toast.LENGTH_SHORT).show();
        }
    }
}

