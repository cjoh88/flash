package com.johansson.flash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.johansson.flash.setlist.MainListItem;
import com.johansson.flash.setlist.MainListSeparator;
import com.johansson.flash.setlist.MainListSet;


public class StartFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;

    public StartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StartFragment newInstance(String param1, String param2) {
        StartFragment fragment = new StartFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);
        createMainList(rootView);
        return rootView;
    }

    private void createMainList(View rootView) {
        MainListItem[] items = new MainListItem[] {
                new MainListSeparator("Favorites"),
                new MainListSeparator("All"),
                new MainListSet("Exam 1", "Linear Algebra II", true),
                new MainListSet("Exam 2", "Linear Algebra II", true),
                new MainListSet("Exam 1", "Linear Algebra I", false),
                new MainListSet("Homework 1", "Linear Algebra I", false),
                new MainListSet("Homework 2", "Linear Algebra I", false),
                new MainListSet("Homework 3", "Linear Algebra I", false),
                new MainListSet("Exam 2", "Calculus", false),
                new MainListSet("Exercise 1", "Advanced Computer Architecture", false),
                new MainListSet("Exercise 2", "Advanced Computer Architecture", false),
                new MainListSet("Exercise 3", "Advanced Computer Architecture", false),
                new MainListSet("Exercise 4", "Advanced Computer Architecture", false)
        };
        //MainArrayAdapter2 adapter = new MainArrayAdapter2(this., R.layout.list_item_main, items);
        //MainArrayAdapter adapter = new MainArrayAdapter(getContext(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.listMain);
        //listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "Pos: " + position, Toast.LENGTH_SHORT);
                System.out.println("Hello");
            }
        });
    }
/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
