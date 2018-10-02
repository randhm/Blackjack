package com.markrandhawa.Blackjack;

import java.util.ArrayList;

public class Hand extends Deck {
    private ArrayList<Card> cards; //Introducing concept of a hand as a list (Deck) of cards
    private int score = 0;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void hit() {
        addCard(dealCard());
    }

    private void addCard(Card card) {
        this.cards.add(card); // adding a card to the arraylist
    }

    private int getCardValue(Card card) {
        return Integer.parseInt(values.get(card.getRank())); // Get the value of card using rank as the key
    }

    public int totalSum() {
        score = 0;
        for (Card card : this.cards) {
            score = score + getCardValue(card);
        }
        return score;
    }

    public void printHands() {
        for (Card card : this.cards) {
            System.out.println(card.getRank() + " of " + card.getSuit() + " = " + values.get(card.getRank()));
        }
        System.out.println("Total: " + totalSum());
    }
}
