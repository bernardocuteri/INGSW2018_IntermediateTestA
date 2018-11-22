package it.unical.ingsw2018.IntermediateTest_A;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnapsackTest {

	private static Knapsack knapsack;

	@BeforeClass
	public static void init() {
		knapsack = new Knapsack(100);
	}

	@Before
	public void reset() {
		knapsack.reset();
	}

	// un metodo che verifica che lo stato (peso e valore) dello zaino si aggiorni
	// correttamente dopo l’inserimento di 2 item
	@Test
	public void addItemTest() {

		Item item = new Item(1, 1);
		Item item2 = new Item(1, 1);
		knapsack.addItem(item);
		knapsack.addItem(item2);
		int peso = item.getWeight() + item2.getWeight();
		int valore = item2.getValue();
		Assert.assertEquals(peso, knapsack.getCurrentWeight());
		Assert.assertEquals(valore, knapsack.getCurrentValue());
	}

	// un metodo che verifica che lo stato dello zaino si aggiorni correttamente
	// dopo l’inserimento di 3 item e la rimozione di uno di essi
	@Test
	public void removeItemTest() {
		Item item = new Item(1, 1);
		Item item2 = new Item(1, 1);
		Item item3 = new Item(1, 1);
		knapsack.addItem(item);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.removeItem(item3);
		int peso = item.getWeight() + item2.getWeight() + item3.getWeight();
		int valore = item2.getValue();
		Assert.assertEquals(peso - item3.getWeight(), knapsack.getCurrentWeight());
		Assert.assertEquals(valore, knapsack.getCurrentValue());

	}

	@Test(expected = KnapsackInsertionError.class)
	public void sforaCapacityTest() {
		Item item = new Item(100, 1);
		Item item2 = new Item(101, 1);
		knapsack.addItem(item);
		knapsack.addItem(item2);
	}

	@Test
	public void massimoTest() {
		Item item = new Item(1, 1);
		Item item2 = new Item(2, 2);
		Item item3 = new Item(3, 3);
		Item item4 = new Item(4, 4);
		knapsack.addItem(item);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.addItem(item4);
		Assert.assertEquals(item4, knapsack.getBestItem());

	}

	@Test(timeout = 1000)
	public void performanceTest1() {

		Knapsack knapsack = new Knapsack(1000);
		for (int i = 0; i < 1001; i++)
			knapsack.addItem(new Item((int) Math.random() * 100, (int) Math.random() * 100));

	}
}
