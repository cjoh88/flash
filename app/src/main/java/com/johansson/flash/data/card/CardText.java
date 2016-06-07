package com.johansson.flash.data.card;

import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by chris on 2016-06-07.
 */
public class CardText implements CardSide {

    private String text;

    public CardText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void createView(RelativeLayout relativeLayout) {
        TextView txt = new TextView(relativeLayout.getContext());
        txt.setText(text);
        //RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) txt.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 72);
        txt.setLayoutParams(layoutParams);
        relativeLayout.addView(txt);
    }
}
