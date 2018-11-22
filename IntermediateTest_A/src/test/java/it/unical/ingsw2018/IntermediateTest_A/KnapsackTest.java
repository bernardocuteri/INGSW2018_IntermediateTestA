package it.unical.ingsw2018.IntermediateTest_A;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnapsackTest {
	
	private static Knapsack knapsack;
	
	@BeforeClass
	public static void init() {
		knapsack = new Knapsack(100);
	}
	
	@Test
	public void testAdd() {		
		Item item1 = new Item (1, 1);
		Item item2 = new Item (2, 2);
		
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		
	
		assertEquals(3, knapsack.getCurrentWeight());
		assertEquals(3, knapsack.getCurrentValue());
	}
	
	@Test
	public void testRemove() {
		
		reset();
		
		Item item1 = new Item (1, 1);
		Item item2 = new Item (2, 2);
		Item item3 = new Item(2,2);
		

		knapsack.addItem(item1);
		knapsack.addItem(item2);
		int weight = item1.getWeight() + item2.getWeight();
		int value = item1.getValue() + item2.getValue();
		knapsack.addItem(item3);
		
		knapsack.removeItem(item3);
		assertEquals(weight, knapsack.getCurrentWeight());
		assertEquals(value, knapsack.getCurrentValue());
		
	}
	
	@Before
	public void reset() {
		knapsack.reset();
	}
}
