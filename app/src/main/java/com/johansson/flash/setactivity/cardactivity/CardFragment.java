package com.johansson.flash.setactivity.cardactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.johansson.flash.FlipAnimation;
import com.johansson.flash.R;
import com.johansson.flash.TestData;
import com.johansson.flash.data.DatabaseHandler;
import com.johansson.flash.data.card.Card;


public class CardFragment extends Fragment {

    private static final String ARG_ID = "cardId";
    private static final String ARG_FLIPPED = "flipped";

    private int card_id = 0;
    private boolean flipped = true;

    private RelativeLayout front;
    private RelativeLayout back;

    public CardFragment() {
        // Required empty public constructor
    }


    public static CardFragment newInstance(int card, boolean front) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, card);
        args.putBoolean(ARG_FLIPPED, front);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card_id = getArguments().getInt(ARG_ID);
            flipped = getArguments().getBoolean(ARG_FLIPPED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_card, container, false);
        front = (RelativeLayout) rootView.findViewById(R.id.card_front);
        back = (RelativeLayout) rootView.findViewById(R.id.card_back);
        DatabaseHandler db = new DatabaseHandler();
        Card card = db.getCard(card_id);
        if(flipped) {
            card.reverse();
        }
        card.getFront().createView(front);
        card.getBack().createView(back);
        //TestData.cards.get(card_id).getFront().createView(front);
        //TestData.cards.get(card_id).getBack().createView(back);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardFragment.this.buttonFlip(v);
            }
        });
        //if(savedInstanceState == null) {
        //    getChildFragmentManager().beginTransaction().add(R.id.card_side_container, CardSideFragment.newInstance(card_id, true)).commit();
        //}
        return rootView;
    }

    public void buttonFlip(View v) {
        /*if(show_front) {
            front.setVisibility(View.INVISIBLE);
            back.setVisibility(View.VISIBLE);
        }
        else {
            front.setVisibility(View.VISIBLE);
            back.setVisibility(View.INVISIBLE);
        }
        show_front = !show_front;*/
        FlipAnimation flipAnimation = new FlipAnimation(front, back);
        if(front.getVisibility() == View.GONE) {
            flipAnimation.reverse();
        }
        v.startAnimation(flipAnimation);
    }
}
