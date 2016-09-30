import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class WarSim {
	
	private Player a;
	private Player b;
	
	private Card deck[];
	
	public WarSim() {
		
		// Init the starting deck and shuffle it
		deck = new Card[52];
		Card.CardSuit suit = null;
		for(int i = 0; i < 4; ++i) {
			
			// Pick the suit
			switch(i) {
			case 0:
				suit = Card.CardSuit.Clubs;
				break;
			case 1:
				suit = Card.CardSuit.Spades;
				break;
			case 2:
				suit = Card.CardSuit.Diamonds;
				break;
			case 3:
				suit = Card.CardSuit.Hearts;
				break;
			}
			
			// Fill in cards for that suit
			deck[i * 13 + 0]  = new Card(suit, Card.CardType.Card_2);
			deck[i * 13 + 1]  = new Card(suit, Card.CardType.Card_3);
			deck[i * 13 + 2]  = new Card(suit, Card.CardType.Card_4);
			deck[i * 13 + 3]  = new Card(suit, Card.CardType.Card_5);
			deck[i * 13 + 4]  = new Card(suit, Card.CardType.Card_6);
			deck[i * 13 + 5]  = new Card(suit, Card.CardType.Card_7);
			deck[i * 13 + 6]  = new Card(suit, Card.CardType.Card_8);
			deck[i * 13 + 7]  = new Card(suit, Card.CardType.Card_9);
			deck[i * 13 + 8]  = new Card(suit, Card.CardType.Card_10);
			deck[i * 13 + 9]  = new Card(suit, Card.CardType.Card_J);
			deck[i * 13 + 10] = new Card(suit, Card.CardType.Card_Q);
			deck[i * 13 + 11] = new Card(suit, Card.CardType.Card_K);
			deck[i * 13 + 12] = new Card(suit, Card.CardType.Card_A);
		}
		
		// Shuffle starting deck
		Collections.shuffle(Arrays.asList(deck), new Random(1));
		
		ArrayList<Card> aHand = new ArrayList<>();
		ArrayList<Card> bHand = new ArrayList<>();
		
		// Distribute the deck to the players
		for(int i = 0; i < 26; ++i) {
			aHand.add(deck[2 * i]);
			bHand.add(deck[2 * i + 1]);
		}
		
		a = new Player(aHand);
		b = new Player(bHand);
		
		
		/*
		 * Play the actual game and report the results.
		 */
		int value = playGame();
		
		if (value == 0) {
			System.out.println("Player A won!");
		}
		else if (value == 1) {
			System.out.println("Player B won!");
		}
	}
	
	// Plays the game of War and returns 0 upon A's winning or 1 upon B's winning.
	public int playGame() {
		
		// Play the game while people still have cards
		while(a.hasCards() && b.hasCards()) {
			
			reportStatus();
			
			// Each player draw a card
			Card aCard = a.playCard();
			Card bCard = b.playCard();
			
			ArrayList<Card> aCardsOnTheLine = new ArrayList<>();
			ArrayList<Card> bCardsOnTheLine = new ArrayList<>();
			aCardsOnTheLine.add(aCard);
			bCardsOnTheLine.add(bCard);
			
			// Battle the cards
			battle(aCardsOnTheLine, bCardsOnTheLine, 0);
		}
		
		if(!a.hasCards()) {
			return 0;
		}
		else if (!b.hasCards()) {
			return 1;
		}
		
		return -1;
	}
	
	public void battle(ArrayList<Card> aCardsOnTheLine, ArrayList<Card> bCardsOnTheLine, int battleDepth) {
		
		Card aCard = aCardsOnTheLine.get(battleDepth * 4);
		Card bCard = bCardsOnTheLine.get(battleDepth * 4);
		
		// A's card is bigger
		if(aCard.compareTo(bCard) > 0) {
			for(Card c : bCardsOnTheLine) {
				a.takeCard(b.giveCard(c));
			}
		}
		// B's card is bigger
		else if (aCard.compareTo(bCard) < 0) {
			for(Card c : aCardsOnTheLine) {
				b.takeCard(a.giveCard(c));
			}
		}
		// WARRRR!
		else {
			
			for(int i = 0; i < 4; ++i) {
				aCardsOnTheLine.add(a.playCard());
				bCardsOnTheLine.add(b.playCard());
			}
			
			battle(aCardsOnTheLine, bCardsOnTheLine, battleDepth + 1);
		}
	}
	
	public void reportStatus() {
		
		System.out.print('|');
		for(int i = 0; i < a.cardCount(); ++i) {
			System.out.print(' ');
		}
		System.out.print('X');
		for(int i = 0; i < b.cardCount(); ++i) {
			System.out.print(' ');
		}
		System.out.println('|');
	}

	public static void main(String[] args) {
		new WarSim();
	}
}
