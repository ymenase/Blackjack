package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

import common.Card;
import common.Deck;
import common.Hand;

public class DriverClass { // class bracket
	static Scanner keyboard = new Scanner(System.in);
	static Deck deck;
//	DriverClass dc1 = new DriverClass();

	public static void main(String[] args) {
		System.out.println("test");
		Dealer dealer = new Dealer();
		start(dealer);
	} 

	public static void start(Dealer dealer) {
		System.out.println("test");
		Hand handD = new Hand(); // instantiate hand objects
		Hand handP = new Hand();
		Hand h = new Hand();
		System.out.println("Welcome to Blackjack!");
		System.out.println("Enter player's name:");
		String name = keyboard.nextLine(); // receive player's name

		Player player = new Player(name, handP);
		deck = new Deck();

//		ArrayList<Card> deckOfCards = (ArrayList<Card>) // create an ArrayList
														// that holds card
		// objects
		deck.getDeck();

		handD.addCardToHand(deck.dealDeck()); // adding cards to hands by
												// dealing
		handD.addCardToHand(deck.dealDeck());
		handP.addCardToHand(deck.dealDeck());
		handP.addCardToHand(deck.dealDeck());
		System.out.println("Dealer's Hand"); // iterate over dealer's hand to
												// print those cards
		for (Card c : handD.getHand()) {
			System.out.println(c);
		}
		// print dealer's hand
		System.out.println("Dealer's total is " + h.getTotalOfHand(handD));
		System.out.println();
		System.out.println(player.getName() + "'s Hand");
		for (Card c : handP.getHand()) {
			System.out.println(c);
		}
		System.out.println("Player's total is " + h.getTotalOfHand(handP));
		 dealer.dealingLogic(handD, handP, player, h);
	}

	public static void restart() {
		System.out.println("Would you like to play again? Y/N");
		String answer = keyboard.next();
		if (answer.equalsIgnoreCase("Y")) {
			start(new Dealer());
		} else {
			System.out.println("You have exited the game. Thanks for playing!");
			System.exit(0);
		}
	}

	public static Card getLastCard(Hand h) {
		return h.getHand().get(h.getHand().size() - 1);

		// getting player hand from the array
	}

}
