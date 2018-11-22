package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KnapsackTest 
{
	@Test
	public void stateTest()
	{
		Knapsack zaino = new Knapsack(100);
		Item one = new Item(10, 20);
		Item two = new Item(5, 15);
		
		zaino.addItem(one);
		zaino.addItem(two);
		
		assertEquals(15, zaino.getCurrentWeight());
		assertEquals(35, zaino.getCurrentValue());
	}
	
	@Test
	public void removeTest()
	{
		Knapsack zaino = new Knapsack(100);
		Item one = new Item(10, 20);
		Item two = new Item(5, 15);
		Item three = new Item(15, 25);
		
		zaino.addItem(one);
		zaino.addItem(two);
		zaino.addItem(three);
		
		zaino.removeItem(two);
		
		assertEquals(25, zaino.getCurrentWeight());
		assertEquals(45, zaino.getCurrentValue());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException()
	{
		Knapsack zaino = new Knapsack(100);
		Item one = new Item(200, 20);
		
		zaino.addItem(one);
	}
	
	@Test
	public void getBestItem()
	{
		Knapsack zaino = new Knapsack(100);
		Item one = new Item(10, 20);
		Item two = new Item(5, 15);
		Item three = new Item(15, 25);
		Item four = new Item(100, 2);
		
		zaino.addItem(one);
		zaino.addItem(two);
		zaino.addItem(three);
		zaino.addItem(four);
		
		assertEquals(four, zaino.getCurrentValue());
	}
	
	@Test
	public void test1000()
	{
		long inizio = System.currentTimeMillis();
		
		Knapsack zaino = new Knapsack(2000);
		Item one;
		
		for(int i = 0; i < 1000; i++)
		{
			one = new Item(i, i+1);
			zaino.addItem(one);
		}
		
		long fine = System.currentTimeMillis();
		
		long time = fine - inizio;
		
		assertEquals(0, time);
	}

}
