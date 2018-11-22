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
	public void InsertTwoElement() {
		knapsack.addItem(new Item(2,3));
		knapsack.addItem(new Item(3,3));
		assertEquals(6,knapsack.getCurrentValue());
		assertEquals(5,knapsack.getCurrentWeight());
	}
	
	@Test
	public void InsertThreeElement() {
		Item item = new Item(4,4);
		knapsack.addItem(item);
		knapsack.addItem(new Item(2,3));
		knapsack.addItem(new Item(3,3));
		knapsack.removeItem(item);
		assertEquals(6,knapsack.getCurrentValue());
		assertEquals(5,knapsack.getCurrentWeight());
	}
	
	@Test (expected=KnapsackInsertionError.class)
	public void OverCapacity() {
		knapsack.addItem(new Item(101,200));	
	}
	
	@Test
	public void BestItem() {
		knapsack.addItem(new Item(3,3));
		knapsack.addItem(new Item(3,9));
		knapsack.addItem(new Item(3,6));
		knapsack.addItem(new Item(3,15));
		Item item = knapsack.getBestItem();
		assertEquals(15,item.value);
		assertEquals(3,item.weight);
	}

	
	@Test (timeout=1000)
	public void TimeControl() {
		Knapsack sack = new Knapsack(10000);
		Random rand = new Random();
		for(int i=0;i<1000;i++) {
			sack.addItem(new Item(rand.nextInt(2)+1,rand.nextInt(5)+1));
		}
	}
}
