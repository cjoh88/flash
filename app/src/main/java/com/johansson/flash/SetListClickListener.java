package com.johansson.flash;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.johansson.flash.setactivity.SetActivity;

/**
 * Created by chris on 2016-06-03.
 */
public class SetListClickListener implements View.OnClickListener {

    private Context context;

    public SetListClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, SetActivity.class);
        context.startActivity(intent);
    }
}
