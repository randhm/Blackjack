package com.markrandhawa.Blackjack;

import java.util.Scanner;

public class Game {
    private Hand player_hand;
    private Hand dealer_hand;
    public static Boolean isInPlay;

    public Game() {
        player_hand = new Hand();
        dealer_hand = new Hand();
        start();
    }

    public void start() {
        isInPlay = true;
        player_hand.hit();
        player_hand.hit();
        System.out.println("Player hand: ");
        player_hand.printHands();
        hasPlayerWonOrLost();
        dealer_hand.hit();
        dealer_hand.hit();
    }

    public int getTotalSum() {
        return player_hand.totalSum();
    }

    public boolean hasPlayerWonOrLost() {
        if (player_hand.totalSum() == 21) {
            System.out.println("Player wins");
            isInPlay = false;
            return true;
        } else if (player_hand.totalSum() > 21) {
            System.out.println("Bust. Player loses");
            isInPlay = false;
            return true;
        }
        isInPlay = true;
        return false;
    }

    public boolean isDealerBust() {
        if (dealer_hand.totalSum() > 21) {
            System.out.println("Dealer busted. Player wins");
            isInPlay = false;
            return true;
        }
        isInPlay = true;
        return false;
    }


    public void hit() {
        player_hand.hit();
        player_hand.printHands();
        hasPlayerWonOrLost();
    }

    public boolean hold() {
        System.out.println("\nPlayer hold");
        while (dealer_hand.totalSum() < 15 && dealer_hand.totalSum() < player_hand.totalSum()) {
            dealer_hand.hit();
        }
        System.out.println("\nDealer hand:");
        dealer_hand.printHands();
        if (isDealerBust()) {
            return isInPlay = false;
        } else if (dealer_hand.totalSum() < player_hand.totalSum()) {
            System.out.println("\nPlayer wins");
        } else if (dealer_hand.totalSum() == player_hand.totalSum()) {
            System.out.println("\nDraw");
        } else {
            System.out.println("\nDealer wins");
        }

        return isInPlay = false;
    }

    public void play() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (isInPlay) {
            System.out.println("\nDo you want to hit or hold?\nEnter:\n1. Hit\n2. Hold");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hit();
                    break;

                case 2:
                    hold();
                    break;
            }
        }
    }
}