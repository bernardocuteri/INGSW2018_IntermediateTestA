package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;
import java.util.Random;



import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KnapsackTest {
	
	private static Knapsack knapsack;
	Random rand = new Random();
	
	@BeforeClass
	public static void init() {
		knapsack = new Knapsack(100);
	}
	
	@Before
	public void reset() {
		knapsack.reset();
	}
	
	@Test
	public void TwoUpdates() {
		Item x= new Item(3,4);
		Item y= new Item(2,8);
		knapsack.addItem(x);
		knapsack.addItem(y);
		assertEquals(5, knapsack.getCurrentWeight());
		assertEquals(12, knapsack.getCurrentValue());
		
	}
	
	@Test
	public void ThreeUpdates() {
		Item x= new Item(3,4);
		Item y= new Item(2,8);
		Item z= new Item(7,1);
		knapsack.addItem(x);
		knapsack.addItem(y);
		knapsack.addItem(z);
		knapsack.removeItem(z);
		assertEquals(5, knapsack.getCurrentWeight());
		assertEquals(12, knapsack.getCurrentValue());
		
	}
	
	@Test(expected=RuntimeException.class)
	public void TestExc() {
		Item x= new Item(101,3);
		knapsack.addItem(x);
		
	}
	
	@Test
	public void Best() {
		Item x= new Item(3,4); //1 
		Item y= new Item(2,8); //4
		Item z= new Item(7,1); //0
		Item k= new Item(2,10); //5
		knapsack.addItem(x);
		knapsack.addItem(y);
		knapsack.addItem(z);
		knapsack.addItem(k);
		Item best = knapsack.getBestItem();
		assertEquals(2, best.weight);
		assertEquals(10, best.value);
	}
	
	@Test(timeout = 1000)
	public void Perf() {
		Knapsack knap= new Knapsack(2000);
		Item c= new Item(1,1);
		knap.addItem(c);
		for(int i=1; i<1000; i++)
			c.setWeight(rand.nextInt(1)+1);
			c.setValue(rand.nextInt(20));
			knap.addItem(c);
	}
}















