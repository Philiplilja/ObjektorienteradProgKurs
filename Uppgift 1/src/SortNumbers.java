import java.util.Scanner;

public class SortNumbers {

	public static void main(String[] args) {
		System.out.println("Welcome, enter 6 numbers");
		
		//Matar in skrivna nummer från användaren till array
		Scanner in = new Scanner(System.in);
		
		int[] myArray = new int[6];
		for(int i = 0; i < 6; ++i) {
			int NextNumber = in.nextInt();
			myArray[i] = NextNumber;
		}
		
		//skriver ut vilka nummer som skrivits in
		System.out.println("You have entered: ");
		for(int i = 0; i < 6; ++i) {
			System.out.print(myArray[i] + " ");
		}
		System.out.println();
		
		SortArray(myArray);
		reverseNum(myArray);
	
		in.close();
	}
	
	//Sorterar Array-tal från lägst till störst 
	private static void SortArray(int[] myArray){
		for(int i = 0; i < myArray.length; ++i) {
			int minIndex = i;
			for(int j = i + 1; j < myArray.length; ++j) { 
				if(myArray[j] < myArray[minIndex]) {
					minIndex = j;
				}
			}
			int temp = myArray[i];
			myArray[i] = myArray[minIndex];
			myArray[minIndex] = temp;
		}
	}
	
	//skriver ut array bakvänt mot vad den har sorterats
	private static void reverseNum(int[] myArray){
		System.out.println("Sorted in descending order: ");
		for(int i = 5; i >= 0; i--){
			System.out.print(myArray[i] + " ");
        }
	}
}
