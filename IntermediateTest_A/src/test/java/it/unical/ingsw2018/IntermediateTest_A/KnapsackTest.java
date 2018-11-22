package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

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

	@Test
	public void knapsackStateTest() {
		Item a = new Item(4, 3);
		Item b = new Item(4, 7);
		knapsack.addItem(a);
		knapsack.addItem(b);
		assertEquals(8, knapsack.getCurrentWeight());
		assertEquals(10, knapsack.getCurrentValue());
	}

	@Test
	public void knapsackStateTest2() {
		Item a = new Item(2, 5);
		Item b = new Item(4, 6);
		Item c = new Item(3, 4);

		knapsack.addItem(a);
		knapsack.addItem(b);
		knapsack.addItem(c);

		knapsack.removeItem(b);

		assertEquals(5, knapsack.getCurrentWeight());
		assertEquals(9, knapsack.getCurrentValue());
	}

	@Test(expected = KnapsackInsertionError.class)
	public void knapsackException() {
		Knapsack temp = new Knapsack(1);
		temp.addItem(new Item(3, 6));
		temp.addItem(new Item(5, 2));
	}

	@Test
	public void bestItemTest() {
		Item a = new Item(2,10);
		Item b = new Item(9, 8);
		Item c = new Item(2, 2);
		Item d = new Item(8, 3);

		knapsack.addItem(b);
		knapsack.addItem(a);
		knapsack.addItem(c);
		knapsack.addItem(d);

		assertEquals(a, knapsack.getBestItem());
	}

	@Test(timeout = 1000)
	public void performanceTest() {
		Knapsack test1 = new Knapsack(2000);
		for (int i = 0; i < 1000; i++)
			test1.addItem(new Item((int) Math.random() + 1, (int) Math.random() + 1));
	}
}