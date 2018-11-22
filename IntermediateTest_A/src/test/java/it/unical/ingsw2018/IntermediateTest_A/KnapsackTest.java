package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

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
	public void twoItemsInsert()  {
		
		knapsack.addItem(new Item(5, 4));
		knapsack.addItem(new Item(6, 3));
		
		assertEquals(knapsack.getCurrentWeight(), 11);
		assertEquals(knapsack.getCurrentValue(), 7);
	}
	
	@Test
	public void threeItemsInsertoneItemRemove()  {
		
		Item a = new Item(1,2);
		Item b = new Item(3,4);
		Item c = new Item(5,6);
		
		knapsack.addItem(a);
		knapsack.addItem(b);
		knapsack.addItem(c);
		knapsack.removeItem(b);
		
		assertEquals(knapsack.getCurrentWeight(), 6);
		assertEquals(knapsack.getCurrentValue(), 8);
	}
	
	@Test(expected = KnapsackInsertionError.class)
	public void overCapacity()  {
		
		knapsack.addItem(new Item(99, 2));
		knapsack.addItem(new Item(2, 2));
	}
	
	
	@Test
	public void verifyBestItem()  {
		
		Item a = new Item(2,2);		//1
		Item b = new Item(2,4);		//2
		Item c = new Item(2,6);		//3
		Item d = new Item(2,8);		//4 = best
		
		knapsack.addItem(a);
		knapsack.addItem(b);
		knapsack.addItem(c);
		knapsack.addItem(d);
		
		assertEquals(d, knapsack.getBestItem());
	}
	
	
	@Test(timeout=1)
	public void verifyRandomItems()  {
		
		Knapsack knapsack2 = new Knapsack(10000);
		Random random = new Random();
		
		for(int i = 0; i < 1000; i++)  {
			knapsack2.addItem(new Item(random.nextInt(10)+1, random.nextInt(10)+1));
		}
	}
}
