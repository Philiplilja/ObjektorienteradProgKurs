import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Card GetRandomCard(){              //Randomiserar kort från kortleken
		int index = (int) (Math.random()*51);
		return cards.get(index);
	}
	
	
	public Deck(){
		cards = new ArrayList<Card>();
		initDeck();
	}
	
	private void initDeck(){                   //Skapar 4 "färger" med 13 "kort" i varje "färg"
		for(int j = 0; j < 4; j++){
			for(int i = 1; i < 14; i++){
				cards.add(new Card(i, j));
			}
		}
	}
}