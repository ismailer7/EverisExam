package com.fpl.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fpl.entity.Player;
import com.fpl.utility.Loader;

public class BattleTextGame {

	static Scanner scanner = new Scanner(System.in);
	static final int MAX_SCORE = 20;
	static List<String> englishDic = new Loader().getEnglishDic();
	static Player player1, player2;

	static {
		englishDic = new Loader().getEnglishDic();

		player1 = new Player("ismail");

		player2 = new Player("muhssine");
	}

	public static void run() {
		System.out.println("\t\t\t\t**********Game Rules**********\n\n" + "\t\t1- the word should be in english.\n"
				+ "\t\t2- the word should not be used twice in the game.\n"
				+ "\t\t3- the word should start with the first character in the last used word except for the first time.\n"
				+ "\t\t4- player wins when he catch the max score or more.\n");

		System.out.println("\t\t\t\t**********Game Started!!!!**********\n\n");

		List<String> lastUsedWords = new ArrayList<>();

		while (true) {
			System.out.println("PLayer 1 (" + player1.getName() + ") Turn");
			System.out.println("-------------------------");
			System.out.println("Enter an english word : ");
			String player1Word = scanner.next();

			if (!lastUsedWords.isEmpty()) {
				// this is when game already started (there is some used words)
				String lastUsedWord = lastUsedWords.get(lastUsedWords.size() - 1);
				char lastCharacter = lastUsedWord.charAt(lastUsedWord.length() - 1);
				if (englishDic.contains(player1Word) && !lastUsedWords.contains(player1Word)
						&& player1Word.charAt(0) == lastCharacter) {
					lastUsedWords.add(player1Word);
					player1.setScore(player1.getScore() + player1Word.length());
					if (player1.getScore() >= MAX_SCORE) {
						System.out.println("-------------------------");
						System.out.println("\t\t\t\t-Player 1 (" + player1.getName() + ") win!-");
						break;
					}

				} else {
					System.out.println("Incorrect Rules! (Check out the rules)");
				}

			} else {

				// Game started now in this block (we don't have any used words yet)

				if (englishDic.contains(player1Word)) {
					lastUsedWords.add(player1Word);
					player1.setScore(player1.getScore() + player1Word.length());
					if (player1.getScore() >= MAX_SCORE) {
						System.out.println("-------------------------");
						System.out.println("\t\t\t\tPlayer 1 (" + player1.getName() + ") win!");
						break;
					}

				} else {
					System.out.println("Incorrect Rules! (Check out the rules)");
				}

			}

			System.out.println("PLayer 2 (" + player2.getName() + ") Turn");
			System.out.println("-------------------------");
			System.out.println("Enter an english word : ");
			String player2Word = scanner.next();

			if (!lastUsedWords.isEmpty()) {
				String lastUsedWord = lastUsedWords.get(lastUsedWords.size() - 1);
				char lastCharacter = lastUsedWord.charAt(lastUsedWord.length() - 1);
				if (englishDic.contains(player2Word) && !lastUsedWords.contains(player2Word)
						&& player2Word.charAt(0) == lastCharacter) {
					lastUsedWords.add(player2Word);
					player2.setScore(player2.getScore() + player2Word.length());
					if (player2.getScore() >= MAX_SCORE) {
						System.out.println("-------------------------");
						System.out.println("\t\t\t\t-Player 2 (" + player2.getName() + ") win!-");
						break;
					}

				} else {
					System.out.println("Incorrect Rules! (Check out the rules)");
				}

			} else {

				if (englishDic.contains(player2Word)) {
					lastUsedWords.add(player2Word);
					player1.setScore(player2.getScore() + player2Word.length());
					if (player2.getScore() >= MAX_SCORE) {
						System.out.println("-------------------------");
						System.out.println("\t\t\t\t-Player 2 (" + player2.getName() + ") win!-");
						break;
					}

				} else {
					System.out.println("Incorrect Rules! (Check out the rules)");
				}

			}
		}
	}

}
