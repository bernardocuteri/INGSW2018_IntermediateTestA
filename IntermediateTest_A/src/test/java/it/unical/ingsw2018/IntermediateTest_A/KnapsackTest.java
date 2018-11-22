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
	public void verify2insert() {
		Item a = new Item (6,3);
		Item b = new Item (24,2);
		
		knapsack.addItem(a);
		knapsack.addItem(b);		
		
		Assert.assertEquals(30, knapsack.getCurrentWeight());
		Assert.assertEquals(5, knapsack.getCurrentValue());
	}
	
	@Test
	public void verify3ins1Remove() {
		Item a = new Item (6,3);
		Item b = new Item (24,2);
		Item c = new Item (5, 5);
		
		
		knapsack.addItem(a);
		knapsack.addItem(b);		
		knapsack.addItem(c);
				
		knapsack.removeItem(b);
		
		Assert.assertEquals(11, knapsack.getCurrentWeight());
		Assert.assertEquals(8, knapsack.getCurrentValue());
	}
	
	@Test (expected=KnapsackInsertionError.class)
	public void testError() {
		Item a = new Item (101,3);
		knapsack.addItem(a);
	}
}
