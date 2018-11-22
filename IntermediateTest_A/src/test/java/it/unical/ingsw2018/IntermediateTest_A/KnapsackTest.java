package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void correctStateAfter2() {
		Item item1 = new Item(10, 30);
		Item item2 = new Item(40, 15);
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		assertEquals(50, knapsack.getCurrentWeight());
		assertEquals(45, knapsack.getCurrentValue());
	}
	
	@Test
	public void correctStateAfter3() {
		Item item1 = new Item(10, 30);
		Item item2 = new Item(40, 15);
		Item item3 = new Item(12, 12);
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.removeItem(item3);
		assertEquals(50, knapsack.getCurrentWeight());
		assertEquals(45, knapsack.getCurrentValue());
	}
	
	@Test
	public void getBestItemAfter4() {
		Item item1 = new Item(10, 30);
		Item item2 = new Item(30, 60);
		Item item3 = new Item(10, 10);
		Item item4 = new Item(20, 20);
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.addItem(item4);
		knapsack.getBestItem();
		assertEquals(20, knapsack.getBestItem().getRapporto());
	}
	
	
	@Test
	public void timeTest() {
		long s = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			knapsack.addItem(new Item(new Random().nextInt(1), new Random().nextInt(1)));
		}
		long e = System.currentTimeMillis();
		assertTrue(e-s <= 1000);
	}
	
	@Before
	public void reset() {
		knapsack.reset();
	}
}
