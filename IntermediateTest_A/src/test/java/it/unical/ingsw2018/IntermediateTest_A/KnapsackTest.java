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
	public void after2insert() {
		Item i1 = new Item(5, 5);
		Item i2 = new Item(4, 5);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		System.out.println("W : "+knapsack.getCurrentWeight()+" V : "+knapsack.getCurrentValue());
		assertEquals(9, knapsack.getCurrentWeight());
		assertEquals(10, knapsack.getCurrentValue());
	}
	
	@Test
	public void after3insertAnd1Remove() {
		Item i1 = new Item(5, 5);
		Item i2 = new Item(4, 5);
		Item i3 = new Item(3, 3);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.removeItem(i2);
		assertEquals(8, knapsack.getCurrentValue());
		assertEquals(8, knapsack.getCurrentWeight());
	}
	
	@Test(expected=KnapsackInsertionError.class)
	public void exceptioner() {
		Item big = new Item(101, 1);
		knapsack.addItem(big);
	}
	
	@Test
	public void bestItemTester() {
		Item i1 = new Item(5, 5);
		Item i2 = new Item(4, 5);
		Item i3 = new Item(3, 3);
		Item best = new Item(5,100);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.addItem(best);
		System.out.println(knapsack.getBestItem().getValue());
		assertEquals(best, knapsack.getBestItem());
	}
	
	@Test(timeout = 1000)//1 secondi = 1000 milli
	public void performanceTest() {
		Knapsack ks = new Knapsack(Integer.MAX_VALUE);
		Random rand = new Random();
		for(int i=0;i<1000;i++)
			ks.addItem(new Item(rand.nextInt(),rand.nextInt()));
	}
}
