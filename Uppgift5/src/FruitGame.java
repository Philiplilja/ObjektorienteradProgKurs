
public class FruitGame {

	public static void main(String[] args) {
		Bag bag = new Bag();
		
		Human Philip = new Human("Philip" , bag);
		Human Jimmy = new Human("Jimmy" , bag);
		Human Ida = new Human("Ida" , bag);
		
		Philip.start();
		Jimmy.start();
		Ida.start();
	}

}
