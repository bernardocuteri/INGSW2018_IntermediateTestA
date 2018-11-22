package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnapsackTest {

	private static Knapsack knapsack;

	@BeforeClass
	public static void init() {
		System.out.println("ss");
		knapsack = new Knapsack(100);
	}

	@Before
	public void reset() {
		knapsack.reset();
	}

	@Test
	public void AggiornamentoDueItem() {
		Item i = new Item(20, 10);
		Item i2 = new Item(30, 15);
		knapsack.addItem(i);
		knapsack.addItem(i2);
		System.out.println(knapsack.getCurrentValue() + " " + (i.getValue() + i2.getValue()));
		assertEquals(knapsack.getCurrentValue(), i.getValue() + i2.getValue());
		assertEquals(knapsack.getCurrentWeight(), i.getWeight() + i2.getWeight());
	}

	@Test
	public void AggiornamentoTreItem() {
		System.out.println("comm");
		Item i = new Item(20, 10);
		Item i2 = new Item(30, 15);
		Item i3 = new Item(15, 15);
		knapsack.addItem(i);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.removeItem(i);
		System.out.println(knapsack.getCurrentValue() + " " + (i2.getValue() + i3.getValue()));
		assertEquals(knapsack.getCurrentValue(), (i2.getValue() + i3.getValue()));
		assertEquals(knapsack.getCurrentWeight(), i2.getWeight() + i3.getWeight());
	}

	@Test(expected = KnapsackInsertionError.class)
	public void Exception() {
		knapsack.addItem(new Item(20, 200));
	}

	@Test
	public void checkBest() {
		Item i = new Item(10, 20);
		Item i2 = new Item(15, 30);
		Item i3 = new Item(15, 15);
		Item i4 = new Item(5, 35);
		knapsack.addItem(i);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.addItem(i4);
		assertEquals(i4, knapsack.getBestItem());
	}

	@Test(timeout = 10000)
	public void milleItems() {
		Knapsack k = new Knapsack(10000);
		for (int i = 0; i < 1000; i++)
			k.addItem(new Item(1, 1));
	}
}
