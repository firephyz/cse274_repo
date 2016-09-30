
public class Card implements Comparable<Card> {
	
	private CardSuit suit;
	private CardType type;
	
	public Card(CardSuit suit, CardType type) {
		this.type = type;
		this.suit = suit;
	}

	@Override
	public int compareTo(Card card) {
		
		if(this.type.getValue() > card.type.getValue()) {
			return 1;
		}
		else if (this.type.getValue() < card.type.getValue()) {
			return -1;
		}
		
		return 0;
	}
	
	@Override 
	public String toString() {
		return type.getName() + " of " + suit.getName();
	}
	
	public String valueToString() {
		
		String result = "";
		int mult = 3;
		
		switch(suit) {
		case Diamonds:
			mult = 2;
			break;
		case Spades:
			mult = 1;
			break;
		case Clubs:
			mult = 0;
			break;
		}
		
		for(int i = 0; i < mult * 13 + type.getValue() - 1; ++i) {
			result += ' ';
		}
		
		return result + 'X';
	}
	
	public enum CardSuit {
		
		Hearts ("Hearts"),
		Diamonds ("Diamonds"),
		Spades ("Spades"),
		Clubs ("Clubs");
		
		private String name;
		
		private CardSuit(String name) {
			this.name = name;
		}
		
		public String getName() {return name;}
	}

	public enum CardType {
		
		Card_2 (1, "Two"),
		Card_3 (2, "Three"),
		Card_4 (3, "Four"),
		Card_5 (4, "Five"),
		Card_6 (5, "Six"),
		Card_7 (6, "Seven"),
		Card_8 (7, "Eight"),
		Card_9 (8, "Nine"),
		Card_10 (9, "Ten"),
		Card_J (10, "Jack"),
		Card_Q (11, "Queen"),
		Card_K (12, "King"),
		Card_A (13, "Ace");
		
		private String name;
		private int value;
		
		private CardType(int value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public int getValue() {return value;}
		public String getName() {return name;}
	}
}
