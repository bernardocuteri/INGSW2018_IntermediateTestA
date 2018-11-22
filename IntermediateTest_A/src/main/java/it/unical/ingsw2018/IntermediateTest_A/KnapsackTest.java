package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class KnapsackTest {
	
	@Test
	public void verifyAfterTwoInsertions()
	{
		Knapsack k = new Knapsack(10);
		k.addItem(new Item(1, 2));
		k.addItem(new Item(3, 2));
		
		assertEquals(4, k.getCurrentWeight());
		assertEquals(4, k.getCurrentValue());
	}
	
	
	@Test
	public void verifyAfterThreeInsertions()
	{
		Knapsack k = new Knapsack(10);
		k.addItem(new Item(1, 2));
		k.addItem(new Item(3, 2));
		
		Item toRemove = new Item(3, 2);
		k.addItem(toRemove);
		k.removeItem(toRemove);
		
		assertEquals(4, k.getCurrentWeight());
		assertEquals(4, k.getCurrentValue());
	}
	
	@Test(expected = KnapsackInsertionError.class)
	public void verifyOverflow()
	{
		Knapsack k = new Knapsack(10);
		k.addItem(new Item(1, 2));
		k.addItem(new Item(3, 2));
		k.addItem(new Item(20, 2));
	}
	
	@Test
	public void verifyBestItem()
	{
		Knapsack k = new Knapsack(10);
		k.addItem(new Item(1, 2));
		k.addItem(new Item(2, 2));
		Item toReturn = new Item(1, 4);
		k.addItem(toReturn);
		k.addItem(new Item(2, 1));
		assertEquals(toReturn, k.getBestItem());
	}
	
	@Test (timeout = 1000)
	public void verifyInsertionOf1000Items(){
		
		Knapsack k = new Knapsack(1000000);
		Random rand = new Random();
		for (int i = 0; i < 1000; i++)
		{
			k.addItem(new Item(rand.nextInt(10) + 1, rand.nextInt(10) + 1));
		}
			
	}

}
