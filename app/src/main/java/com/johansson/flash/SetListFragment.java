package com.johansson.flash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
//import android.view.View;
import android.view.View;
import android.view.ViewGroup;

import com.johansson.flash.data.DatabaseHandler;

/**
 * Created by chris on 2016-06-02.
 */
public class SetListFragment extends Fragment {

    private RecyclerView recyclerView;
    private SetListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public SetListFragment() {}

    public static SetListFragment newInstance() {
        SetListFragment fragment = new SetListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_list, container, false);    //TODO correct layout
        createSetsList(rootView);
        createSetsList(rootView);
        return rootView;
    }

    private void createSetsList(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.listSet);
        recyclerView.setHasFixedSize(true); //TODO Does this recycler view has a fixed size?
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);
        /*MainListItem[] items = new MainListItem[] {
                new MainListSeparator("Favorites"),
                new MainListFavorites(),
                new MainListSeparator("Recently used"),
                new MainListSeparator("All"),
                new MainListSet("Exam 1", "Linear Algebra II", true),
                new MainListSet("Exam 2", "Linear Algebra II", true),
                new MainListSet("Exam 1", "Linear Algebra I", false),
                new MainListSet("Homework 1", "Linear Algebra I", false),
                new MainListSet("Homework 2", "Linear Algebra I", true),
                new MainListSet("Homework 3", "Linear Algebra I", false),
                new MainListSet("Exam 2", "Calculus", false),
                new MainListSet("Exercise 1", "Advanced Computer Architecture", false),
                new MainListSet("Exercise 2", "Advanced Computer Architecture", false),
                new MainListSet("Exercise 3", "Advanced Computer Architecture", false),
                new MainListSet("Exercise 4", "Advanced Computer Architecture", false)
        };*/
        DatabaseHandler db = new DatabaseHandler();
        adapter = new SetListAdapter(db.getAllSets());
        adapter.setSetListClickListener(new SetListClickListener(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
