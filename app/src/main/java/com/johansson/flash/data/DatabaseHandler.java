package com.johansson.flash.data;

import com.johansson.flash.data.card.Card;
import com.johansson.flash.data.card.CardFactory;
import com.johansson.flash.data.set.Set;

import java.util.ArrayList;

/**
 * Created by chris on 2016-06-07.
 */
public class DatabaseHandler {

    private static ArrayList<Set> sets = createSets();
    private static ArrayList<ArrayList<Card>> cards = createCards();

    public ArrayList<Set> getAllSets() {
        return sets;
    }

    public ArrayList<Set> getFavoriteSets() {
        ArrayList<Set> s = new ArrayList<>();
        for(Set set : sets) {
            if(set.isFavorite()) {
                s.add(set);
            }
        }
        return s;
    }

    public Set getSet(int id) {
        return sets.get(id);
    }

    public int getSetCount() {
        return sets.size();
    }

    public void addSet(Set set) {
        Set s = new Set(sets.size(), set.getTitle(), set.getSubtitle(), set.isFavorite());
        sets.add(s);
    }

    public Card getCard(int id) {
        for(ArrayList<Card> set : cards) {
            for(Card c : set) {
                if(c.getId() == id) {
                    return c;
                }
            }
        }
        return null;
    }

    public ArrayList<Card> getCardsFromSet(int setId) {
        return cards.get(setId);
    }

    public ArrayList<Card> getAllCards() {
        ArrayList<Card> c = new ArrayList<>();
        for(ArrayList<Card> set : cards) {
            for (Card x : set) {
                c.add(x);
            }
        }
        return c;
    }

    public int getCardsCount() {
        int x = 0;
        for(ArrayList<Card> c : cards) {
            x += c.size();
        }
        return x;
    }

    public void addCard(int setId, Card c) {
        ArrayList<Card> s = cards.get(setId);
        s.add(new Card(getCardsCount(), c.getFront(), c.getBack()));
    }










    private static ArrayList<Set> createSets() {
        ArrayList<Set> sets = new ArrayList<>();
        sets.add(new Set(0, "English Animals", "Swedish to english animals", true));
        sets.add(new Set(1, "English Kitchen", "Swedish to english kitchen stuff", true));
        sets.add(new Set(2, "Math", "Some math cards", true));
        sets.add(new Set(3, "German Animals", "Swedish to german animals", false));
        return sets;
    }

    private static ArrayList<ArrayList<Card>> createCards() {
        ArrayList<ArrayList<Card>> cards = new ArrayList<>();
        cards.add(createCards0());
        cards.add(createCards1());
        cards.add(createCards2());
        cards.add(createCards3());
        return cards;
    }

    private static ArrayList<Card> createCards0() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(CardFactory.newTextText(0, "Mus", "Mouse"));
        cards.add(CardFactory.newTextText(1, "Råtta", "Rat"));
        cards.add(CardFactory.newTextText(2, "Katt", "Cat"));
        cards.add(CardFactory.newTextText(3, "Hund", "Dog"));
        cards.add(CardFactory.newTextText(4, "Häst", "Horse"));
        cards.add(CardFactory.newTextText(5, "Apa", "Monkey"));
        cards.add(CardFactory.newTextText(6, "Gris", "Pig"));
        cards.add(CardFactory.newTextText(7, "Ko", "Cow"));
        cards.add(CardFactory.newTextText(8, "Får", "Sheep"));
        cards.add(CardFactory.newTextText(9, "Kanin", "Rabbit"));
        cards.add(CardFactory.newTextText(10, "Ödla", "Lizard"));
        return cards;
    }
    private static ArrayList<Card> createCards1() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(CardFactory.newTextText(11, "Stol", "Chair"));
        cards.add(CardFactory.newTextText(12, "Bord", "Table"));
        cards.add(CardFactory.newTextText(13, "Matta", "Rug"));
        cards.add(CardFactory.newTextText(14, "Dator", "Computer"));
        cards.add(CardFactory.newTextText(15, "Kastrull", "Pot"));
        cards.add(CardFactory.newTextText(16, "Lampa", "Lamp"));
        cards.add(CardFactory.newTextText(17, "Glas", "Glass"));
        cards.add(CardFactory.newTextText(18, "Kniv", "Knife"));
        cards.add(CardFactory.newTextText(19, "Gaffel", "Fork"));
        cards.add(CardFactory.newTextText(20, "Tallrik", "Plate"));
        cards.add(CardFactory.newTextText(21, "Spis", "Stove"));
        return cards;
    }
    private static ArrayList<Card> createCards2() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(CardFactory.newTextText(22, "1+1", "2"));
        cards.add(CardFactory.newTextText(23, "1+2", "3"));
        cards.add(CardFactory.newTextText(24, "2+3", "5"));
        cards.add(CardFactory.newTextText(25, "5+2", "7"));
        cards.add(CardFactory.newTextText(26, "3-1", "2"));
        cards.add(CardFactory.newTextText(27, "7-6", "1"));
        cards.add(CardFactory.newTextText(28, "4+4", "8"));
        cards.add(CardFactory.newTextText(29, "3x3", "9"));
        cards.add(CardFactory.newTextText(30, "2+3-4", "1"));
        cards.add(CardFactory.newTextText(31, "6-2-2", "2"));
        cards.add(CardFactory.newTextText(32, "5*3-6", "9"));
        return cards;
    }
    private static ArrayList<Card> createCards3() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(CardFactory.newTextText(33, "Mus", "Maus"));
        cards.add(CardFactory.newTextText(34, "Råtta", "Ratte"));
        cards.add(CardFactory.newTextText(35, "Katt", "Katze"));
        cards.add(CardFactory.newTextText(36, "Hund", "Hund"));
        cards.add(CardFactory.newTextText(37, "Häst", "Pferd"));
        cards.add(CardFactory.newTextText(38, "Apa", "Apa"));
        cards.add(CardFactory.newTextText(39, "Gris", "Schweinefleisch"));
        cards.add(CardFactory.newTextText(40, "Ko", "Ko"));
        cards.add(CardFactory.newTextText(41, "Får", "Schaf"));
        cards.add(CardFactory.newTextText(42, "Kanin", "Kaninchen"));
        cards.add(CardFactory.newTextText(43, "Ödla", "Eidechse"));
        return cards;
    }
}
