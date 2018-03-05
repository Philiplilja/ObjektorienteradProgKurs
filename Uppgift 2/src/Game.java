import java.util.Scanner;

public class Game {
	
	public static void main(String[] argv){
		Deck DeckOfCards = new Deck();  //Skapar kortleken
		
		Card card1, card2;
		
		int Comwin = 0, Humwin = 0;
		
		Scanner scan = new Scanner(System.in); 
		
		String quit = "a";
		
		System.out.println("Welcome to the game lucky one"); //Välkomsttext
		
		
		while(!quit.equals("q")){	  //Programmet körs tills bokstaven q skrivs in
			
			System.out.println("---Playing a single game---");  //Utdata med text + kort + totala värdet
			
			card1 = DeckOfCards.GetRandomCard();
			card2 = DeckOfCards.GetRandomCard();
		
			System.out.print("Computer draws ");
			System.out.println(PrintCard(card1));
			
			System.out.print("Human draws ");
			System.out.println(PrintCard(card2));
			
			System.out.print("Computer scores ");
			System.out.print(Card.CardValue(card1));
			System.out.print(" - human scores ");
			System.out.println(Card.CardValue(card2));
			
			
			
			if(Card.CardValue(card1) > Card.CardValue(card2)){  //Poängställningsfunktionen + utskrivning
				Comwin += 1;
				System.out.println("Computer wins ");
			}
			else if(Card.CardValue(card1) < Card.CardValue(card2)){
				Humwin += 1;
				System.out.println("Human wins ");
			}
			else{
				System.out.println("It's a tie");
			}
			
			System.out.println("Victories, computer: " + Comwin + ", human: " + Humwin);
			
			
		
			System.out.println("(Press enter to play again or type q to exit)");
		
			quit = scan.nextLine();
			
			if(quit.equals("q")){      //Hejdå-text
				System.out.println("Thank you for playing and welcome back!"); 
			}
		}
		scan.close();   //Stänger scanningen
	}
	
	public static String PrintCard(Card CARD){  //Utskrivning av korten
		String cardname;
		if(CARD.getSuit() == 0){
			cardname = CARD.getValue() + " of HEARTS";
			return cardname;
		}
		else if(CARD.getSuit() == 1){
			cardname = CARD.getValue() + " of SPADES";
			return cardname;
		}
		else if(CARD.getSuit() == 2){
			cardname = CARD.getValue() + " of DIAMONDS";
			return cardname;
		}
		else{
			cardname = CARD.getValue() + " of CLUBS";
			return cardname;
		}
		
	}
}

