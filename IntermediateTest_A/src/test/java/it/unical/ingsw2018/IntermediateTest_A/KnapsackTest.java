package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.ingsw.intermediate_test_a.model.InvalidPlayException;

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
	public void correctAdd() {
		Item item1 = new Item(1, 1);
		Item item2 = new Item(1, 1);
		
		knapsack.addItem(item1);
		knapsack.addItem(item2);

		assertEquals(2, knapsack.getCurrentValue());
		assertEquals(2, knapsack.getCurrentWeight());
		
	
	}
	
	@Test
	public void correctAddRemove() {
		Item item1 = new Item(1, 1);
		Item item2 = new Item(2, 2);
		Item item3 = new Item(3, 3);
		
		
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		knapsack.removeItem(item3);
		

		assertEquals(3, knapsack.getCurrentValue());
		assertEquals(3, knapsack.getCurrentWeight());
		
	
	}
	
	@Test(expected=KnapsackInsertionError.class)
	public void FullException() {
		Item item = new Item(200,1);
		knapsack.addItem(item);
		
		
	}
	
	@Test(timeout=1)
	public void correct1000Item(){
		Knapsack temp = new Knapsack(100000);
		Random r = new Random();
		for(int i=1; i<=1000; i++)
		{
			temp.addItem(new Item(1, i));
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}










