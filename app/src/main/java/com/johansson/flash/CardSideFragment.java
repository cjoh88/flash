package com.johansson.flash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import junit.framework.Test;

public class CardSideFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CARD_ID = "cardId";
    private static final String ARG_CARD_FRONT = "cardFront";

    // TODO: Rename and change types of parameters
    private int cardId = 0;
    private boolean cardFront = true;


    public CardSideFragment() {
        // Required empty public constructor
    }


    public static CardSideFragment newInstance(int cardId, boolean cardFront) {
        CardSideFragment fragment = new CardSideFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CARD_ID, cardId);
        args.putBoolean(ARG_CARD_FRONT, cardFront);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cardId = getArguments().getInt(ARG_CARD_ID);
            cardFront = getArguments().getBoolean(ARG_CARD_FRONT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card_side, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.card_side);
        if(cardFront) {
            //TestData.cardFronts[cardId].createView(relativeLayout);
        }
        else {
            //TestData.cardBacks[cardId].createView(relativeLayout);
        }
        return rootView;
    }

}
