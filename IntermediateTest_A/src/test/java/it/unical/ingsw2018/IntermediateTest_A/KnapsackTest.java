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
	public void aggiornamentoCorretto() {
		Item i=new Item(1,1);
		knapsack.addItem(i);
		knapsack.addItem(i);
		assertEquals(2, knapsack.getCurrentWeight());
		assertEquals(2, knapsack.getCurrentValue());
	}
	
	
	@Test(expected = KnapsackInsertionError.class)
	public void Exeption() {
		knapsack.addItem(new Item(101,101));
	}
	
	@Test
	public void eliminaUnElemento()
	{
		knapsack.addItem(new Item(1,1));
		knapsack.addItem(new Item(2,2));
		knapsack.addItem(new Item(3,3));
		knapsack.removeItem(new Item(3,3));
		assertEquals(3, knapsack.getCurrentWeight());
		assertEquals(3, knapsack.getCurrentValue());
		
		
	}
	
	@Test
	public void Best() {
		knapsack.addItem(new Item(1,1));
		knapsack.addItem(new Item(2,2));
		knapsack.addItem(new Item(3,3));
		knapsack.addItem(new Item(1,1));
		assertEquals(new Item(1, 1), knapsack.getBestItem());
	}
	
	@Test(timeout=1000)
	public void milleItem() {
		Knapsack k=new Knapsack(2000);
		for(int i=0; i<1000; i++)
			k.addItem(new Item(1,1));
	}
	
}
