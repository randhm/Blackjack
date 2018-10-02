package com.markrandhawa.Blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BlackjackApplication {

    static Game game;

    public static void play_blackjack() {
        while (game.isInPlay) {
            game.play();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BlackjackApplication.class, args);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack.\nType Y to start, or N to quit.");
        String keyEntered = scanner.nextLine().trim();
        while (keyEntered.equalsIgnoreCase("Y")) {
            game = new Game();
            play_blackjack();
            System.out.println("\n\nDo you want to play another game of BlackJack? \nType Y to start, or N to quit.");
            keyEntered = scanner.nextLine().trim();
        }

    }
}