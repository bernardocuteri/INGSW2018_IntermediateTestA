package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

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
	public void testDueInserimenti() {
		Item i1 = new Item(1, 22);
		Item i2 = new Item(1,22);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		assertEquals(2, knapsack.getCurrentWeight());
		assertEquals(44, knapsack.getCurrentValue());
		
	}
	
	@Test
	public void TreInseritiUnoRimosso() {
		knapsack.addItem(new Item(1,22));
		knapsack.addItem(new Item(1,22));
		knapsack.addItem(new Item(3,24));
		knapsack.removeItem(knapsack.getItems().last());
		assertEquals(2, knapsack.getCurrentWeight());
		assertEquals(44, knapsack.getCurrentValue());
	}
	
	@Test(expected=IllegalStateException.class)
	public void capacityFull() {
		
		for(int i = 0;i<101;i++) {
			
		knapsack.addItem(new Item(i,i+1));		

		}
	}
	
	
	
	
}
