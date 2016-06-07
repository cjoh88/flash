package com.johansson.flash;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class CardFragment extends Fragment {

    private static final String ARG_ID = "cardId";

    private int card_id = 0;

    private RelativeLayout front;
    private RelativeLayout back;

    public CardFragment() {
        // Required empty public constructor
    }


    public static CardFragment newInstance(int card) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, card);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            card_id = getArguments().getInt(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_card, container, false);
        front = (RelativeLayout) rootView.findViewById(R.id.card_front);
        back = (RelativeLayout) rootView.findViewById(R.id.card_back);
        TestData.cards.get(card_id).getFront().createView(front);
        TestData.cards.get(card_id).getBack().createView(back);
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
