package com.johansson.flash.list;


import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by chris on 2016-06-02.
 */
public interface MainListItem {

    int SET_ITEM = 0;
    int SET_SEPARATOR = 1;
    int SET_FAVORITES = 2;

    int getItemType();
}
