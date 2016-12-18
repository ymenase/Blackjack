package common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	List<Card> hand = new ArrayList<>();

	public Hand() {
	}

	public int getTotalOfHand(Hand hand) {
		//iterate over hand to total cards
		//this method works for player and dealer based off of the argument in the method call
		int total = 0;
		for (Card card : hand.getHand()) { //figure out total of hand
//			System.out.println("test " + card);
			total = total + card.getValue(); 
		} 
		if (total > 21) { //see if total is over 21
			hand.checkHand();
		}
		total = 0;
		for (Card card : hand.getHand()) { //recalculate the total
//			System.out.println("test " + card);
			total = total + card.getValue(); 
		} 
		return total;
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
