package com.johansson.flash.data.card;

/**
 * Created by chris on 2016-06-07.
 */
public class Card {

    private int id;
    private CardSide front;
    private CardSide back;

    public Card(int id, CardSide front, CardSide back) {
        this.id = id;
        this.front = front;
        this.back = back;
    }

    public CardSide getFront() {
        return front;
    }

    public CardSide getBack() {
        return back;
    }

    public void reverse() {
        CardSide temp = front;
        front = back;
        back = temp;
    }
    public int getId() {
        return id;
    }
}
