package com.johansson.flash.list;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.johansson.flash.R;



/**
 * Created by chris on 2016-06-02.
 */
public class MainListSeparator implements MainListItem {

    private String text;

    public MainListSeparator(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }

    @Override
    public int getItemType() {
        return MainListItem.SET_SEPARATOR;
    }
}
