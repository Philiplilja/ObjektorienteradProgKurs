
public class Pear extends Fruit {
	
	public Pear(){
		name = "Pear";
		energy = random.nextInt(21)+20;
	}
	
	@Override
	public String fruitClass(){
		return "Pear";
	}
	
}
