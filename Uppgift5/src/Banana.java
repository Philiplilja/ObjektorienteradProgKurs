
public class Banana extends Fruit {

	public Banana(){
		name = "Banana";
		energy = random.nextInt(11)+25;
	}
	
	@Override
	public String fruitClass(){
		return "Banana";
	}
	
}
