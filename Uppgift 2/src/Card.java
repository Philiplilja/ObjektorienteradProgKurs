public class Card{
	
	private int value;
	private int suit;
	
	public static int HEARTS = 0;		//Kod för de fyra färgerna
	public static int SPADES = 1;
	public static int DIAMONDS = 2;
	public static int CLUBS = 3;
	
	public Card(int value, int suit){
		this.value = value;
		this.suit = suit;
	}
	
	public static int CardValue(Card CARD){  //Sätter värde på kortet
		int score = 0;                       //Värdet startar på noll
		
		if(CARD.getSuit() == 0){
			score = CARD.getValue() + 8;
		}
		else if(CARD.getSuit() == 1){
			score = CARD.getValue() + 10;
		}
		else if(CARD.getSuit() == 2){
			score = CARD.getValue() + 4;
		}
		else{
			score = CARD.getValue() + 6;
		}
		return score;
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}
}