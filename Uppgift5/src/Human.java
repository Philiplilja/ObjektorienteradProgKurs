import java.util.Random;

public class Human extends Thread {

	String name;
	int energylevel;
	Random randomEnergy = new Random();
	Bag bag;

	//Making a human
	public Human(String name, Bag b) {
		this.name = name;
		energylevel = randomEnergy.nextInt(60) + 30;
		bag = b;
		System.out.println(name + " created with " + energylevel + " energy");
	}

	//Picks a fruit from bag and eats it
	public void eatFruit() {
		Fruit fruit = bag.getFruit();
		energylevel += fruit.getValue();
		System.out.println(name + " picked " + fruit.fruitClass()
				+ " and starts to eat it");
		System.out.println(name + " ate " + fruit.fruitClass() + " with "
				+ fruit.getValue() + " energy and now has " + energylevel
				+ " energy");

	}

	//Override with new run
	@Override
	public void run() {

		while (true) {

			energylevel -= 5;

			if (energylevel < 20) {
				System.out.println(name + " has " + energylevel + " energy and is hungry...");
				eatFruit();
			}

			try {
				sleep((int) (Math.random() * 1000.0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
