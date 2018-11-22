package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

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
	public void twoItemTest() {
		Item item1 = new Item(10,10);
		Item item2 = new Item(20,20);
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		assertEquals(knapsack.getCurrentValue(), item1.getValue()+item2.getValue());
		assertEquals(knapsack.getCurrentWeight(), item1.getWeight()+item2.getWeight());
	}
	
	@Test
	public void threeItemTest() {
		Item item1 = new Item(10,10);
		Item item2 = new Item(20,20);
		Item item3 = new Item(30,30);
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.removeItem(item3);
		assertEquals(knapsack.getCurrentValue(), item1.getValue()+item2.getValue());
		assertEquals(knapsack.getCurrentWeight(), item1.getWeight()+item2.getWeight());
	}
	
	@Test(expected=KnapsackInsertionError.class)
	public void exceptionTest() {
		Item item1 = new Item(110, 10);
		knapsack.addItem(item1);
	}
	
	@Test
	public void bestItemTest() {
		Item item1 = new Item(10,10);
		Item item2 = new Item(20,20);
		Item item3 = new Item(30,30);
		Item item4 = new Item(35,40);
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.addItem(item4);
		assertEquals(knapsack.getBestItem(), item4);
	}
	
	@Test(timeout = 1000)
	public void newKnapSackTest() {
		Knapsack tempSack = new Knapsack(1000000);
		for(int i = 0; i < 1000; i++) {
			tempSack.addItem(new Item(1,1));
		}
	}
}
