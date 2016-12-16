package common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> hand = new ArrayList<>();

	public Hand() {
	}

	public void addCardToHand(Card c) {
		hand.add(c);
	}

	public String toString() {
		return "Player's hand: " + hand;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void checkHand() {
		int i;
		for (i = 0; i < hand.size(); i++) {
			if (hand.get(i).getValue() == 11) {
				hand.get(i).setValue(1);
			}
		}
	}

}
