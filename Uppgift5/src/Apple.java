
public class Apple extends Fruit {
	
	public Apple(){
		name = "Apple";
		energy = random.nextInt(11)+20;
	}

	@Override
	public String fruitClass(){
		return "Apple";
	}
	
}
