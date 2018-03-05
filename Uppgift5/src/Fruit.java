import java.util.Random;


public class Fruit {
	
	protected int energy;
	protected String name;
	Random random = new Random();
	
	public Fruit(){
	}

	public int getValue() {
		return energy;
	}
	
	public String fruitClass() {
		return null;
	}
}
