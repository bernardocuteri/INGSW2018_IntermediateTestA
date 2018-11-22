package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import java.util.Random;

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
	public void insert2Item() {
		knapsack.addItem(new Item(10, 5));
		knapsack.addItem(new Item(3, 9));
		assertEquals(knapsack.getCurrentWeight(), 13);
		assertEquals(knapsack.getCurrentValue(), 14);
	}
	
	@Test
	public void insert3Item() {
		Item item1 = new Item(5, 5);
		knapsack.addItem(new Item(10, 5));
		knapsack.addItem(new Item(3, 9));
		knapsack.addItem(item1);
		knapsack.removeItem(item1);
		
		assertEquals(knapsack.getCurrentWeight(), 13);
		assertEquals(knapsack.getCurrentValue(), 14);
		
	}
	
	@Test(expected = KnapsackInsertionError.class)
	public void error() {
		Item item = new Item(110,4);
		knapsack.addItem(item);
	}
	
	@Test
	public void best() {
		Item item1 = new Item(10,2);
		Item item2 = new Item(15,5);
		Item item3 = new Item(20,4);
		Item item4 = new Item(25,5);
		
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.addItem(item4);
		
		assertEquals(knapsack.getBestItem(), item2);
		
	}
	
	@Test(timeout=1000)
	public void time() {
		Knapsack knapsack1 = new Knapsack(1000000);
		Random r = new Random();
		int cont = 0;
		while(cont <= 1000) {
			knapsack1.addItem(new Item(r.nextInt(1000), r.nextInt(100)));
			cont++;
		}
	}
}
