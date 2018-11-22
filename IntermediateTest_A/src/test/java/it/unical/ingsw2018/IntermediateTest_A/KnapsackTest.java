package it.unical.ingsw2018.IntermediateTest_A;

import org.junit.Before;

import static org.junit.Assert.fail;

import org.junit.*;
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
	public void metodo1() {
		
		knapsack.addItem(new Item(10, 10));
		knapsack.addItem(new Item(10, 10));
		Assert.assertEquals(20, knapsack.getCurrentValue());
		Assert.assertEquals(20, knapsack.getCurrentWeight());
	
		
	}
	
	@Test
	public void metodo2() {
		
		knapsack.addItem(new Item(10, 10));
		knapsack.addItem(new Item(10, 10));
		Item i=new Item(10, 10);
		knapsack.addItem(i);
		knapsack.removeItem(i);
		Assert.assertEquals(20, knapsack.getCurrentValue());
		Assert.assertEquals(20, knapsack.getCurrentWeight());
	
		
	}
	
	
	@Test(expected=KnapsackInsertionError.class)
	public void sforamentoException()  {
	
					knapsack.addItem(new Item(200, 2));
		
		}
	
	
	
	
}
