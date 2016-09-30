import java.util.ArrayList;
import java.util.Collections;

public class Player {

	private ArrayList<Card> deck;
	private int topCardLoc;
	private boolean shouldShuffle;
	
	public Player(ArrayList<Card> deck) {
		this.deck = deck;
		topCardLoc = deck.size() - 1;
		shouldShuffle = false;
	}
	
	public Card playCard() {
		
		// If we are out of playable cards, re-shuffle our deck
		if(shouldShuffle) {
			resetDeck();
		}
		
		Card result = deck.get(topCardLoc);
		
		// Perform deck maintenance like moving on
		// to the next card and shuffling if need be
		--topCardLoc;
		
		// Shuffle the deck if we run out of playable cards
		if (topCardLoc == -1) {
			shouldShuffle = true;
		}
		
		return result;
	}
	
	private void resetDeck() {
		
		Collections.shuffle(deck);
		topCardLoc = deck.size() - 1;
		shouldShuffle = false;
	}
	
	public int cardCount() {return deck.size();}
	public boolean hasCards() {return !deck.isEmpty();}
	
	public Card giveCard(Card card) {
		
		deck.remove(card);
		return card;
	}
	public void takeCard(Card card) {
		deck.add(card);
	}
}
