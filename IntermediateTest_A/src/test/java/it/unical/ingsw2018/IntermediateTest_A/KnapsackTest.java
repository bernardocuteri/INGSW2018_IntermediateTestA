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
	
	@Test
	public void addItemTest() {
		Item itm1 = new Item(2, 5);
		Item itm2 = new Item(4, 7);
		knapsack.addItem(itm1);
		knapsack.addItem(itm2);
		Assert.assertEquals(18, (knapsack.getCurrentWeight() + knapsack.getCurrentValue()));
	}
	
	@Test
	public void removeItemTest() {
		Item itm1 = new Item(2, 5);
		Item itm2 = new Item(4, 7);
		Item itm3 = new Item(3, 4);
		knapsack.addItem(itm1);
		knapsack.addItem(itm2);
		knapsack.addItem(itm3);
		knapsack.removeItem(itm2);
		Assert.assertEquals(14, (knapsack.getCurrentWeight() + knapsack.getCurrentValue()));
	}
	
	@Test(expected=RuntimeException.class)
	public void exceptionItemTest() {
		Item itm = new Item(101, 5);
		knapsack.addItem(itm);
	}
	
	@Test
	public void getBestItemTest() {
		Item itm1 = new Item(2, 5);
		Item itm2 = new Item(4, 7);
		Item itm3 = new Item(5, 8);
		Item itm4 = new Item(3, 4);
		knapsack.addItem(itm1);
		knapsack.addItem(itm2);
		knapsack.addItem(itm3);
		knapsack.addItem(itm4);
		Item itm = knapsack.getBestItem();
		Assert.assertEquals(13, (itm.getWeight() + itm.getValue()));
	}
	
	@Test(timeout=1000)
	public void randomItemTest() {
		Knapsack zaino = new Knapsack(1000);
		for(int i=1; i<=1000; i++) {
			zaino.addItem(new Item(1, 2));
		}
	}
}
