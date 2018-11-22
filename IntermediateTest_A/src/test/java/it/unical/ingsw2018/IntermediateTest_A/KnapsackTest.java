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
	public void statoEPeso() {
		Item a=new Item(3,4);
		Item b=new Item(4,1);
		knapsack.addItem(a);
		knapsack.addItem(b);
		assertEquals(7, knapsack.getCurrentWeight());
		assertEquals(5,knapsack.getCurrentValue());
	}
	
	@Test
	public void inserimentoEDelete() {
		Item ab=new Item(2,5);
		
		
		
		
		knapsack.addItem(ab);
		knapsack.addItem(new Item(2, 2));
		knapsack.addItem(new Item(3, 4));
		
		knapsack.removeItem(ab);
		
		assertEquals(5, knapsack.getCurrentWeight());
		assertEquals(6,knapsack.getCurrentValue());
	}
	

	@Test
	public void bestItemTest() {
		Item a=new Item(2,6);
		Item b=new Item(6,8);
		Item c=new Item(1,2);
		Item d=new Item(8,3);
		knapsack.addItem(b);
		knapsack.addItem(a);
		knapsack.addItem(c);
		knapsack.addItem(d);
	
		assertEquals(a, knapsack.getBestItem());
	}
	
	@Test(expected = KnapsackInsertionError.class)
	public void eccezioneSollevata() {
		Knapsack temp=new Knapsack(1);
		temp.addItem(new Item(4,9));
		temp.addItem(new Item(7,1));
	}
	
	@Test(timeout=1000)
	public void testDiPerformace() {
		Knapsack test2500 = new Knapsack(2500);
		for(int i=0;i<1000;i++)
			test2500.addItem(new Item((int)Math.random()+1,(int)Math.random()+1));
	}
}