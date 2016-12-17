package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck implements Comparator {
	List<Card> deck = new ArrayList<>();
	int numDealt;
	Hand handD = new Hand(); 
	
	public Deck() {
		createDeck();
	}

	public int getNumDealt() {
		return numDealt;
	}

	public void setNumDealt(int numD) {
		numD = numDealt;
	}

	public void createDeck() {
		Card c = new Card(); // local variable
		//loop through ranks and suits to create new deck
		for (int i = 0; i < Rank.values().length; i++) {
			for (int j = 0; j < Suit.values().length; j++) {

				if (i < 8) {
					c = new Card(Rank.values()[i], Suit.values()[j], i + 2);
				}
				if (i >= 8 && i < Rank.values().length - 1) {
					c = new Card(Rank.values()[i], Suit.values()[j], 10);
				}
				if (i == Rank.values().length - 1) {
					c = new Card(Rank.values()[i], Suit.values()[j], 11);
				}
				deck.add(c); //add created card to deck
			}
		}
		System.out.println("Now shuffling the deck...");
		Collections.shuffle(deck);
	

	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public int compare(Object o1, Object o2) {
		return 0;
	}
	
	public Card dealDeck(){
		Card topCard = deck.get(0);
		deck.remove(0);
		return topCard;
		
	
	}
}

