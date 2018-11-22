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
    public void inserisci2Item() {
        Item a = new Item (6,3);
        Item b = new Item (24,2);
        
        knapsack.addItem(a);
        knapsack.addItem(b);
        
        
        Assert.assertEquals(30, knapsack.getCurrentWeight());
        Assert.assertEquals(5, knapsack.getCurrentValue());
	}
	
	@Test
	public void inserisci3Item() {
		Item a = new Item(6,3);
		Item b = new Item(24,2);
		Item c = new Item(20,4);
		
		knapsack.addItem(a);
		knapsack.addItem(b);
		knapsack.addItem(c);
		
		knapsack.removeItem(c);
		
		Assert.assertEquals(30, knapsack.getCurrentWeight());
        Assert.assertEquals(5, knapsack.getCurrentValue());
		
        
        
		
        
        
	}
	
	
	
	@Test
	public void verificaBestItem()
	{
		Item a = new Item (6,3);
		Item b = new Item (24,2);
		Item c = new Item (12,2);
		Item d = new Item (4,4);
	
	
		knapsack.addItem(a);
		knapsack.addItem(b);
		knapsack.addItem(c);
		knapsack.addItem(d);
	
		Assert.assertEquals(b, knapsack.getBestItem());
		
	}
	
	
	@Test(expected = KnapsackInsertionError.class)
	public void knapsackException() {
		Knapsack temp = new Knapsack(1);
		temp.addItem(new Item(3, 6));
		temp.addItem(new Item(5, 2));
	}
	
	
	@Test(timeout = 1000)
	public void performanceTest() {
		Knapsack test1 = new Knapsack(2000);
		for (int i = 0; i < 1000; i++)
			test1.addItem(new Item((int) (Math.random()*100) + 1, (int) (Math.random()*100) + 1));
	}
	
}