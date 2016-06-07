package com.johansson.flash;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ListView;

/**
 * Created by chris on 2016-06-04.
 */
public class SetPreferenceFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.set_preference);

        addPreferences();
    }

    //TODO: Make sure these preferences are deleted when the set is deleted
    private void addPreferences() {
        /*PreferenceScreen screen = getPreferenceScreen();

        PreferenceCategory cat = new PreferenceCategory(getActivity());
        cat.setTitle("Notifications");

        screen.addPreference(cat);

        CheckBoxPreference checkBoxPref = new CheckBoxPreference(getActivity());
        checkBoxPref.setTitle("title");
        checkBoxPref.setSummary("summary");
        checkBoxPref.setChecked(true);
        checkBoxPref.setKey("aaa");
        cat.addPreference(checkBoxPref);

        setPreferenceScreen(screen);*/
    }

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {

    }



}
