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
	public void checkUpdate() {
		Item a = new Item(10, 10);
		Item b = new Item(20, 20);
		knapsack.addItem(b);
		knapsack.addItem(a);
		assertEquals(knapsack.getCurrentWeight(), 30);
		assertEquals(knapsack.getCurrentValue(), 30);
	}
	
	@Test
	public void checkUpdate2() {
		Item a = new Item(10, 10);
		Item b = new Item(20, 20);
		Item c = new Item(10, 10);
		knapsack.addItem(b);
		knapsack.addItem(a);
		knapsack.addItem(c);
		knapsack.removeItem(c);
		assertEquals(knapsack.getCurrentWeight(), 30);
		assertEquals(knapsack.getCurrentValue(), 30);
	}
	
	@Test (expected = KnapsackInsertionError.class)
	public void checkError() {
		Item a = new Item(10000, 1);
		knapsack.addItem(a);
	}
	
	@Test
	public void checkBest() {
		Item a = new Item(10, 10);
		Item b = new Item(20, 20);
		Item c = new Item(1, 100);
		Item d = new Item(10, 10);
		knapsack.addItem(b);
		knapsack.addItem(a);
		knapsack.addItem(c);
		knapsack.addItem(d);
		assertEquals(knapsack.getBestItem(), c);
	}
	
	@Test(timeout = 1000)
	public void checkPerformance() {
		Knapsack k = new Knapsack(1500);
		for (int i = 0; i < 1000; i++) {
			k.addItem(new Item(1, i));
		}
	}
}
