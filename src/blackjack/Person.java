package blackjack;
import common.Hand;

public class Person {
	private String name;
	private Hand hand;
	
	public Person(String n, Hand h){
		setName(n);
		setHand(h);
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
}
