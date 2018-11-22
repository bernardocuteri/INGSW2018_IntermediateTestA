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
	public void testUno() {
		knapsack.addItem(new Item(1,1));
		knapsack.addItem(new Item(2,2));
		assertEquals(3,knapsack.getCurrentValue());
		assertEquals(3,knapsack.getCurrentWeight());	
	}
	
	@Test
	public void testDue() {
		knapsack.addItem(new Item(1,1));
		knapsack.addItem(new Item(2,2));
		knapsack.addItem(new Item(3,3));
		knapsack.removeItem(new Item(2,2));
		assertEquals(4,knapsack.getCurrentValue());
		assertEquals(4,knapsack.getCurrentWeight());		
	}
	
	@Test(expected = KnapsackInsertionError.class)
	public void testTre() {
		knapsack.addItem(new Item(150,150));
	}
	
	@Test
	public void testQuattro() {	
		knapsack.addItem(new Item(1,1));
		knapsack.addItem(new Item(2,2));
		knapsack.addItem(new Item(3,3));
		knapsack.addItem(new Item(1,5));
		Item i = knapsack.getBestItem();
		assertEquals(i,knapsack.getBestItem());
	}
	
	@Test(timeout = 1000)
	public void testCinque() {
		Knapsack k = new Knapsack(1000000);
		for(int i = 0; i < 1000; i++) {
			k.addItem(new Item(new Random().nextInt(10),new Random().nextInt(10)));
		}
	}
	
	
	
}
