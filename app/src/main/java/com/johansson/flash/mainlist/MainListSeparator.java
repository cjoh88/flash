package com.johansson.flash.mainlist;


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
        return SET_SEPARATOR;
    }
}
