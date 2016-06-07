package com.johansson.flash.data.card;

/**
 * Created by chris on 2016-06-07.
 */
public class CardFactory {

    public static Card newTextText(int id, String front, String back) {
        CardText f = new CardText(front);
        CardText b = new CardText(back);
        return new Card(id, f, b);
    }
}
