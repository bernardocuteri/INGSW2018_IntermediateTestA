package it.unical.ingsw2018.IntermediateTest_A;

import static org.junit.Assert.assertEquals;

import java.util.Random;

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
	public void status() {
		Item item=new Item(1,2);
		knapsack.addItem(item);
		Item item2=new Item(2,1);
		knapsack.addItem(item2);
		assertEquals(3,knapsack.getCurrentWeight());
		assertEquals(3, knapsack.getCurrentValue());
		
	}
	
	@Test
	public void status2() {
		Item item=new Item(1,2);
		knapsack.addItem(item);
		Item item2=new Item(2,1);
		knapsack.addItem(item2);
		Item item3=new Item(2,3);
		knapsack.addItem(item3);
		knapsack.removeItem(item2);
		assertEquals(3, knapsack.getCurrentWeight());
		assertEquals(5, knapsack.getCurrentValue());
		
	}
	
	@Test(expected=KnapsackInsertionError.class)
	public void err() {
		Item item=new Item(1,2);
		knapsack.addItem(item);
		Item over=new Item(100,3);
		knapsack.addItem(over);
	}
	
	@Test
	public void best() {
		Item item=new Item(1,2);
		Item item2= new Item(3,12);
		Item item3=new Item(2,6);
		Item item4=new Item(1,1);
		knapsack.addItem(item4);
		knapsack.addItem(item3);
		knapsack.addItem(item2);
		knapsack.addItem(item);
		assertEquals(4, knapsack.getBestItem());
	}
	
	@Test(timeout=1000)
	public void kunit() {
		int low=0;
		int high=10;
		Random r=new Random();
		Random r2=new Random();
		Knapsack knapsack2=new Knapsack(1000000000);
		for(int i=0; i<1000; i++) {
			int result=r.nextInt(high-low)+low;
			int result2=r2.nextInt(high-low)+low;
			System.out.print(result);
			Item item=new Item(result,result2);
			knapsack2.addItem(item);
		}
	}
}
