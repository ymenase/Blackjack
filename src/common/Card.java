package common;

public class Card {
	private Suit suits;
	private Rank rank;
	private int value;
	
	public Card(){
		
	}
	public Card(Rank r, Suit s, int val) {
		rank = r;
		suits = s;
		value = val;
	}
	
	public Suit getSuits() {
		return suits;
	}
	
	public void setSuits(Suit suits) {
		this.suits = suits;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int val) {
		value = val;
	}
	
	public String toString() {
		return rank + " of " + suits + " is " + value;
	}
}