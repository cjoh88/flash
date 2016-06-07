package com.johansson.flash;

import com.johansson.flash.data.card.Card;
import com.johansson.flash.data.card.CardSide;
import com.johansson.flash.data.card.CardText;
import com.johansson.flash.mainlist.MainListFavorites;
import com.johansson.flash.mainlist.MainListItem;
import com.johansson.flash.mainlist.MainListSeparator;
import com.johansson.flash.mainlist.MainListSet;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-06.
 */
public class TestData {

    public static MainListItem[] items = new MainListItem[] {
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
    };

    private static CardSide[] cardFronts = new CardSide[] {
            new CardText("Front 1"),
            new CardText("Front 2"),
            new CardText("Front 3"),
            new CardText("Front 4"),
            new CardText("Front 5"),
            new CardText("Front 6"),
            new CardText("Front 7"),
            new CardText("Front 8"),
            new CardText("Front 9")
    };

    private static CardSide[] cardBacks = new CardSide[] {
            new CardText("Back 1"),
            new CardText("Back 2"),
            new CardText("Back 3"),
            new CardText("Back 4"),
            new CardText("Back 5"),
            new CardText("Back 6"),
            new CardText("Back 7"),
            new CardText("Back 8"),
            new CardText("Back 9")
    };

    public static ArrayList<Card> cards = generateCards();


    private static ArrayList<Card> generateCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for(int i=0; i<cardFronts.length; i++) {
            cards.add(new Card(i, cardFronts[i], cardBacks[i]));
        }
        return cards;
    }
}
