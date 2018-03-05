package se.his.a14phili;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Comparator;

public class HighscoreList {

	public static void main(String[] args) {
		
		int choice = 0;
		String end = "no";
		File fileName = new File("Highscore.txt"); //create txt file
		Scanner scan = new Scanner(System.in);  //opening scanner
		ArrayList<HighscoreItem> highScore = new ArrayList<HighscoreItem>();  //creating arraylist
		
		highScore = loadHighscore("Highscore.txt");  //load highscorelist before the program starts
		
		
		while(!end.equals("yes")){  //menu-while
		
		//Menu-list
		System.out.println("---HighScore menu---");
		System.out.println("1. Insert new item");
		System.out.println("2. Print list");
		System.out.println("3. Reset list");
		System.out.println("4. quit");
		System.out.print("Please make your choice and press enter:");
		
		
		try{    //Error handling
			try{
			choice = Integer.parseInt(scan.next());
			}
			catch(NumberFormatException e){
				System.out.println("Error, please enter a number");
				choice = 0;
			}
			switch (choice) {   // Switch construct/ menu-choice
				case 1:
					System.out.print("Name: ");
					String name = scan.next();
					System.out.print("score: ");
					int score = scan.nextInt();
					highScore.add(new HighscoreItem(name, score));
					System.out.println(name + " with score " + score + " was added to the list.");
					break;
				case 2:
					System.out.println("---The highscore list---");
					SortHighscore(highScore);
					printHighscore(highScore);
					break;
				case 3:
					highScore.clear();
					System.out.println("The highscore list has been reset.");
					break;
				case 4:
					end = "yes";
					System.out.println("Thank you for using the highscore list.");
					saveHighscore(highScore, "Highscore.txt");
					break; 
				default:
					System.out.println("Error, please enter a number");
				}
			}
			catch(InputMismatchException f){
				choice = 0;
			}
		}
	}
	
	//Sort the highscorelist
	public static void SortHighscore(ArrayList<HighscoreItem> list){
		Collections.sort(list, new Comparator<HighscoreItem>(){
			public int compare(HighscoreItem o1, HighscoreItem o2) {
				return o2.getScore() - o1.getScore();
			}
		});
		if(list.size() > 5){
			for(int i =5; i <=list.size(); i++)
				list.remove(i);
		}
	}

	//printing the highscorelist
	public static void printHighscore(ArrayList<HighscoreItem> list){
		int j = 1;
		for(int i=0; i<list.size(); i++){
			String name = list.get(i).getName();
			int score =list.get(i).getScore();
			System.out.println(j + ".   " + name + "  " + score);
			j++;
		}
		for(int k = j; k < 6; k++){
			System.out.println(k + "    unknown");
		}
	}
	
	
	//Saving the highscorelist
	public static void saveHighscore(ArrayList<HighscoreItem> highScores, String fileName)   //Save Highscore to file
	{
		try 
		{
			FileOutputStream stream = new FileOutputStream(fileName);
			ObjectOutputStream objectStream = new ObjectOutputStream(stream);
			for(HighscoreItem highScore : highScores) 
			{
				objectStream.writeObject(highScore);
			}
			objectStream.writeObject(null); 
			objectStream.close();
		} 
			catch (Exception e) {
		}
	}
		
	//loading the highscorelist
	public static ArrayList<HighscoreItem> loadHighscore(String fileName)   //Load highscore from the file
	{
		try 
		{
			FileInputStream fileStream = new FileInputStream(fileName);
			ObjectInputStream inputStream = new ObjectInputStream(fileStream);
			ArrayList<HighscoreItem> highScore = new ArrayList<HighscoreItem>();
			HighscoreItem highScores = null;
			do 
			{
				highScores = (HighscoreItem)inputStream.readObject();
				if(highScores != null) {
					highScore.add(highScores);
				}
			} 
			while(highScores != null);
			inputStream.close();
			return highScore;
		} catch(Exception e) {e.printStackTrace();}
			return new ArrayList<HighscoreItem>();
	}
		
}

