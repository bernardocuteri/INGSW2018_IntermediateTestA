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
	public void TestAfter2InsertValue() {
		Item i1=new Item(1,1);
		Item i2=new Item(2,3);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		assertEquals(4, knapsack.getCurrentValue());
		assertEquals(3, knapsack.getCurrentWeight());
		
		
	}
	@Test
	public void TestAfter3InsertValue() {
		Item i1=new Item(1,1);
		Item i2=new Item(2,3);
		Item i3=new Item(2,3);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.removeItem(i3);
		assertEquals(4, knapsack.getCurrentValue());
		assertEquals(3, knapsack.getCurrentWeight());
		
		
	}
	@Test(expected=KnapsackInsertionError.class)
	public void TestException() {
		Item i1=new Item(101,1);
		knapsack.addItem(i1);
		
	}
	@Test
	public void TestBestItem() {
		Item i1=new Item(1,1);
		Item i2=new Item(2,3);
		Item i3=new Item(2,4);
		Item i4=new Item(2,6);
		knapsack.addItem(i1);
		knapsack.addItem(i2);
		knapsack.addItem(i3);
		knapsack.addItem(i4);
		assertEquals(i1, knapsack.getBestItem());
		
		
		
	}
	@Test(timeout=1000)
	public void Insert1000Element() {
		Random random=new Random();
		Knapsack knapsack2 = new Knapsack(1000);
		for(int i=0;i<1000;i++) {
			Item prova=new Item(random.nextInt(),random.nextInt());
			knapsack2.addItem(prova);
		}			
	}
}
