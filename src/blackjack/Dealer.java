package blackjack;

import java.util.Scanner;

import common.Deck;
import common.Hand;

public class Dealer extends Person {
	Scanner keyboard = new Scanner(System.in);
	Deck d = new Deck();
	public Dealer(){
		
	}
	public Dealer(String n, Hand h) {
		super(n, h);
	}
	
	public  void dealingLogic(Hand dealerHand, Hand playerHand, Player player, Hand h){
		//options for user input
		if (h.getTotalOfHand(playerHand) == 21 || h.getTotalOfHand(dealerHand) == 21) {
			if(h.getTotalOfHand(playerHand) == 21){
				System.out.println(player.getName() + " has 21 and is the winner! \uD83C\uDF89");
				new DriverClass().restart();
			}
			if(h.getTotalOfHand(dealerHand) == 21){
				System.out.println("Dealer has 21! " + player.getName() + " lost \u2639");
			}
			System.exit(0);
		}
		if (h.getTotalOfHand(playerHand) > 21){ //compare current total to 21(break point)
			//if player has over 21, then check to see if he has an ace and lower the value
			playerHand.checkHand();
			if (h.getTotalOfHand(playerHand) > 21){
				System.out.println(player.getName() + " busted! \u2639");
				new DriverClass().restart();
			}
		}
		else {			
			System.out.println("Select 1 to hit or 2 to stay: ");
			int choice = keyboard.nextInt();
			
			if (choice == 1) {
				playerHand.addCardToHand(d.dealDeck()); //card being dealt and added to hand
				System.out.println(player.getName() + "'s new card: " + new DriverClass().getLastCard(playerHand));
				System.out.println(player.getName() + "'s total is " + h.getTotalOfHand(playerHand));
				dealingLogic(dealerHand, playerHand, player, new Hand());
				
			}		
			if (choice ==2) {
				
				while (h.getTotalOfHand(dealerHand) < 17) {
					dealerHand.addCardToHand(d.dealDeck()); 
					System.out.println("Dealer's new card: " + new DriverClass().getLastCard(dealerHand));

					if (h.getTotalOfHand(dealerHand) > 21) {
						System.out.println("Dealer's total is " + h.getTotalOfHand(dealerHand));
						System.out.println("Dealer busted --" + player.getName() + " wins! \uD83C\uDF89");
						new DriverClass().restart();
					}
				}
				if(h.getTotalOfHand(dealerHand) <= 21){
				if (h.getTotalOfHand(playerHand) > h.getTotalOfHand(dealerHand)) {
					System.out.println(player.getName() + "'s total is: " + h.getTotalOfHand(playerHand));
					System.out.println("Dealer's new card: " + new DriverClass().getLastCard(dealerHand));
					System.out.println("Dealer's total is: " + h.getTotalOfHand(dealerHand));
					System.out.println(player.getName() + "wins! \uD83C\uDF89");
					new DriverClass().restart();
				}
				else if (h.getTotalOfHand(playerHand) == h.getTotalOfHand(dealerHand)) {
					System.out.println("Everyone got blackjack but the win goes to the dealer.");
					new DriverClass().restart();
				}
				else {
					System.out.println(player.getName() + " lost to the dealer! \u2639");
					new DriverClass().restart();
				}
				}
			}
		}
	}
}
