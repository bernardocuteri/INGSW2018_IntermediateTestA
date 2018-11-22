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
	public void checkStateRightAfterTwice() {
		Item item1=new Item(10,10);
		Item item2=new Item(10,10);
		
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		
		
		
		assertEquals(item1.getWeight()+item2.getWeight(),knapsack.getCurrentWeight());
		assertEquals(item1.getValue()+item2.getValue(),knapsack.getCurrentValue());
	}
	
	@Test
	public void checkStateRight() {
		Item item1=new Item(10,10);
		Item item2=new Item(10,10);
		Item item3=new Item(10,10);
		
		knapsack.addItem(item1);
		knapsack.addItem(item2);
		knapsack.addItem(item3);
		
		assertEquals(item1.getWeight()+item2.getWeight()+item3.getWeight(),knapsack.getCurrentWeight());
		assertEquals(item1.getValue()+item2.getValue()+item3.getValue(),knapsack.getCurrentValue());
		
		
		knapsack.removeItem(item3);
		assertEquals(item1.getWeight()+item2.getWeight(),knapsack.getCurrentWeight());
		assertEquals(item1.getValue()+item2.getValue(),knapsack.getCurrentValue());
	}
	
	@Test(expected=KnapsackInsertionError.class)
	public void checkCapacity() {
		Item item1=new Item(110,110);
		knapsack.addItem(item1);
	}
	
	@Test
	public void checkBestItem() {
		Item item1=new Item(10,1);
		Item item2=new Item(1,10);
		Item item3=new Item(1,1);
		Item item4=new Item(2,2);
		
		assertEquals(item2, knapsack.getBestItem());
	}
	

	@Test(timeout=1)
	public void checkInitThousand() {
		Knapsack tmp=new Knapsack(1000);
		Random random=new Random();
		tmp.addItem(new Item(1,random.nextInt(10)));
		
	}
	
	
	
	
}
