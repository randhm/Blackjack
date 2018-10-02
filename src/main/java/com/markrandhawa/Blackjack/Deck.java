package com.markrandhawa.Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Deck {
    private String[] suits = {"SPADES", "DIAMONDS", "HEARTS", "CLUBS"};
    private int deckSize;
    private Card card;
    private ArrayList<Card> deck;
    protected HashMap<String, String> values = new HashMap<String, String>();
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private String[] value = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "10", "10", "10", "11"};

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        setValues();
        Card card;
        this.deck = new ArrayList<Card>();
        for (String suit : suits) {
            for (String rank : ranks) {
                card = new Card(suit, rank);
                this.deck.add(card);
            }
        }
        Collections.shuffle(this.deck);
    }

    /**
     * Loop through and add the key/value pairs for each element in the ranks and value arrays to the hashmap
     */
    private void setValues() {
        for (int i = 0; i < ranks.length; i++) {
            values.put(ranks[i], value[i]);
        }
    }

    public Card dealCard() { // need to remove cards from the deck once they've been used
        deckSize = this.deck.size() - 1;
        card = this.deck.get(deckSize);
        this.deck.remove(deckSize);
        return card;
    }
}
