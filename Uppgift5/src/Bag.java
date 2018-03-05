import java.util.ArrayList;
import java.util.Random;

public class Bag {

	ArrayList<Fruit> fruitBag = new ArrayList<Fruit>();
	Random bag = new Random();
	int type;

	public Bag() {

		int type;

		//Making 20 random new fruits
		for (int i = 0; i < 20; i++) {
			type = bag.nextInt(3);
			if (type == 0) {
				Pear pear = new Pear();
				fruitBag.add(pear);
				System.out.println("- Pear with " + pear.getValue()
						+ " energy was added to the fruit bag");
			} else if (type == 1) {
				Apple apple = new Apple();
				fruitBag.add(apple);
				System.out.println("- Apple with " + apple.getValue()
						+ " energy was added to the fruit bag");
			} else {
				Banana banana = new Banana();
				fruitBag.add(banana);
				System.out.println("- Banana with " + banana.getValue()
						+ " energy was added to the fruit bag");
			}
		}

	}

	
	//Adding 5 random new fruits
	public synchronized void addFruit() {

		for (int j = 0; j < 5; j++) {

			type = bag.nextInt(3);

			if (type == 0) {
				Pear pear = new Pear();
				fruitBag.add(pear);
				System.out.println("- Pear with " + pear.getValue()
						+ " energy was added to the fruit bag");
			}
			else if (type == 1) {
				Apple apple = new Apple();
				fruitBag.add(apple);
				System.out.println("- Apple with " + apple.getValue()
						+ " energy was added to the fruit bag");
			}
			else {
				Banana banana = new Banana();
				fruitBag.add(banana);
				System.out.println("- Banana with " + banana.getValue()
						+ " energy was added to the fruit bag");
			}
		}
	}

	//adding 5 random new fruits in a chance 1/5
	public synchronized Fruit getFruit() {

		int fruit = bag.nextInt(fruitBag.size());
		Fruit f = fruitBag.get(fruit);
		fruitBag.remove(fruit);
		int a = bag.nextInt(5);
		if (a == 0) {
			addFruit();
		}
		System.out.println("- The fruit bag now contains " + fruitBag.size()
				+ " fruits");
		return f;
	}

}
